package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Feijao;
import br.edu.infnet.appvenda.model.domain.Produto;
import br.edu.infnet.appvenda.model.domain.Soja;
import br.edu.infnet.appvenda.model.service.ProdutoService;

@Order(2)
@Component
public class ProdutoLoader implements ApplicationRunner {
	
	@Autowired
	private ProdutoService produtoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/produtos.txt");		
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		String[] campos = null;

		while(linha != null) {
			
			campos = linha.split(";");
			
			switch (campos[6]) {
			case "S":
				Soja soja = new Soja();
				soja.setCodigo(Integer.valueOf(campos[0]));
				soja.setDescricao(campos[1]);
				soja.setEstoque(Boolean.valueOf(campos[2]));
				soja.setPreco(Float.valueOf(campos[3]));
				soja.setCaracteristica(campos[4]);
				soja.setIntacta(Boolean.valueOf(campos[5]));
				
				produtoService.incluir(soja);
				
				break;

			case "F":
				Feijao feijao = new Feijao();
				feijao.setCodigo(Integer.valueOf(campos[0]));
				feijao.setDescricao(campos[1]);
				feijao.setEstoque(Boolean.valueOf(campos[2]));
				feijao.setPreco(Float.valueOf(campos[3]));
				feijao.setTipo(campos[4]);
				feijao.setClassificacao(campos[5]);
				
				produtoService.incluir(feijao);
				
				break;

			default:
				break;
			}
									
			linha = leitura.readLine();
		}

		for(Produto produto: produtoService.obterLista()) {
			System.out.println("[Produto] " + produto);			
		}
		
		leitura.close();
	}
}