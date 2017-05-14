package br.com.redefatec.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.redefatec.model.Professor;
import br.com.redefatec.service.ProfessorService;

@ManagedBean(name = "professorController", eager = true)
@SessionScoped
public class ProfessorController {
private Long id;
private String nome;
@ManagedProperty(value="#{professorService}")
private ProfessorService professorService;
private Professor professor;
private List<Professor> professores = new ArrayList<Professor>();
public void removerProfessor(){
	professorService.excluir(id);
	professores = professorService.mostrarTodos();
}
public void addProfessor() throws IOException{
	Professor professorSave = new Professor();
	String nome = getNome();
	professorSave.setNome(nome);
	professorService.transacaoSave(professorSave);
	professores.add(professorSave);
	setNome("");
	FacesContext.getCurrentInstance().getExternalContext().redirect("exibirProfessor.xhtml");
	professor = null;
}
public void mudouProfessor(){
	nome = professor.getNome();
}
@PostConstruct
public void init(){
	professores = professorService.mostrarTodos();
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
}
public ProfessorService getProfessorService() {
	return professorService;
}
public void setProfessorService(ProfessorService professorService) {
	this.professorService = professorService;
}
public Professor getProfessor() {
	return professor;
}
public void setProfessor(Professor professor) {
	this.professor = professor;
}
public List<Professor> getProfessores() {
	return professores;
}
public void setProfessores(List<Professor> professores) {
	this.professores = professores;
}

}
