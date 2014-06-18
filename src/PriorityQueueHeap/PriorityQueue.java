/*
* Classe para o TAD fila de prioridade
 */

package PriorityQueueHeap;

public class PriorityQueue implements Tipo_PriorityQueue, Tipo_Tree {
    
    private Entry[] elements;  		/** array elements do tipo Entry */ 
    private int maxSize = 100; 		/** tamanho maximo do array elements */ 
    private int currentSize;   		/** numero de elementos ocupados no array */ 
        
    public PriorityQueue(){ 					   /** construtor para a fila de prioridades */
        this.elements = new Entry[this.maxSize+1]; /** cria um novo objeto Entry e retorna a referencia pro mesmo */
        this.currentSize = 0; 					   /** inicializa a variavel */
    }
    
    @Override
    public boolean insert(Entry el) {    /** insere um item el=(key,info) com chave key */
        if(currentSize == maxSize){		/** verifica se o numero de elementos usados eh igual ao tamanho maximo do array */	
            return false;
        }
        if(!this.existKey(el.getKey(), this.elements[1])){
	        System.out.println("------------------------------------");
	        System.out.println("Inserting element: ["+(currentSize+1)+":{"+el.getKey()+","+el.getInfo()+"}]");
	        el.setPosition(++currentSize);		/** atualiza a variavel currentSize*/
	        this.elements[currentSize] = el;    /** incrementa o currentSize e insere o novo item no indice n+1 */     
	        this.bubblingUp(currentSize);		  /** restauracao da ordem do heap */
	        System.out.println("------------------------------------");
	        return true;
        }
        else{
        	return false;
        }
    }
    
    @Override
    public boolean isEmpty(){  		/** Verifica se a fila de prioridade esta vazia */
        return this.size()==0;
    }
    
    @Override
    public Entry get() {    		/** Retorna o item com maior prioridade da fila, sem remove-lo */
    	System.out.println("------------------------------------");
    	Entry element = this.elements[1];    /** retorna a raiz */
    	if(element != null){
    		System.out.println("Get element: ["+(1)+":{"+element.getKey()+","+element.getInfo()+"}]");
    	}
    	else{
    		System.out.println("Empty Priority Queue ");  /** pilha vazia*/
    	}
    	System.out.println("------------------------------------");
        return  element;
    } 
    
    public Entry remove(){  /** remove e retorna o item com maior prioridade da fila de prioridades */
    	System.out.println("------------------------------------");
    	Entry element = this.elements[1];
    	if(element != null){
	        System.out.println("Remove element: ["+(1)+":{"+element.getKey()+","+element.getInfo()+"}]");
	    	
	        this.swap(1, this.currentSize);
	    	this.elements[1].setPosition(1);
	    	this.elements[this.currentSize--] = null; /** atualiza a variavel currentSize*/
	    	
	    	//this.printHeap();
	    	
	    	if(currentSize>1){
	    		bubblingDown();
	    	}
    	}
    	else{
    		System.out.println("Empty Priority Queue ");
    	}
    	
    	System.out.println("------------------------------------");
    	return element;
    }
        
    public void printHeap(){	 /** Imprime o heap */
        Entry el;
        
        System.out.println("PriorityQueue print - format=[ind:{key,info}]\n");  /** impressao no formato item (chave, informacao) */
        for(int i=1; i<=this.currentSize; i++){     /** percorre todo o arranjo */
            el = this.elements[i];
            System.out.print("["+i+":{"+el.getKey()+","+el.getInfo()+"}] ");
            if(checkIfItsPowerOf2(i+1)){    /** verifica se um numero e potencia de 2 */	 
            	System.out.println();
            }
            else if(i==this.currentSize){
            	System.out.println();
            }
        }
        
    }
    
    public int size(){    /** Retorna o numero de itens em uma fila de prioridade */
        /*int count = 0;
        for(int i=0; i<this.elements.length; i++){
            if(this.elements[i]!=null) count++;
        }
        for(Entry e: elements){
            if(e!=null) count++;
        }*/
        return this.currentSize; 
    }
    
    public Entry[] heapSort(){        /** algoritmo de ordenacao heap-sort para testar o Fila de Prioridade*/
    	int size = this.size();
    	Entry entryResult[] = new Entry[size]; 
    	System.out.println("------------------------------------");
        System.out.println("Heap Sort - format=[ind:{key,info}]");
        for(int i=0; i<size; i++){
        	entryResult[i] = this.remove();
        }
        System.out.println("------------------------------------");
    	
    	return entryResult;
    }
   
