//	Authors: Patrick Granieri and Nick Gatehouse
//	ID's: pgranier@calpoly.edu and ngatehou@calpoly.edu
//	Project 3,  11/5/2015

import java.lang.*;
import java.Math.*;


public class HashTable{
	
	private class HashEntry{

		public Object element;
		public boolean isActive;

		public HashEntry(Object x){
			element = x;
			isActive = true;
		}

	}	

//Hello , Hi (:

	private HashEntry[] table;
	private int occupiedCells;

	public HashTable(int size){
		table = new HashEntry[nextPrime(2*size)];
		occupiedCells = 0;
	}

	private static int nextPrime(int n){
		int prime = n;
		for(int i = 2; i <= prime/2; i++){
			if(prime%i==0){
				prime++;
				i=1;
			}
		}
		return prime;
	}	

	private class Iter implements Iterator{ // ** check constructor and next method
		
		int cursor; // the index of an array cell

		public Iter(){
			cursor = 0;
			int i = 0;
			while(i < table.length){ // <=?
				i++;
				if(!table[i].isActive){ // 
					cursor = i;
					break;
				}
			}
			if(i == table.length){ // indicates all entries were active
				cursor = table.length;
			}			
		}


		public boolean hasNext(){
			return cursor < table.length;		
		}


		public Object next(){
			Object answer =table[cursor].element;
			int i = 0;
			while(i < table.length){
				i++;
				if(!table[i].isActive){ // first hash entry that isn't active
					cursor = i;
					break;
				}
			}
			if(i == table.length){ // indicates that all entries are active
				throw new NoSuchElementException();
			}
			return answer;
		}

		public void remove(){
			//Throws an error if called. 
			throw new UnsupportedOperationException();
		}
	}

	public void insert(Object item){ 
		int index = findPosition(item);

		if(table[index] == null){orrect)
			table[index] = new HashEntry(item);
			occupiedCells++;
			if( !(occupiedCells < (table.length/2)) ){
				rehash();
			}
		}else{
			if(!table[index].isActive){ 
				table[index].isActive = true;
			}
		}
	}

	private void rehash(){
		HashEntry[] temp = table;
		table = new HashEntry[nextPrime(temp.length*2)]
		occupiedCells = 0;

		for(int i = 0; i < temp.length; i++){
			if(temp[i] != null && temp[i].isActive){
				int index = findPosition(temp[i].element);
				table[index] = new HashEntry(temp[i].element);
				occupiedCells++;
			}
		}
	}

	private int findPosition(Object item){
		int i = 0;
		int hashValue = hash(item); // what is hash? hashCode()?
		int index = hashValue;
		while(table[index] != null && table[index].element != item){
			i++;
			index = (hashValue+Math.pow(i,2))%table.length;
		}
		return index;

	}

	public void delete(Object item){
		int index = findPosition(item);
		if(table[index] != null && table[index].isActive){
			table[index].isActive = false;
		} 
	} 

	public Object find(Object item){
		int index = findPosition(item);
		if(table[index] != null && table[index].isActive){
			return table[index].element;
		}else{
			return null;
		}
	}

	public int elementCount(){
		int sum = 0; 
		for(int i = 0; i < table.length; i++){
			if(table[i] != null && table[i].isActive){ 
				sum++;
			}
		}
		return sum;
	}

	public boolean isEmpty(){
		boolean answer = true; // assume empty
		for(int i = 0; i < table.length; i++){
			if(table[i] != null && table[i].isActive){ // as soon as it finds an active member we know it isnt empty
				answer = false;
			}
		}
		return answer;
	}

	public void makeEmpty(){
		for(int i = 0; i < table.length; i++){
			table[i] = null;
		}
	}

	public void printTable(){
		for(int i = 0 ; i < table.length; i++){
			if(table[i] == null){
				System.out.println("[" + i + "]: " + "empty");
			}else if(table[i].isActive){
				System.out.println("[" + i + "]: " + table[i].element + ", " + "active");
			}else{
				System.out.println("[" + i + "]: " + table[i].element + ", " + "inactive");
			}
		}
	}

	public Iterator iterator(){
		return new Iter();
	}

}