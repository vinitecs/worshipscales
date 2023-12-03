package br.com.wrs.bc;

import br.com.wrs.base.BaseServices;
import br.com.wrs.security.UserSS;
import br.com.wrs.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;



@Service
@Path("/authResource")
public class AuthResource extends BaseServices {
	
	@Autowired
	JWTUtil jwt;
	
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
	
	
	

}
