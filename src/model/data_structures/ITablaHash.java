package model.data_structures;

public interface ITablaHash<K, V> extends Iterable<K> {
	
	
	/**
	 * Inserta un nuevo elemento en la tabla 
	 * @param Key la llave del nuevo elemento
	 * @param Value el valor asociado a la llave
	 */
	void put(K key,	V value);
	
	
	/**
	 * Busca un elemento dentro de la tabla 
	 * @param Key la llave a buscar en la tabla
	 */
	V get(K key);
	
	
	
	/**
	 * Elimina un elemento de la tabla
	 * @param Key la llave a eliminar en la tabla
	 */
	V delete(K key);
	
	
	
	/**
	 * Da el tamaño de la tabla
	 */
	int darTamano();
}
