package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Feijao;

@Service
public class FeijaoService {

	private Map<Integer, Feijao> mapaFeijao = new HashMap<Integer, Feijao>();

	public void incluir(Feijao Feijao) {
		mapaFeijao.put(Feijao.getCodigo(), Feijao);
	}
	
	public Collection<Feijao> obterLista(){	
		return mapaFeijao.values();
	}
}