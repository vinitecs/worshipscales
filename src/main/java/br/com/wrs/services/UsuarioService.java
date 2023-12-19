package br.com.wrs.services;

import br.com.wrs.base.Endpoint;
import br.com.wrs.dao.UsuarioDAO;
import br.com.wrs.modelo.Usuario;
import br.com.wrs.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Service
@Path("/user")
public class UsuarioService extends Endpoint {
	
	
	@Autowired
	public UsuarioDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder bc;

	JWTUtil jwtUtil;
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("/create")
	public Response createUser(Usuario user) {
		user.setSenha(bc.encode(user.getSenha()));
		dao.post(user);
		return Response.ok(user).build();
	}





}
