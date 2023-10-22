package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Soja;

@Service
public class SojaService {

	private Map<Integer, Soja> mapaSoja = new HashMap<Integer, Soja>();

	public void incluir(Soja Soja) {
		mapaSoja.put(Soja.getCodigo(), Soja);
	}
	
	public Collection<Soja> obterLista(){	
		return mapaSoja.values();
	}
}