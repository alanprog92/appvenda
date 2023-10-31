package br.edu.infnet.appvenda.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Soja;
import br.edu.infnet.appvenda.repository.SojaRepository;

@Service
public class SojaService {

	@Autowired
	SojaRepository sojaRepository;
	
	public void incluir(Soja soja) {
		sojaRepository.save(soja);
	}
	
	public Collection<Soja> obterLista(){	
		return (Collection<Soja>) sojaRepository.findAll();
	}
}