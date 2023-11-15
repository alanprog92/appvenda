package br.edu.infnet.appvenda.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.appvenda.exception.ResourceNotFoundException;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.repository.VendedorRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class VendedorController {
	@Autowired
	private VendedorRepository vendedorRepository;

	@GetMapping("/vendedors")
	public List<Vendedor> getAllVendedors() {
		return (List<Vendedor>) vendedorRepository.findAll();
	}

	@GetMapping("/vendedors/{id}")
	public ResponseEntity<Vendedor> getVendedorById(@PathVariable(value = "id") Integer vendedorId)
			throws ResourceNotFoundException {
		Vendedor vendedor = vendedorRepository.findById(vendedorId)
				.orElseThrow(() -> new ResourceNotFoundException("Vendedor com id nao existente::: " + vendedorId));
		return ResponseEntity.ok().body(vendedor);
	}

	@PostMapping("/vendedors")
	public Vendedor createVendedor(@Valid @RequestBody Vendedor vendedor) {
		return vendedorRepository.save(vendedor);
	}

	@PutMapping("/vendedors/{id}")
	public ResponseEntity<Vendedor> updateVendedor(@PathVariable(value = "id") Integer vendedorId,
			@Valid @RequestBody Vendedor vendedorDetails) throws ResourceNotFoundException {
		Vendedor vendedor = vendedorRepository.findById(vendedorId)
				.orElseThrow(() -> new ResourceNotFoundException("Vendedor com id nao existente::: " + vendedorId));

		vendedor.setEmail(vendedorDetails.getEmail());
		vendedor.setCpf(vendedorDetails.getCpf());
		vendedor.setNome(vendedorDetails.getNome());
		final Vendedor updateVendedor = vendedorRepository.save(vendedor);
		return ResponseEntity.ok(updateVendedor);
	}

	@DeleteMapping("/vendedors/{id}")
	public Map<String, Boolean> deleteVendedor(@PathVariable(value = "id") Integer vendedorId)
			throws ResourceNotFoundException {
		Vendedor vendedor = vendedorRepository.findById(vendedorId)
				.orElseThrow(() -> new ResourceNotFoundException("Vendedor com id nao existente::: " + vendedorId));

		vendedorRepository.delete(vendedor);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}