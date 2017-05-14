package br.com.redefatec.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.com.redefatec.enums.DiaSemana;
import br.com.redefatec.model.Aula;
import br.com.redefatec.model.Materia;
import br.com.redefatec.model.MateriaProfessorId;
import br.com.redefatec.model.Professor;
import br.com.redefatec.service.AulaService;

@ManagedBean(name = "aulaController",eager = true)
@SessionScoped
public class AulaController {

private String sala;
private Date horarioInicio;
private Date horarioTermino;
private DiaSemana dia;
private Materia materia;
private Professor professor;
private MateriaProfessorId pk = new MateriaProfessorId();
@ManagedProperty(value="#{aulaService}")
private AulaService aulaService;
private Aula aula;
private List<Aula> aulas = new ArrayList<Aula>();
public void removerAula(){
	
	aulas = aulaService.mostrarTodas();
}
public void addAula(){
	System.out.println("aula service:"+aulaService);
	Aula aulaSave = new Aula();
	String sala = getSala();
	Materia materia = getMateria();
	Professor professor = getProfessor();
	
	Date horarioInicio = getHorarioInicio();
	Date horarioTermino = getHorarioTermino();
	DiaSemana dia = getDia();
	MateriaProfessorId pk = getPk();
	aulaSave.setSala(sala);
	aulaSave.setHorarioInicio(horarioInicio);
	aulaSave.setHorarioTermino(horarioTermino);
	System.out.println(aulaSave.getHorarioTermino());
	aulaSave.setDia(dia);
	aulaSave.setPk(pk);
	aulaSave.setMateria(materia);
	aulaSave.setProfessor(professor);
	System.out.println(materia);
	System.out.println(professor);
	//materia.getAulas().add(aulaSave);
	//professor.getAulas().add(aulaSave);
	System.out.println(aulaSave);
	System.out.println(materia);
	System.out.println(professor);
	System.out.println("materia setada no controller:"+getMateria());
	System.out.println("professor setado no controller:"+getProfessor());
	System.out.println(aulaService);
	//aulaService.transacaoSave(aulaSave);
	aulas.add(aulaSave);
	aula = null;
}
public void mudouAula(){
	
	sala = aula.getSala();
	horarioInicio = aula.getHorarioInicio();
	horarioTermino = aula.getHorarioTermino();
	dia = aula.getDia();
	pk = aula.getPk();
}
@PostConstruct
public void init(){
	aulas = aulaService.mostrarTodas();
}

public void setId(Long id) {
	
}
public String getSala() {
	return sala;
}
public void setSala(String sala) {
	this.sala = sala;
}
public Date getHorarioInicio() {
	return horarioInicio;
}
public void setHorarioInicio(Date horario) {
	this.horarioInicio = horario;
}
public DiaSemana getDia() {
	return dia;
}
public void setDia(DiaSemana dia) {
	this.dia = dia;
}
public MateriaProfessorId getPk() {
	return pk;
}
public void setPk(MateriaProfessorId pk) {
	this.pk = pk;
}
public AulaService getAulaService() {
	return aulaService;
}
public void setAulaService(AulaService aulaService) {
	this.aulaService = aulaService;
}
public Aula getAula() {
	return aula;
}
public void setAula(Aula aula) {
	this.aula = aula;
}
public List<Aula> getAulas() {
	return aulas;
}
public void setAulas(List<Aula> aulas) {
	this.aulas = aulas;
}
public Date getHorarioTermino() {
	return horarioTermino;
}
public void setHorarioTermino(Date horarioTermino) {
	this.horarioTermino = horarioTermino;
}
public Materia getMateria() {
	return materia;
}
public void setMateria(Materia materia) {
	this.materia = materia;
}
public Professor getProfessor() {
	return professor;
}
public void setProfessor(Professor professor) {
	this.professor = professor;
}

}
