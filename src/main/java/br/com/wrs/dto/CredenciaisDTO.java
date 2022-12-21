package br.com.wrs.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.wrs.enums.Perfil;



public class CredenciaisDTO {
	
	private Integer usrId;
	private String usuario;
	private String senha;
	private String email;
	private Set<Integer> perfis = new HashSet<>();
	
	
	

	public Integer getUsrId() {
		return usrId;
	}
	public void setUsrId(Integer usrId) {
		this.usrId = usrId;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}		

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPerfis(Set<Integer> perfis) {
		this.perfis = perfis;
	}
	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
	}
	

}
