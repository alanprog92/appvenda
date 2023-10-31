package br.edu.infnet.appvenda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appvenda.model.domain.Soja;

@Repository
public interface SojaRepository extends CrudRepository<Soja, Integer>{

}