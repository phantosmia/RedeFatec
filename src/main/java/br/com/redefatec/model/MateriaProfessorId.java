package br.com.redefatec.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class MateriaProfessorId implements Serializable{
private Professor professor;
private Materia materia;
@ManyToOne
public Professor getProfessor(){
	return professor;
}
public void setProfessor(Professor professor){
	this.professor = professor;
}
@ManyToOne
public Materia getMateria(){
	return materia;
}
public void setMateria(Materia materia){
	this.materia = materia;
}
public boolean equals(Object o){
	if(this == o) return true;
	if(o == null || getClass() != o.getClass()) return false;
	MateriaProfessorId that = (MateriaProfessorId) o;
	if (professor != null ? !professor.equals(that.professor) : that.professor!=null) return false;
	if(materia != null ? !materia.equals(that.materia) : that.materia != null) return false;
	return true;
}
public int hashCode(){
	int result;
	result = (professor != null ? professor.hashCode() :0);
	result = 31 * result + (materia != null ? materia.hashCode() : 0);
	return result;
}
}
