package br.com.redefatec.service;

import java.util.List;

import br.com.redefatec.model.Aula;
import br.com.redefatec.repository.AulaRepository;

public interface AulaService {
public void transacaoSave(Aula aula);
public List<Aula> mostrarTodas();
public void excluir(Long id);
public void setAulaRepository(AulaRepository aulaRepository);
public AulaRepository getAulaRepository();
}
