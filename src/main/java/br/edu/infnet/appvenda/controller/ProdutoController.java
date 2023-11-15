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
import br.edu.infnet.appvenda.model.domain.Produto;
import br.edu.infnet.appvenda.model.repository.ProdutoRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ProdutoController {
	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping("/produtos")
	public List<Produto> getAllProdutos() {
		return (List<Produto>) produtoRepository.findAll();
	}

	@GetMapping("/produtos/{id}")
	public ResponseEntity<Produto> getProdutoById(@PathVariable(value = "id") Integer produtoId)
			throws ResourceNotFoundException {
		Produto produto = produtoRepository.findById(produtoId)
				.orElseThrow(() -> new ResourceNotFoundException("Produto com id nao existente::: " + produtoId));
		return ResponseEntity.ok().body(produto);
	}

	@PostMapping("/produtos")
	public Produto createProduto(@Valid @RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	@PutMapping("/produtos/{id}")
	public ResponseEntity<Produto> updateProduto(@PathVariable(value = "id") Integer produtoId,
			@Valid @RequestBody Produto produtoDetails) throws ResourceNotFoundException {
		Produto produto = produtoRepository.findById(produtoId)
				.orElseThrow(() -> new ResourceNotFoundException("Produto com id nao existente::: " + produtoId));

		produto.setDescricao(produtoDetails.getDescricao());
		produto.setCodigo(produtoDetails.getCodigo());
		produto.setPreco(produtoDetails.getPreco());
		produto.setVendedor(produtoDetails.getVendedor());
		final Produto updateProduto = produtoRepository.save(produto);
		return ResponseEntity.ok(updateProduto);
	}

	@DeleteMapping("/produtos/{id}")
	public Map<String, Boolean> deleteProduto(@PathVariable(value = "id") Integer produtoId)
			throws ResourceNotFoundException {
		Produto produto = produtoRepository.findById(produtoId)
				.orElseThrow(() -> new ResourceNotFoundException("Produto com id nao existente::: " + produtoId));

		produtoRepository.delete(produto);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}