import java.util.*;
import java.lang.Math.*;

public class L13HashTable<T>{
	LinkedList<T>[] table;

	public L13HashTable(int size){
		table = (LinkedList<T>[]) new LinkedList[size];
		for(int i = 0; i < size; i++){
			table[i] = new LinkedList();
		}
	}

	private class Iterator<T> Iter implements Iterator<T>{
		int i;
		int j;

		public Iter(){
			i = 0;
			while(i < table.length && table[i].size() == 0){
				i++;
			}
			j = 0; 
		}

		public void remove(){
			throw new unsupportedOperationException();
		}

		public boolean hasNext(){
			return i < table.length;
		}

		public T next(){
			if(!hasNext()){
				throw new noSuchElementException();
			}
			T value = table[i].get(j);

			if(j+1 < table[i].size()){
				j++;
			}else{
				i++;
				while(i < table.length && table[i].size() == 0){
					i++;
				}
				j = 0;
			}
		}
	}

	public Iterator<t> iterator(){
		return new Iter();
	}


	private int hash(T item){
		return Math.abs(item.hashCode()) % table.length;
	}

	public void insert(T item){
		int index = hash(item);
		table[index].addFirst(item);
	}

	public void delete(T item){
		int index = hash(item);
		table[index].remove();
	}

	public boolean find(T item){
		int index = hash(item);
		return table[index].contains(item);
	}

	public boolean isEmpty(){
		boolean answer = true; // assume empty
		for(int i = 0; i< table.length;i++){
			if(table[i].size() > 0){
				answer = false; // found a list that wasn't empty
			}
		}
		return answer;
	}

	public void makeEmpty(){
		for(int i = 0; i < table.length;i++){
			table[i].clear();
		}
	}

	public int size(){
		int sum = 0;
		for(int i = 0 ; i< table.length; i++){
			if(table[i].size() > 0){
				sum += table[i].size();
			}
		}
		return sum;
	}

	public void print(){
		
		for(int i = 0; i < table.length;i++){
			System.out.print(i + ": ");
			for(int j = 0; j < table[i].size(); j++){
				System.out.print(table[i].get(j) + " ");
			}	
			System.out.println();		
		}
	}
}