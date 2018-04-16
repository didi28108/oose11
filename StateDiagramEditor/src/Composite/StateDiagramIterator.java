package Composite;
import java.util.*;

public class StateDiagramIterator implements Iterator {

	private ArrayList<DiagramElement> items;
	private int position = 0;
	
	public StateDiagramIterator(ArrayList<DiagramElement> component) {
		this.items = component;
	}
	
	public boolean hasNext() {
		
		//It's index is not found or out of range then return false 
		if ( items == null || position >= items.size() || items.get(position) == null){
			return false;
		}
		return true;
	}

	public Object next() {
		//Go to next item
		if ( items != null && position < items.size()){
			DiagramElement menuItem = items.get(position++);
			return menuItem.getName();
		}
		return null;
	}
		
}
