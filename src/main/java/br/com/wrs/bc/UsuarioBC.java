package br.com.wrs.bc;

import javax.ws.rs.BeanParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.wrs.base.BC;
import br.com.wrs.bean.Usuario;
import br.com.wrs.dao.UsuarioDAO;

@Service
@Path("/user")
public class UsuarioBC extends BC{
	
	
	@Autowired
	public UsuarioDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder bc;
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	public String createUser(@BeanParam Usuario user) {					
		user.setSenha(bc.encode(user.getSenha()));		
		Integer usr = (Integer) dao.post(user);		
		return gs.toJson(usr);
	}	
	

}
