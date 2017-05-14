package br.com.redefatec.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.redefatec.model.Materia;

public class LazyMateriaDataModel extends LazyDataModel<Materia> {

	private List<Materia> datasource;

	public LazyMateriaDataModel(List<Materia> datasource) {
		this.datasource = datasource;
	}

	@Override
	public Materia getRowData(String rowKey) {
		for(Materia materia : datasource) {
			if(materia.getId().equals(rowKey)){
				return materia;
			}
		}
		return null;
	}

	@Override
	public Object getRowKey(Materia materia) {
		return materia.getId();
	}

	@Override
	public List<Materia> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
		List<Materia> data = new ArrayList<Materia>();
		//filter
		for(Materia materia : datasource) {
			boolean match = true;

			if (filters != null) {
				for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
					try {

						String filterProperty = it.next();
						Object filterValue = filters.get(filterProperty);
						String fieldValue  = null;
						try{
							fieldValue = String.valueOf(materia.getClass().getField(filterProperty).get(materia));
						}
						catch(Exception e){
							System.out.println(e.getMessage());
						}
						if(filterValue == null || fieldValue.startsWith(filterValue.toString())) {
							match = true;
						}
						else {
							match = false;
							break;
						}
					} catch(Exception e) {
						match = false;
					}
				}
			}

			if(match) {
				data.add(materia);
			}
		}

		//sort
		if(sortField != null) {
			Collections.sort(data, new LazySorterMateria(sortField, sortOrder));
		}

		//rowCount
		int dataSize = data.size();
		this.setRowCount(dataSize);

		//paginate
		if(dataSize > pageSize) {
			try {
				return data.subList(first, first + pageSize);
			}
			catch(IndexOutOfBoundsException e) {
				return data.subList(first, first + (dataSize % pageSize));
			}
		}
		else {
			return data;
		}
	}
}