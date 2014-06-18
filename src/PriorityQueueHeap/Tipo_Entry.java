/*
* Interface Java para o TAD entrada par (chave, informacao)
 */

package PriorityQueueHeap;

public interface Tipo_Entry {
	
	public void setKey(int Key);
	public int getKey();  					/** Retorna uma chave armazenada nesta entrada */
	public void setInfo(String infoArg);	/** Atibuicao*/
	public String getInfo(); 				/** Retorna um valor armazenado nesta entrada */    
	public int getPosition(); 				/** Retorna uma posicao de um elemento no arranjo */
	public void setPosition(int pos);

}
