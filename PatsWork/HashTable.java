import java.util.*;
import java.lang.*;

public class HashTable {

	private class HashEntry {
		public Object element;
		public boolean active;
		
		public HashEntry(Object element, boolean active){
			this.element = element;
			this.active = active;
		}
	}

	HashEntry[] table;
	int occupied;

	public HashTable(int collection){
		int size = nextPrime(2*collection);

		table = new HashEntry[size];

		occupied = 0;
	}

	private int nextPrime(int num){
		int primte = num;
		for (int i = 2; i <= prime/2; i++){
			if (prime%i == 0){
				prime ++;
				i=1;
			}
		}
		return prime;
	}

	private Iter class 
		implements Iterator {

		private int cursor;

		public Iter(){
			cursor = 0;
			while(cursor < table.length && (!table[i].active)){
				cursor ++;
			}
		}

		public boolean  hasNext(){
			return cursor < table.length;
		}

		public Object next(){
			if (!hasNext()){
				throw new NoSuchElementException();
			}

			Object nextVal = table[cursor].element;
			cursor++;

			while(cursor < table.length && (table[i] == null || !table[i].active)) {
				cursor++;
			}

			return nextVal;

		}

		public void remove(){
			throw new UnsupportedOperationException();
		}
	}

	public void insert(Object item){
		int index = findPosition(item);

		if (table[index] == null) {
			table[index] = new HashEntry(item, true);
			occupied++;

			if(occupied>=table.length/2){
				rehash();
			}
		} else {
			table[index].active = true;
		}
	}

	private void rehash(){
		
	}

	public void delete(Object item){
	
	}

	public Object find(Object item){
	
	}

	private int findPosition(Object item){
		int i = 0;
		int hashValue = hash(item);
		int index = hashValue;

		while(table[index]!=null && table[index].element != item){
			i++;
			index = (hashValue+pow(i,2))%table.length;
		}

		return index;
	}

	private int hash(Object item){
		return Math.abs(item.hashCode())%table.length;
	}
}
