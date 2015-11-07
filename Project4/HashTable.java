//	Authors: Patrick Granieri and Nick Gatehouse
//	ID's: pgranier@calpoly.edu and ngatehou@calpoly.edu
//	Project 3,  11/5/2015

import java.lang.*;
import java.Math.*;

// check for understanding; is HashTable full of 
//hashentryobjects with element and isActive equal to null
// or is each cell considered null until we call the hash entry
// constructor... not sure how to check table[i] is empty 

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
				i=2;
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
			if(i == table.length-1){ // (table.length or -1?)indicates that all entries are active
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
			if(i == table.length-1){ // indicates that all entries are active
				throw new NoSuchElementException();
			}
			return answer;
		}

		public void remove(){
			//Throws an error if called. 
			throw new UnsupportedOperationException();
		}
	}

	public void insert(Object item){ //***
		int index = findPosition(item);
		if(table[index] == null){ // says check if it's empty? (pretty sure null check is incorrect)
			table[index] = new HashEntry(item);
			occupiedCells++;
			if( !(occupiedCells < (table.length/2)) ){
				rehash();
			}
		}else{
			if(!table[index].isActive){ // duplicate check?
				table[index].isActive = true;
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
		if(table[index]) // stopped here
	} // hi patrick :D

	public Object find(Object item){

	}

	public int elementCount(){

	}

	public boolean isEmpty(){

	}

	public void makeEmpty(){

	}

	public void printTable(){

	}

	public Iterator iterator(){
		return new Iter();
	}

}