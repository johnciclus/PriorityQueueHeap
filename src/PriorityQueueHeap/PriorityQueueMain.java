/*
* Classe Principal Java
 */

package PriorityQueueHeap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PriorityQueueMain {

    public static void main(String[] args) throws IOException {
    	PriorityQueue F = new PriorityQueue(); /** fila de prioridade F */
    	DataFile DT = new DataFile();		/** manipulacao de arquivo */
    	
    	String option = "";
    	BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
    	
    	while(!option.equals("0")){
    		printMenu();
    		Entry tmp;
    		Entry entries[];
    		try{
    			option = (String)bufferRead.readLine();
    			System.out.println("------------------------------------");
    		}
    		catch(IOException e)
    		{
    			e.printStackTrace();
    		}	
			
    		if(option.equals("1")){
				demostration();
			}	
			else if(option.equals("2")){
				System.out.println("Entry-format=[ind:{key,info}]");  /** impressao no formato item (chave, informacao) */
				tmp = DT.generateEntry();
				if(!F.insert(tmp))
					System.out.println("Repeated key: "+tmp.getKey());	
			}
			else if(option.equals("3")){
				System.out.println("Entry-format=[ind:{key,info}]");  /** impressao no formato item (chave, informacao) */
				tmp = F.get();
			}
			else if(option.equals("4")){
				System.out.println("Entry-format=[ind:{key,info}]");  /** impressao no formato item (chave, informacao) */
				tmp = F.remove();
			}
			else if(option.equals("5")){
				System.out.println("Entry-format=[ind:{key,info}]");  /** impressao no formato item (chave, informacao) */
				entries = F.heapSort();
			}
			else if(option.equals("6")){
				System.out.println("Size: "+F.size());
				System.out.println("------------------------------------");
			}
			else if(option.equals("7")){
				System.out.println("isEmpty: "+F.isEmpty());
				System.out.println("------------------------------------");
			}
			else if(option.equals("8")){
				F.printHeap();
				System.out.println("------------------------------------");
			}
			else if(option.equals("9")){
				entries = F.heapSort();
				DT.readFile();
				int keys[] = DT.getKeys();
		        String[] infos = DT.getInformation();
		        
		        for(int i=0; i < keys.length; i++){		/** percorre o array ate a quantidade de elementos ocupados */
		        	F.insert(new Entry(keys[i], infos[i]));	/** insere a quantidade dos elementos definidos em quantityTest */
		        }
				
				System.out.println("------------------------------------");
			}
			else if(option.equals("0")){
				System.out.println("Good Bye");
			}
    	}
    }
    
    public static void printMenu(){
    	System.out.println("|---------------------------------------------------------------------|");
    	System.out.println("|                     Priority Queue Main                             |");
    	System.out.println("|                                                                     |");
    	System.out.println("| 1. Demostration                   6. Size                           |");
    	System.out.println("| 2. Insert                         7. Is Empty                       |");
    	System.out.println("| 3. Get                            8. Print Queue Heap               |");
    	System.out.println("| 4. Remove                         9. Read File                      |");
    	System.out.println("| 5. HeapSort                       0. Exit                           |");
    	System.out.println("|---------------------------------------------------------------------|");
    }
    
    public static void demostration(){
    	System.out.println("------------------------------------");
    	System.out.println("     Priority Queue Demostration    ");
    	System.out.println("Test with 20 Entries");
        System.out.println("------------------------------------");
    	
    	PriorityQueue F = new PriorityQueue(); /** fila de prioridade F */
        DataFile DT = new DataFile();		/** manipulacao de arquivo */
        
        //DT.createFile();   /** metodo que gera os dados e o arquivo */
        
        DT.readFile();								/**le o arquivo */
        
        int keys[] = DT.getKeys();
        String[] infos = DT.getInformation();
        Entry tmp;
        int quantityTest = 20;						/** quantidade de itens ocupados no array */
        
        for(int i=0; i < quantityTest; i++){		/** percorre o array ate a quantidade de elementos ocupados */
        	F.insert(new Entry(keys[i], infos[i]));	/** insere a quantidade dos elementos definidos em quantityTest */	
            
            /*System.out.println("------------------------------------");
            F.printHeap();
            System.out.println("------------------------------------");*/
        }
        
        System.out.println("------------------------------------");
        F.printHeap();								/** metodo que imprime a fila de prioridade em heap */
        System.out.println("------------------------------------"); 
        
        tmp = F.get();								/** metodo para obter o elemento de maior prioridade*/
        
        tmp = F.remove();							/** metodo para obter e remover o elemento de maior prioridade*/
                
        System.out.println("------------------------------------");
        F.printHeap();								/** metodo que imprime a fila de prioridade em heap */
        System.out.println("------------------------------------");
        
        F.heapSort();								/** metodo de ordenacao heapsort que imprime em ordem ascendente*/
    }
}
