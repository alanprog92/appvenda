package br.edu.infnet.appvenda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appvenda.model.domain.Produto;
import br.edu.infnet.appvenda.model.domain.Vendedor;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer>{

}