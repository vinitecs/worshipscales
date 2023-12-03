package br.com.wrs.dto;

import java.util.Date;

public class ProximasEscalasDTO {
		
	private Integer usrId;
	private Integer minId;
	private String nome;
	private String dataEscala;
	private  Integer escalaId;
	
	
	public Integer getUsrId() {
		return usrId;
	}
	public void setUsrId(Integer usrId) {
		this.usrId = usrId;
	}
	public Integer getMinId() {
		return minId;
	}
	public void setMinId(Integer minId) {
		this.minId = minId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataEscala() {
		return dataEscala;
	}
	public void setDataEscala(String dataEscala) {
		this.dataEscala = dataEscala;
	}
	public Integer getEscalaId() {
		return escalaId;
	}
	public void setEscalaId(Integer escalaId) {
		this.escalaId = escalaId;
	}
	
	
	
	
}
