package br.edu.infnet.appvenda.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appvenda.model.domain.Feijao;

@Repository
public interface FeijaoRepository extends JpaRepository<Feijao, Integer>{

}