package br.com.redefatec.service;

import java.util.List;

import br.com.redefatec.model.Professor;
import br.com.redefatec.repository.ProfessorRepository;

public interface ProfessorService {
public void transacaoSave(Professor professor);
public List<Professor> mostrarTodos();
public void excluir(Long id);
public void setProfessorRepository(ProfessorRepository professorRepository);
public ProfessorRepository getProfessorRepository();
public List<Professor> getProfessores();
}
