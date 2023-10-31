package br.edu.infnet.appvenda.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "soja")
public class Soja extends Produto {

	private boolean intacta;
	private String caracteristica;

	@Override
	public String toString() {
		return String.format("%s - %s - %s", super.toString(), intacta, caracteristica);
	}

	public boolean isIntacta() {
		return intacta;
	}

	public void setIntacta(boolean intacta) {
		this.intacta = intacta;
	}

	public String getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}
	
	
	
}