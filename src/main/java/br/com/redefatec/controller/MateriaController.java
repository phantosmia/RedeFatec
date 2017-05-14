package br.com.redefatec.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.redefatec.model.Materia;
import br.com.redefatec.service.MateriaService;

@ManagedBean(name="materiaController", eager = true)
@SessionScoped
public class MateriaController {
private Long id;
private String nome;

@ManagedProperty(value="#{materiaService}")
private MateriaService materiaService;
private Materia materia;
private List<Materia> materias = new ArrayList<Materia>();
public void removerMateria(){
	materiaService.excluir(id);
	materias = materiaService.mostrarTodas();
}
public void addMateria() throws IOException{
	System.out.println("materiaService"+materiaService);
	Materia materiaSave = new Materia();
	String nome = getNome();
	materiaSave.setNome(nome);
	materiaService.transacaoSave(materiaSave);
	materias.add(materiaSave);
	materia = null;
	FacesContext.getCurrentInstance().getExternalContext().redirect("exibirMateria.xhtml");
	setNome("");
}
public void mudouMateria(){
	nome = materia.getNome();
}
@PostConstruct
public void init(){
	materias = materiaService.mostrarTodas();
	System.out.println(materiaService);
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
	System.out.println(materiaService);
}
public MateriaService getMateriaService() {
	return materiaService;
}
public void setMateriaService(MateriaService materiaService) {
	this.materiaService = materiaService;
}
public Materia getMateria() {
	return materia;
}
public void setMateria(Materia materia) {
	this.materia = materia;
}
public List<Materia> getMaterias() {
	return materias;
}
public void setMaterias(List<Materia> materias) {
	this.materias = materias;
}

}
