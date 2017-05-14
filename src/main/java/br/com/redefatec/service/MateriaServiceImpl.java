package br.com.redefatec.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.redefatec.model.Materia;
import br.com.redefatec.repository.MateriaRepository;
import javax.faces.bean.ManagedBean;
@Service("materiaService")
@Transactional
public class MateriaServiceImpl implements MateriaService{
	@Autowired
	private MateriaRepository materiaRepository;
	private List<Materia> materias;
	List<Materia> retorno;
	@Override
	public void transacaoSave(Materia materia) {
		// TODO Auto-generated method stub
		materiaRepository.save(materia);
	}

	@Override
	public List<Materia> mostrarTodas() {
		// TODO Auto-generated method stub
		if(retorno == null){
			retorno = new ArrayList<Materia>();
			for(Materia materia: materiaRepository.findAll()){
				retorno.add(materia);
			}
		}
		System.out.println("25");
		return retorno;
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		materiaRepository.delete(id);
	}

	@Override
	public void setMateriaRepository(MateriaRepository materiaRepository) {
		// TODO Auto-generated method stub
		this.materiaRepository = materiaRepository;
	}

	@Override
	public MateriaRepository getMateriaRepository() {
		// TODO Auto-generated method stub
		return materiaRepository;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

}
