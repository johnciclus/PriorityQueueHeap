/*
* Classe Java para criacao do arquivo Heap_Sort.txt, com N < 200 linhas
 */

package PriorityQueueHeap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataFile {
	private int keys[];			  						/** atributo chave */	
	private String information[]; 						/** atributo informacao */
	private String filename;     						/** atributo nome do arquivo */
	
	public DataFile(){									/** metodo construtor */
		this.keys = new int[100]; 	 					/** array de chaves com 100 elementos */
		this.information =  new String[100]; 			/** array de informacoes com 100 elementos */
		this.filename = "Heap_Sort.txt";				/** nome do arquivo */
	}
	
	public void generateData(){			 				/** metodo para a geracao de arquivo */
		int key;
                
        boolean exist;									/** variavel que verifica se a posicao ja foi ocupada no arquivo */
        
        System.out.println("Keys: [");
        for(int i=0; i<100; i++){						/** percorre o array de chaves */
        	do{
        		exist = false;							/** fazer enquanto a chave nao existir no arquivo*/
	        	key = this.generatekey();				/** chamada ao metodo generateKey() */
	        	for(int j=0; j<i; j++){  				/** percorre o array*/
	        		if(this.keys[j] == key) 			/** verifica se a prosicao esta ocupada*/
	        			exist = true;        		
	        	}
        	}while(exist);
        	
        	this.keys[i] = key; 						/** array de chaves recebe as chaves */
        	this.information[i] = this.generateInfo();	/** chamada ao metodo */
        	System.out.print(this.keys[i]+",");			/** imprimi as chaves*/
        	if((i+1)%20==0)								/** */
        		System.out.println(); 
        }
        System.out.println("]");
	}
	
	public Entry generateEntry(){									/** metodo para gerar a entrada */
		return new Entry(this.generatekey(), this.generateInfo());  
	}
	
	public int generatekey(){
		return (int)Math.round(Math.random()*99.99999);   /** cria chaves inteiras aleatorias entre 0 e 99 */
	}
	
	public String generateInfo(){
		StringBuilder info;
		
		info = new StringBuilder(8);	/** cria um construtor de strings com 8 caracteres */
    	for(int j=0; j<8; j++){			/** percorre os 8 caracteres do string  */
    		info.append(Character.toChars(97 + (int)Math.round(Math.random()*25)));  /** cria a informacao aleatoria de a ate z e acrescenta ao construtor*/
    	}
		return info.toString();
	}
	
	public void createFile() throws IOException{    /** cria o arquivo que esta na pasta PriorityQueueHeap */
		this.generateData();						/** chama o metodo de geracao do arquivo */
		try{											
			FileWriter fstream = new FileWriter(this.filename); /** */
			BufferedWriter out = new BufferedWriter(fstream);   /** */
			for(int i=0; i<100; i++){							/** percorre as linhas do arquivo */
				out.write(this.keys[i]+"\n");			/** escreve a chave no arquivo */
				out.write(this.information[i]+"\n");	/** escreve a informacao no arquivo */
			}
			out.close();				/** fecha o arquivo */
			System.out.println("------------------------------------");
			System.out.println("File save as: "+this.filename);      /** imprimi na tela que o arquivo foi gerado e salvo */
			System.out.println("------------------------------------");
		}
		catch (Exception e){			/** */
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	public void readFile(){			/** le o arquivo Heap_Sort.txt */
		try{
			FileReader fstream = new FileReader(this.filename); /** */
			BufferedReader in = new BufferedReader(fstream);	/** */
			String value;
			int count = 0;
			
			this.keys = new int[100];
			this.information = new String[100];
			
			while((value = in.readLine())!=null){                /** */
				if((count%2) == 0){								 /** */
					this.keys[count/2] = Integer.valueOf(value); /** */
				}else{
					this.information[(count-1)/2] = value;		/** */
				}
				count++;
			}
			in.close();      /** fecha o arquivo */
			System.out.println("------------------------------------");
			System.out.println("Read file: "+this.filename+" with "+count+" lines");    /** le o arquivo */
			System.out.println("------------------------------------");
		}
		catch (Exception e){		/** Catch exception if any */
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	public void setKeys(int keysArgs[]){
		this.keys = keysArgs;
	} 
	
	public int[] getKeys(){			/** Retorna a chave armazenado no arquivo */
		return this.keys; 
	}
	
	public void setInformation(String informationArgs[]){
		this.information = informationArgs;
	} 
	
	public String[] getInformation(){		/** Retorna a informacao armazenado no arquivo */
		return this.information; 
	}
}
