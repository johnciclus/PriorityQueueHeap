/*
* Interface Java para o TAD fila de prioridade
 */

package PriorityQueueHeap;

public interface Tipo_PriorityQueue {
    
    public int size(); /** Retorna o numero de elementos armazenados na fila de prioridades */
    public boolean isEmpty(); /** Retorna se a fila de prioridade esta vazia */
    public boolean insert(Entry el); /** Insere um item (key,info) com chave key e retorna true, 
                                    caso nao exista o item na fila com a mesma chave key. Se ja
                                    existir o item na fila com a mesma chave de Key, retorna false */
    
    public Entry remove(); /** Remove e retorna o item com maior prioridade da fila */
    public Entry get();    /** Retorna o item com maior prioridade da fila, sem remove-lo */
}
