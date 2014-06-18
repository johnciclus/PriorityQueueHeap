/*
* Interface Java para o TAD arvore
 */

package PriorityQueueHeap;

public interface Tipo_Tree {
	 
	public int size(); /** Retorna o numero de elementos armazenados na fila de prioridades */
    public boolean isEmpty(); /** Retorna se a fila de prioridade esta vazia */
	public boolean isRoot(Entry el); /** Verifica se o item e a raiz */
	public Entry parent(Entry el);    /** Retorna a referencia para o elemento pai do item ou nulo se o item e a raiz */
	public Entry leftChild(Entry el);  /** Retorna a referencia para o item filho esquerdo */
	public Entry rightChild(Entry el);  /** Retorna a referencia para o item filho direito */
	public void swap(int pos_one, int pos_two);  /** troca os itens do heap armazenados nos elementos referenciados por pos_one e pos_two */
	
	
}
