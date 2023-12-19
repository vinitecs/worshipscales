package br.com.wrs.endpoints;

import br.com.wrs.base.BaseServices;
import br.com.wrs.dao.UsuarioDAO;
import br.com.wrs.modelo.Usuario;
import br.com.wrs.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Service
@Path("/user")
public class UsuarioEndpoint extends BaseServices{
	
	
	@Autowired
	public UsuarioDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder bc;
	
	@POST
	@Path("/create")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public ResponseEntity<Object>  createUser(Usuario user) {					
		user.setSenha(bc.encode(user.getSenha()));
		dao.post(user);

		return ResponseEntity.ok("ok");
	}

	@Autowired
	JWTUtil jwt;
	
	/*@POST
	@Path("/google")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public ResponseEntity<String> authGoogle(UserGoogleModel google) {
		
		CredenciaisDTO cred = dao.auth(google.getEmail());
		
		if(cred.getFotoPerfil() == null) {
			cred.setFotoPerfil(google.getImageUrl());	
		}
		UserSS user = new UserSS(cred.getUsrId(),cred.getUsuario(),cred.getSenha(),cred.getEmail(),cred.getPerfis());		
		String token = jwt.generateToken(user.getUsername());
		
		HttpHeaders response = new HttpHeaders();
		   
		
		response.set("Authorization", "Bearer " + token);
		response.set("Access-Control-Expose-Headers", "Authorization");
		
		return ResponseEntity.ok()
			      .headers(response)
			      .body(gs.toJson(cred));
	}*/

}
