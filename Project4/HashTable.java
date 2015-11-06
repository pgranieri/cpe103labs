//	Authors: Patrick Granieri and Nick Gatehouse
//	ID's: pgranier@calpoly.edu and ngatehou@calpoly.edu
//	Project 3,  11/5/2015

public class HashTable{
	
	private class HashEntry{

		public Object element;
		public boolean isActive;

		public HashEntry(Object x){
			element = x;
			isActive = true;
		}

	}

	private HashEntry[] table;
	private int occupiedCells;

	public HastTable(int size){
		table = new HashEntry[nextPrime(2*size)];
		occupiedCells = 0;
	}

	private static int nextPrime(int n){
		
	}

	private class Iter implements Iterator<T>{
		
		int cursor; // the index of an array cell

		public Iter(){
			cursor = 0;

			
		}


		public boolean hasNext(){
			return cursor < table.length;		
		}


		public T next(){
		

		}


		public void remove(){
			//Throws an error if called. 
			throw new UnsupportedOperationException();
		}
	}
}