package br.com.redefatec.view;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

import br.com.redefatec.model.Professor;

public class LazySorterProfessor implements Comparator<Professor>{
	private String sortField;
	private SortOrder sortOrder;
	public LazySorterProfessor(String sortField, SortOrder sortOrder){
		this.sortField = sortField;
		this.sortOrder = sortOrder;
	}
	@Override
	public int compare(Professor p1, Professor p2) {
		// TODO Auto-generated method stub
		try{
			Object value1 =  Professor.class.getField(this.sortField).get(p1);
			Object value2 = Professor.class.getField(this.sortField).get(p2);
			int value = ((Comparable)value1).compareTo(value2);
			return SortOrder.ASCENDING.equals(sortOrder) ? value: -1 * value;
		}
		catch(Exception e){
			throw new RuntimeException();
		}
	}

}
