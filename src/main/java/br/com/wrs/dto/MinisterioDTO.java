package br.com.wrs.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class MinisterioDTO {
	
	private Integer minId;
	private Integer liderId;
	private String  nomeLider;
	private String nomeMinisterio;
	private ArrayList<MinistroDTO> usr;


}
