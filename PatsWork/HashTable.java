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

	private static int nextPrime(int num){
		int prime = num;

		for (int i = 2; i <= prime/2; i++){
			if (prime%i == 0){
				prime++;
				i=1;
			}
		}
		return prime;
	}

	private class Iter 
		implements Iterator {

		private int cursor;

		public Iter(){
			cursor = 0;
			while(cursor < table.length && (!table[cursor].active)){
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

			while(cursor < table.length && (table[cursor] == null || !table[cursor].active)) {
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
		HashEntry[] temp = table;
		int index;

		table = new HashEntry[nextPrime(temp.length*2)];
		occupied = 0;

		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != null && temp[i].active) {
				index = findPosition(temp[i].element);
				table[index] = temp[i];
				occupied++;
			}
		}	
	}

	public void delete(Object item){
		int index = findPosition(item);
		if (table[index] != null && table[index].active) {
			table[index].active = false;
		}
	}

	public Object find(Object item){
		int index = findPosition(item);
		if (table[index] != null && table[index].active) {
			return table[index].element;
		} else {
			return null;
		}
	}

	private int findPosition(Object item){
		int i = 0;
		int hashValue = hash(item);
		int index = hashValue;

		while(table[index]!=null && table[index].element != item){
			i++;
			index = (hashValue + (int) Math.pow(i,2))%table.length;
		}

		return index;
	}

	private int hash(Object item){
		return Math.abs(item.hashCode())%table.length;
	}

	public int elementCount() {
		int cursor = 0;
		int sum = 0;

		while(cursor < table.length){
			if (table[cursor] != null && table[cursor].active) {
				sum++;
			}
			cursor++;
		}

		return sum;
	}

	public boolean isEmpty(){
		boolean empty = true;

		for (int i = 0; i < table.length; i++) {
			if(table[i] != null && table[i].active)
			{
				empty = false;
				break;
			}
		}
		return empty;
	}

	public void makeEmpty(){
		for (int i = 0; i < table.length; i++) {
			table[i] = null;
		}
		occupied = 0;
	}

	public void printTable() {
		for (int i = 0; i<table.length; i++){
			System.out.print("[" + i + "]: ");
			if (table[i] == null){
				System.out.println("empty");
			} else if (table[i].active) {
				System.out.println(table[i].element + ", " + "active");
			} else {
				System.out.println(table[i].element + ", " + "inactive");
			}
		}
	}

	public Iterator iterator(){
		return new Iter();
	}


	public static void main(String args[]){
		HashTable hash = new HashTable(4);
		System.out.println(nextPrime(4));
		System.out.println("Attempting to add: 5");
		hash.insert(5);
		hash.insert(16);
		hash.insert(27);
		hash.insert(38);

		hash.printTable();

		hash.insert(0);
		hash.insert(2);

		hash.printTable();
	}
}
