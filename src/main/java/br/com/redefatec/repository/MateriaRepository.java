package br.com.redefatec.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.redefatec.model.Materia;


public interface MateriaRepository extends CrudRepository<Materia,Long>{
	 @Query("SELECT m FROM Materia m where m.id = ?1")
	public Materia findById(Long id);
}
