package br.com.redefatec.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.redefatec.enums.DiaSemana;

@Entity
//@IdClass(MateriaProfessorId.class)
@Table(name="aula")
@AssociationOverrides({
	@AssociationOverride(name = "pk.professor",
		joinColumns = @JoinColumn(name = "id_professor")),
	@AssociationOverride(name = "pk.materia",
		joinColumns = @JoinColumn(name = "id_materia")) })
public class Aula implements Serializable{

	
	private String sala;
	private Date horarioInicio;
	private Date horarioTermino;
	private DiaSemana dia;
	private MateriaProfessorId pk = new MateriaProfessorId();
	@EmbeddedId
	public MateriaProfessorId getPk(){
		return pk;
	}
	public void setPk(MateriaProfessorId pk){
		this.pk= pk;
	}
	@Transient
	public Materia getMateria(){
		return getPk().getMateria();
	}
	public void setMateria(Materia materia){
		getPk().setMateria(materia);
	}
	@Transient
	public Professor getProfessor(){
		return getPk().getProfessor();
	}
	public void setProfessor(Professor professor){
		getPk().setProfessor(professor);
	}

	@Column(name="sala")
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
	@Column(name="horarioInicio")
	public Date getHorarioInicio() {
		return horarioInicio;
	}
	public void setHorarioInicio(Date horario) {
		this.horarioInicio = horario;
	}
	@Column(name="dia")
	public DiaSemana getDia() {
		return dia;
	}
	public void setDia(DiaSemana dia) {
		this.dia = dia;
	}
	@Column(name="horarioTermino")
	public Date getHorarioTermino() {
		return horarioTermino;
	}
	public void setHorarioTermino(Date horarioTermino) {
		this.horarioTermino = horarioTermino;
	}
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Aula that = (Aula) o;

		if (getPk() != null ? !getPk().equals(that.getPk())
				: that.getPk() != null)
			return false;

		return true;
	}

	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}

}
