package br.com.redefatec.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="Materia" )
public class Materia implements Serializable {

public Long id;

public String nome;
public Set<Aula> aulas = new HashSet<Aula>(0);
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name = "id")
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
@Column(name="name")
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.materia", cascade=CascadeType.ALL)
public Set<Aula> getAulas(){
	return this.aulas;
}
public void setAulas(Set<Aula>aulas){
	this.aulas = aulas;
}
@Override
public int hashCode() {
    int hash = 7;
    hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
    return hash;
}

@Override
public boolean equals(Object obj) {
    if (obj == null) {
        return false;
    }
    if (getClass() != obj.getClass()) {
        return false;
    }
    final Materia other = (Materia) obj;
    if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
        return false;
    }
    return true;
}
@Override
public String toString() {
    return nome;
}
}
