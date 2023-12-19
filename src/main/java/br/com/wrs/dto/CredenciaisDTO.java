package br.com.wrs.dto;

import br.com.wrs.enums.Perfil;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class CredenciaisDTO {
	
	private Integer usrId;
	private String usuario;
	private String senha;
	private String email;
	private Set<Integer> perfis = new HashSet<>();

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
	}
	

}
