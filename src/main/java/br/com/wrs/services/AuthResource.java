package br.com.wrs.services;

import br.com.wrs.base.BaseServices;
import br.com.wrs.dao.UsuarioDAO;
import br.com.wrs.security.UserSS;
import br.com.wrs.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Service
@Path("/authResource")
public class AuthResource extends BaseServices {
	
	@Autowired
	JWTUtil jwt;

	@Autowired
	private UsuarioDAO usuarioService;
	
	@POST
	@Path("/refresh_token")
	@Produces({MediaType.APPLICATION_JSON})
	public ResponseEntity<Void> refrestToken(@Context  HttpServletResponse response){
		UserSS user = isAutenticated();
		String token = jwt.generateToken(user.getUsername());		
		response.addHeader("Authorization", "Bearer " + token);
		response.addHeader("Access-Control-Expose-Headers", "Authorization");
		return ResponseEntity.noContent().build();
	}
	
	@GET
	@Path("usuario_logado")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response usuarioLogado(){
		UserSS user = isAutenticated();
		return Response.ok(usuarioService.getById(user.getId())).build();
	}
	

}
