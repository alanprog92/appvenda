package br.edu.infnet.appvenda.model.domain;

public class Feijao extends Produto {

	private String tipo;
	private String classificacao;

	@Override
	public String toString() {
		return String.format("%s - %s - %s", super.toString(), tipo, classificacao);
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	
	
	
}