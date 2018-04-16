package Memento;

import java.util.ArrayList;

public class Caretaker {
	
	private ArrayList<Memento> mList = new ArrayList<Memento>();
	//add memento to ArrayList
	public void addMemento(Memento m){
		mList.add(m);
		System.out.println("caretaker:"+mList.size());
		printCaretaker();
	} 
	//get the version of memento form caretaker
	public Memento getMemento(int index){
		return mList.get(index);
	}
	//Print the memento
	public void printCaretaker(){
		for(Memento m:mList){
			m.printMemento();
			
		}
	}
	

}
