package br.com.redefatec.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.redefatec.model.Aula;
import br.com.redefatec.repository.AulaRepository;

@Service("aulaService")
@Transactional
public class AulaServiceImpl implements AulaService{
	@Autowired
	private AulaRepository aulaRepository;
	private List<Aula> aulas;
	@Override
	public void transacaoSave(Aula aula) {
		// TODO Auto-generated method stub
		System.out.println(aulaRepository);
		System.out.println("this is sparta"+aula);
		aulaRepository.save(aula);
	}

	@Override
	public List<Aula> mostrarTodas() {
		// TODO Auto-generated method stub
		List<Aula> retorno = new ArrayList<Aula>();
		for(Aula aula: aulaRepository.findAll()){
			retorno.add(aula);
		}
		return retorno;
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		aulaRepository.delete(id);
	}

	@Override
	public void setAulaRepository(AulaRepository aulaRepository) {
		// TODO Auto-generated method stub
		this.aulaRepository = aulaRepository;
	}

	@Override
	public AulaRepository getAulaRepository() {
		// TODO Auto-generated method stub
		return aulaRepository;
	}

	public List<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}
	

}
