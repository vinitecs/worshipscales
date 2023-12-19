package br.com.wrs.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioLogadoDTO{
	
	private Integer usrId;
	private String  nome;
	private String  email;
	private Integer perfil;
	private String  telefone;
	private String  urlImage;
}
