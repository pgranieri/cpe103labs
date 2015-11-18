import java.util.*;
import java.lang.Math.*;

public class L12HashTableSC<T>{
	LinkedList<T>[] table;

	public L12HashTableSC(int size){
		table = (LinkedList<T>[]) new LinkedList[size];
		for(int i = 0; i < size; i++){
			table[i] = new LinkedList();
		}
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