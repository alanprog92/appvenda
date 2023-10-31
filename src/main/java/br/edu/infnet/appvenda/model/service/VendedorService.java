package br.edu.infnet.appvenda.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.repository.VendedorRepository;

@Service
public class VendedorService {

	@Autowired
	VendedorRepository vendedorRepository;
	
	public void incluir(Vendedor vendedor) {
		vendedorRepository.save(vendedor);
	}
	
	public Collection<Vendedor> obterLista(){	
		return (Collection<Vendedor>) vendedorRepository.findAll();
	}
}