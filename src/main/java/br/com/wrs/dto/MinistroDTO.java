package br.com.wrs.dto;

import br.com.wrs.modelo.Instrumento;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class MinistroDTO {
	
	private Integer usrId;
	private String nome;
	private String tipo;
	private ArrayList<Instrumento> instrumento;
}
