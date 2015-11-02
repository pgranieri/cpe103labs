import java.util.*;
import java.lang.*;

public class HashTableSC<T> {
	LinkedList<T>[] table;

	public HashTableSC(int size){
		table = (LinkedList<T>[]) new LinkedList[size];
		for (int i = 0; i<size; i++) {
			table[i] = new LinkedList();
		}
	}

	private int hash(T item){
		return Math.abs(item.hashCode()) % table.length;
	}

	public void insert(T item) {
		int hashVal = hash(item);
		table[hashVal].addFirst(item);
	}

	public void delete(T item){
		int hashVal = hash(item);
		table[hashVal].remove(item);
	}

	public boolean find(T item) {
		int hashVal = hash(item);
		boolean found = table[hashVal].contains(item);
		return found;
	}

	public boolean isEmpty(){
		boolean empty = true;

		for(int i = 0; i < table.length; i++){
			if (table[i].size() != 0) {
				empty = false;
			}
		}

		return empty;
	}

	public void print(){
		for(int lineNum = 0; lineNum < table.length; lineNum++){
			System.out.print(lineNum + ": ");
			for (int itemNum = 0; itemNum < table[lineNum].size(); itemNum++) {
				System.out.print(table[lineNum].get(itemNum) + ", ");
			}
			System.out.println();
		}
	}

}