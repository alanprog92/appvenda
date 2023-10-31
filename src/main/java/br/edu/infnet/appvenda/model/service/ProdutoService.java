package br.edu.infnet.appvenda.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Produto;
import br.edu.infnet.appvenda.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
	
	public void incluir(Produto produto) {
		produtoRepository.save(produto);
	}
	
	public Collection<Produto> obterLista(){	
		return (Collection<Produto>) produtoRepository.findAll();
	}
}