    private void bubblingUp(int element_pos){	/** Executa o bubbling up */
        Entry el = this.elements[element_pos];
        Entry parent;
        int tmp_pos;
                
        if(!isRoot(el)){ 	/** Verifica se o item e a raiz */
            parent = this.parent(el);
            
            while(!isRoot(el) && (parent != null) && (el.getKey() < parent.getKey())){
            	/*System.out.println("\nSwap");
            	System.out.println("Element["+el.getPosition()+"]: "+el.getKey());
                System.out.println("Parent["+parent.getPosition()+"]: "+parent.getKey());*/
            	
            	this.swap(el.getPosition(), parent.getPosition());   /**Chama metodo para realizar a troca os elementos dessas posicoes */
            	
            	tmp_pos = el.getPosition(); /** atualiza a posicao */
            	el.setPosition(parent.getPosition());
            	parent.setPosition(tmp_pos);
            	               
                parent = this.parent(el);
                
                //this.printHeap();
            }
        }
        
    }
    
    private void bubblingDown(){ 		/** Executa o bubbling down */
    	Entry el = this.elements[1]; 
        Entry left=null, right=null, child=null; 	
        int tmp_pos;
        
        left = this.leftChild(el);			/** left recebe a referencia pro filho da esquerda */
        right = this.rightChild(el);		/** right recebe a referencia pro filho da direita */
        
        while(left!=null || right!=null){
        	if(left!=null && right!=null){
        		if(left.getKey() < right.getKey()){
            		child = left;
            	}
            	else{
            		child = right;
            	}
        	}
        	else if(left!=null){
        		child = left;
        	}
        	else if(right!=null){
        		child = right;
        	}
        	
        	if(child.getKey() < el.getKey()){
	        	/*System.out.println("\nSwap");
	        	System.out.println("Element["+el.getPosition()+"]: "+el.getKey());
	        	System.out.println("Child["+child.getPosition()+"]: "+child.getKey()+"\n");*/
	        	
	        	this.swap(el.getPosition(), child.getPosition());
	        	tmp_pos = el.getPosition();
	        	el.setPosition(child.getPosition());
	        	child.setPosition(tmp_pos);
	        	left = this.leftChild(el);
	            right = this.rightChild(el);
        	}
        	else{
        		left = null;
	            right = null;
        	}
            //this.printHeap();
        }        
        
    }
    
    private boolean existKey(int keyArg, Entry entry){   /** verifica se uma chave existe no heap */
    	if(entry != null){								
	    	if(entry.getKey() < keyArg){
	    		return(existKey(keyArg, this.leftChild(entry)) || existKey(keyArg, this.rightChild(entry)));
	    	}
	    	else if(entry.getKey() == keyArg){ /** se a chave a ser inserida for igual a uma ja existente */
	    		return true;
	    	}
    	}
		return false;
    }

    private boolean checkIfItsPowerOf2(int n){  /** para garantir a ordem da arvore*/

      	 if( (n & -n) == n){		
      	  return true;		   	
      	 }					  
      	 else{
      	  return false;		  
      	 }
      }
    
    public boolean isRoot(Entry el){    /** Verifica se o item e a raiz */
        return (el.getPosition() == 1);
    }
   
    public Entry parent(Entry el){	    /** Retorna a referencia para o elemento pai do item ou nulo se o item e a raiz */
        int pos = el.getPosition();
        if(pos == 1)					
            return null;
        return this.elements[(pos/2)]; /** O pai de um elemento � sempre elemento/2 */
    }
        
    public Entry leftChild(Entry el){    /** Retorna a referencia para o item filho esquerdo */
    	int pos = el.getPosition();
    	if((pos*2)>this.maxSize){		/** verifica se eh filho esquerdo de um elemento, elemento*2 */
    		return null;
    	}
    	return this.elements[pos*2];
    }
    
    public Entry rightChild(Entry el){   /** Retorna a referencia para o item filho direito */
    	int pos = el.getPosition();
    	if((pos*2 + 1)>this.maxSize){    /** verifica se eh filho direito de um elemento, (elemento*2)+1 */
    		return null;
    	}
    	return this.elements[pos*2 + 1];
    }
        
    public void swap(int pos_one, int pos_two){  /** troca os itens do heap armazenados nos elementos referenciados por pos_one e pos_two */
        Entry tmp = this.elements[pos_one];		 /** variavel temporaria tmp para realizar a troca */
        this.elements[pos_one] = this.elements[pos_two];
        this.elements[pos_two] = tmp;
    }
    
    
}
