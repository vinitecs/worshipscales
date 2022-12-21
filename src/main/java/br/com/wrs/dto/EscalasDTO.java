package br.com.wrs.dto;

import java.util.ArrayList;
import java.util.Date;

public class EscalasDTO {

	private Long escalaId;
	private Integer minId;
	private Date dataEscala;
	private ArrayList<MinistroEscaladoDTO> ministros;
	
	
	public Long getEscalaId() {
		return escalaId;
	}
	public void setEscalaId(Long escalaId) {
		this.escalaId = escalaId;
	}	
	
	public Integer getMinId() {
		return minId;
	}
	public void setMinId(Integer minId) {
		this.minId = minId;
	}
	public Date getDataEscala() {
		return dataEscala;
	}
	public void setDataEscala(Date dataEscala) {
		this.dataEscala = dataEscala;
	}
	public ArrayList<MinistroEscaladoDTO> getMinistros() {
		return ministros;
	}
	public void setMinistros(ArrayList<MinistroEscaladoDTO> ministros) {
		this.ministros = ministros;
	}
	
	
	
	
}
