package br.com.redefatec.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;

import br.com.redefatec.model.Materia;
import br.com.redefatec.service.MateriaService;

@ManagedBean(name="materiaLazyView")
@ViewScoped
public class LazyViewMateria implements Serializable{
private LazyDataModel<Materia> lazyModel;
@ManagedProperty("#{materiaService}")
private MateriaService materiaService;
private Materia selectedMateria;
@PostConstruct
public void init(){
	lazyModel = new LazyMateriaDataModel(materiaService.mostrarTodas());
}
public LazyDataModel<Materia> getLazyModel() {
	return lazyModel;
}
public void setLazyModel(LazyDataModel<Materia> lazyModel) {
	this.lazyModel = lazyModel;
}
public MateriaService getMateriaService() {
	return materiaService;
}
public void setMateriaService(MateriaService materiaService) {
	this.materiaService = materiaService;
}
public Materia getSelectedMateria() {
	return selectedMateria;
}
public void setSelectedMateria(Materia selectedMateria) {
	this.selectedMateria = selectedMateria;
}
public void onRowSelect(SelectEvent event){
	FacesMessage msg = new FacesMessage("Materia Selecionada",((Materia)event.getObject()).getId().toString());
}

}
