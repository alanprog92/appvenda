package br.edu.infnet.appvenda.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Feijao;
import br.edu.infnet.appvenda.model.repository.FeijaoRepository;

@Service
public class FeijaoService {

	@Autowired
	FeijaoRepository feijaoRepository;
	
	public void incluir(Feijao Feijao) {
		
		feijaoRepository.save(Feijao);
		
	}
	
	public Collection<Feijao> obterLista(){	
		return (Collection<Feijao>) feijaoRepository.findAll();
	}
}