package br.com.redefatec.enums;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="data")
@ApplicationScoped
public class DataDiaSemana {
	private DiaSemana diaSemanas;
	public DiaSemana[] getDiaSemanas(){
		return DiaSemana.values();
	}
	public void setDiaSemanas(DiaSemana diaSemanas) {
		this.diaSemanas = diaSemanas;
	}
	
}
