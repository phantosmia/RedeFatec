package br.com.redefatec.view;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.redefatec.model.Professor;
public class LazyProfessorDataModel extends LazyDataModel<Professor>{
	private List<Professor> datasource;

	public LazyProfessorDataModel(List<Professor> datasource) {
		this.datasource = datasource;
	}

	@Override
	public Professor getRowData(String rowKey) {
		for(Professor professor : datasource) {
			if(professor.getId().equals(rowKey)){
				return professor;
			}
		}
		return null;
	}

	@Override
	public Object getRowKey(Professor professor) {
		return professor.getId();
	}

	@Override
	public List<Professor> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
		List<Professor> data = new ArrayList<Professor>();
		//filter
		for(Professor professor : datasource) {
			boolean match = true;

			if (filters != null) {
				for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
					try {

						String filterProperty = it.next();
						Object filterValue = filters.get(filterProperty);
						String fieldValue  = null;
						try{
							fieldValue = String.valueOf(professor.getClass().getField(filterProperty).get(professor));
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
				data.add(professor);
			}
		}

		//sort
		if(sortField != null) {
			Collections.sort(data, new LazySorterProfessor(sortField, sortOrder));
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
