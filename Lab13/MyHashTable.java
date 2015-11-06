import java.util.*;
import java.lang.*;

public class MyHashTable<T> {
	LinkedList<T>[] table;

	public MyHashTable(int size){
		table = (LinkedList<T>[]) new LinkedList[size];
		for (int i = 0; i<size; i++) {
			table[i] = new LinkedList<T>();
		}
	}

	private class Iter implements Iterator<T>{
		int i;
		int j;

		public Iter(){
			i = 0;
			LinkedList<T> dummy = table[i];
			System.out.println(dummy == null);
			while(dummy.size() == 0){
				i++;
				dummy = table[i];
			}
			j = 0;
		}

		public boolean hasNext(){
			return i<table.length;
		}

		public T next(){
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			System.out.println("i: " + i + "; j: " + j);
			T element = table[i].get(j);
			if(table[i].get(j+1) != null){
				j++;
			}else{
				i++;
				while(table[i] == null && hasNext()) {
					i++;
				}
				j = 0;
			}
			return element;
		}

		public void remove(){
			throw new UnsupportedOperationException();
		}
	}

	public Iterator<T> iterator(){
		return new Iter();
	}

	private int hash(T item){
		return Math.abs(item.hashCode()) % table.length;
	}

	public int size(){
		int sum = 0;

		for(int i = 0; i<table.length; i++) {
			sum += table[i].size();
		}

		return sum;
	}

	public void makeEmpty(){
		for(int i = 0; i<table.length; i++) {
			table[i].clear();
		}
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
				System.out.print(table[lineNum].get(itemNum) + " ");
			}
			System.out.println();
		}
	}

}