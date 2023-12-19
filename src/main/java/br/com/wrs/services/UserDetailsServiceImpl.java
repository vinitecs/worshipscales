package br.com.wrs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.wrs.dao.UsuarioDAO;
import br.com.wrs.dto.CredenciaisDTO;
import br.com.wrs.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioDAO usr;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		if(username == null) {
			return null;
		}
		CredenciaisDTO cred = usr.auth(username) ;
		
		return new UserSS(cred.getUsrId(),cred.getUsuario(),cred.getSenha(),cred.getEmail(),cred.getPerfis());
	}

}
