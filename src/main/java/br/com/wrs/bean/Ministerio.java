package br.com.wrs.bean;

import javax.ws.rs.FormParam;

import br.com.wrs.base.Bean;


public class Ministerio extends Bean{
		


	@FormParam("usuarioLiderId")
	private Integer usuarioLiderId;
	
	@FormParam("nome")
	private String nome;

	@FormParam("dataCriacao")
	private String dataCriacao;
	
	
	public Integer getUsuarioLiderId() {
		return usuarioLiderId;
	}

	public void setUsuarioLiderId(Integer usuarioLiderId) {
		this.usuarioLiderId = usuarioLiderId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataCricacao() {
		return dataCriacao;
	}

	public void setDataCricacao(String dataCricacao) {
		this.dataCriacao = dataCricacao;
	}
	
	

}
