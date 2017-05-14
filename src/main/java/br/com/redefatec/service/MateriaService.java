package br.com.redefatec.service;

import java.util.List;

import br.com.redefatec.model.Materia;
import br.com.redefatec.repository.MateriaRepository;

public interface MateriaService {
	public void transacaoSave(Materia materia);
	public List<Materia> mostrarTodas();
	public void excluir(Long id);
	public void setMateriaRepository(MateriaRepository materiaRepository);
	public MateriaRepository getMateriaRepository();
	public List<Materia> getMaterias();
}
