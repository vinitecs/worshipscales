package br.com.wrs.dto;

import br.com.wrs.modelo.Instrumento;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class MinistroDTO {
	
	private Integer usr_id;
	private String nome;
	private String tipo;
	private ArrayList<Instrumento> instrumento;
	
	
	public Integer getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(Integer usr_id) {
		this.usr_id = usr_id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public ArrayList<Instrumento> getInstrumento() {
		return instrumento;
	}
	public void setInstrumento(ArrayList<Instrumento> instrumento) {
		this.instrumento = instrumento;
	}
	
	

}
