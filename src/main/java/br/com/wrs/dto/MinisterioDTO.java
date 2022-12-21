package br.com.wrs.dto;

import java.util.ArrayList;

public class MinisterioDTO {
	
	private Integer minId;
	private Integer liderId;
	private String  nomeLider;
	private String nomeMinisterio;
	private ArrayList<MinistroDTO> usr;
	
	
	
	
	public Integer getMinId() {
		return minId;
	}
	public void setMinId(Integer minId) {
		this.minId = minId;
	}
	public Integer getLiderId() {
		return liderId;
	}
	public void setLiderId(Integer liderId) {
		this.liderId = liderId;
	}
	public String getNomeLider() {
		return nomeLider;
	}
	public void setNomeLider(String nomeLider) {
		this.nomeLider = nomeLider;
	}
	public String getNomeMinisterio() {
		return nomeMinisterio;
	}
	public void setNomeMinisterio(String nomeMinisterio) {
		this.nomeMinisterio = nomeMinisterio;
	}
	public ArrayList<MinistroDTO> getUsr() {
		return usr;
	}
	public void setUsr(ArrayList<MinistroDTO> usr) {
		this.usr = usr;
	}
	
	

}
