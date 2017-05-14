package br.com.redefatec.view;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

import br.com.redefatec.model.Materia;

public class LazySorterMateria implements Comparator<Materia>{
	private String sortField;
	private SortOrder sortOrder;
	public LazySorterMateria(String sortField, SortOrder sortOrder){
		this.sortField = sortField;
		this.sortOrder = sortOrder;
	}

	@Override
	public int compare(Materia mat1, Materia mat2) {
		// TODO Auto-generated method stub
		try{
			Object value1 = Materia.class.getField(this.sortField).get(mat1);
			Object value2 = Materia.class.getField(this.sortField).get(mat2);
			int value = ((Comparable)value1).compareTo(value2);
			return SortOrder.ASCENDING.equals(sortOrder) ? value: -1 * value;
		}
		catch(Exception e){
			throw new RuntimeException();
		}
	}

}
