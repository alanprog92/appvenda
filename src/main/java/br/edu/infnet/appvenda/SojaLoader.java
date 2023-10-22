package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Soja;
import br.edu.infnet.appvenda.model.service.SojaService;

@Order(4)
@Component
public class SojaLoader implements ApplicationRunner {
	
	@Autowired
	private SojaService sojaService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/soja.txt");		
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		String[] campos = null;
				
		while(linha != null) {
			
			campos = linha.split(";");
			
			Soja soja = new Soja();

			soja.setCodigo(Integer.valueOf(campos[0]));
			soja.setDescricao(campos[1]);
			soja.setEstoque(Boolean.valueOf(campos[2]));
			soja.setPreco(Float.valueOf(campos[3]));
			soja.setIntacta(Boolean.valueOf(campos[4]));
			soja.setCaracteristica(campos[5]);
			
			sojaService.incluir(soja);
			
			linha = leitura.readLine();
		}

		for(Soja soja : sojaService.obterLista()) {
			System.out.println("[SOJA] " + soja);
		}
		
		leitura.close();
	}
}