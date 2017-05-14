package br.com.redefatec.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;


import br.com.redefatec.model.Professor;
import br.com.redefatec.service.ProfessorService;
@ManagedBean(name = "professorLazyView")
@ViewScoped
public class LazyViewProfessor implements Serializable{
private LazyDataModel<Professor> lazyModel;
@ManagedProperty("#{professorService}")
private ProfessorService professorService;
private Professor selectedProfessor;
@PostConstruct
public void init(){
	lazyModel = new LazyProfessorDataModel(professorService.mostrarTodos());
}
public LazyDataModel<Professor> getLazyModel() {
	return lazyModel;
}
public void setLazyModel(LazyDataModel<Professor> lazyModel) {
	this.lazyModel = lazyModel;
}
public ProfessorService getProfessorService() {
	return professorService;
}
public void setProfessorService(ProfessorService professorService) {
	this.professorService = professorService;
}
public Professor getSelectedProfessor() {
	return selectedProfessor;
}
public void setSelectedProfessor(Professor selectedProfessor) {
	this.selectedProfessor = selectedProfessor;
}
public void onRowSelect(SelectEvent event){
	FacesMessage msg = new FacesMessage("Professor Selecionado",((Professor)event.getObject()).getId().toString());
}
}
