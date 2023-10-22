package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Feijao;
import br.edu.infnet.appvenda.model.service.FeijaoService;

@Order(4)
@Component
public class FeijaoLoader implements ApplicationRunner {
	
	@Autowired
	private FeijaoService feijaoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/feijao.txt");		
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		String[] campos = null;
				
		while(linha != null) {
			
			campos = linha.split(";");
			
			Feijao feijao = new Feijao();

			feijao.setCodigo(Integer.valueOf(campos[0]));
			feijao.setDescricao(campos[1]);
			feijao.setEstoque(Boolean.valueOf(campos[2]));
			feijao.setPreco(Float.valueOf(campos[3]));
			feijao.setTipo(campos[4]);
			feijao.setClassificacao(campos[5]);
			
			feijaoService.incluir(feijao);
			
			linha = leitura.readLine();
		}

		for(Feijao feijao : feijaoService.obterLista()) {
			System.out.println("[FEIJÃO] " + feijao);
		}
		
		leitura.close();
	}
}