//	Authors: Patrick Granieri and Nick Gatehouse
//	ID's: pgranier@calpoly.edu and ngatehou@calpoly.edu
//	Project 4, 10/13/2015

import java.util.*;
import java.lang.*;

public class HashTable { //non-generic HashTable containing an array of HashEntry objects 

	private class HashEntry { // Object that will contain all entries, individually, into the hash table, 
		public Object element; // Contains the actual item being added to the table
		public boolean active; //This boolean represents if the item hs been deleted or not,
		
		public HashEntry(Object element){ //Creates a new entry into the table, taking the item in as the only parameter. 
			this.element = element;
			this.active = true;
		}
	}

	private HashEntry[] table; //This array will hold the hash table.
	private int occupied; //Indicates how many slots in the table have an active or inactive entry

	public HashTable(int collection){ //Creates the table, using a size that is a prime number at least 2 times bigger then the argument.
		int size = nextPrime(2*collection);
		table = new HashEntry[size];
		occupied = 0;
	}

	private static int nextPrime(int num){ //Finds the next prime after the given parameter.
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
		implements Iterator { //Iterator that will progress through the table in order of hash key.

		private int cursor; //Holds the index of the next value;

		public Iter(){ //Creates the Iterator, putting the cursor at the first possible value;
			cursor = 0;
			while(cursor < table.length && (table[cursor]==null || !table[cursor].active)){
				cursor++;
			}
		}

		public boolean  hasNext(){ //Indicates if there is another value in the hash table.
			return cursor < table.length;
		}

		public Object next(){ //Returns the next value in the hash table if there is one, and updates the cursor.
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

		public void remove(){ // Unsupported Operation
			throw new UnsupportedOperationException();
		}
	}

	public void insert(Object item){ //Inserts this value into the hash table as a HashEntry Object, if it is not already inside. 
		int index = findPosition(item);

		if (table[index] == null) {
			table[index] = new HashEntry(item);
			occupied++;

			if(occupied>=table.length/2){
				rehash();
			}
		} else {
			table[index].active = true;
		}
	}

	private void rehash(){ //Increases the size of the hash table, and places active HashEntries at their new locations according to the lenght. 
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

	public void delete(Object item){ //Makes an entry inside of the Hash Table inactive. 
		int index = findPosition(item);
		if (table[index] != null && table[index].active) {
			table[index].active = false;
		}
	}

	public Object find(Object item){ //Returns the object if it is found active within the table; null if otherwise. 
		int index = findPosition(item);
		if (table[index] != null && table[index].active) {
			return table[index].element;
		} else {
			return null;
		}
	}

	private int findPosition(Object item){ //Returns the index of the location where this item should be placed. 
		int i = 0;
		int hashValue = hash(item);
		int index = hashValue;
		while(table[index]!=null && !table[index].element.equals(item)){
			i++;
			index = (hashValue + (int) Math.pow(i,2))%table.length;
		}

		return index;
	}

	private int hash(Object item){ // returns the hashcode for the given object
		return Math.abs(item.hashCode())%table.length;
	}

	public int elementCount() { // returns the number of active elements within the table
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

	public boolean isEmpty(){ // checks to see if all the elements in the table are inactive or empty
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

	public void makeEmpty(){ // makes all HashEntries in the table empty
		for (int i = 0; i < table.length; i++) {
			table[i] = null;
		}
		occupied = 0;
	}

	public void printTable() { // prints contents of the Hash Table in the specified order
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

	public Iterator iterator(){ // constructor for the user to create an iterator
		return new Iter();
	}
}
