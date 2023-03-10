package br.com.wrs.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.wrs.enums.Perfil;

public class UserSS implements UserDetails{
	
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String usuario;
	private String senha;
	private String email;
	private Collection<? extends GrantedAuthority> authority;
	
	
	

	public UserSS(Integer id, String usuario, String senha, String email,
			Set<Perfil> perfis) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.senha = senha;
		this.email = email;
		this.authority =  perfis.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toList());
	}

	public Integer getId() {
		return id;
	} 
	
	public String getEmail() {
		return email;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authority;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return  senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return usuario;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
