/*
* Classe Java para uma entrada que armazena o par chave e informacao em uma fila de prioridade
 */

package PriorityQueueHeap;

public class Entry implements Tipo_Entry{
    
    private int chave;	  /** atributo para chave */    
    private String info;  /** atributo para chave */    
    private int position; /** atributo position que guarda a posicao no arranjo de cada elemento */
    
    public Entry(int keyArg, String infoArg){ /** Construtor */
        this.chave = keyArg;
        this.info = infoArg;
    }
    
    public void setKey(int keyArg){  /** Atibuicao */
        this.chave = keyArg;
    }    
    
    public int getKey(){  /** Retorna uma chave armazenada nesta entrada */
        return this.chave;
    }
    
    public void setInfo(String infoArg){ /** Atibuicao*/
        this.info = infoArg;
    }
    
    public String getInfo(){  /** Retorna um valor armazenado nesta entrada */
        return info;
    }    

    public int getPosition(){  /** Retorna uma posicao de um elemento no arranjo */
    	return this.position;
    }
    
    public void setPosition(int pos){
    	this.position = pos;
    }
}
