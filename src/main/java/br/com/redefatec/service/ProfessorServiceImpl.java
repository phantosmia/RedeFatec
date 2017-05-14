package br.com.redefatec.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.redefatec.model.Professor;
import br.com.redefatec.repository.ProfessorRepository;
@Service("professorService")
@Transactional
public class ProfessorServiceImpl implements ProfessorService{
	@Autowired
	private ProfessorRepository professorRepository;
	private List<Professor> professores;
	@Override
	public void transacaoSave(Professor professor) {
		// TODO Auto-generated method stub
		professorRepository.save(professor);
	}

	@Override
	public List<Professor> mostrarTodos() {
		// TODO Auto-generated method stub
		List<Professor> retorno = new ArrayList<Professor>();
		for(Professor professor: professorRepository.findAll()){
			retorno.add(professor);
		}
		return retorno;
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		professorRepository.delete(id);
	}

	@Override
	public void setProfessorRepository(ProfessorRepository professorRepository) {
		// TODO Auto-generated method stub
		this.professorRepository = professorRepository;
	}

	@Override
	public ProfessorRepository getProfessorRepository() {
		// TODO Auto-generated method stub
		return professorRepository;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

}
