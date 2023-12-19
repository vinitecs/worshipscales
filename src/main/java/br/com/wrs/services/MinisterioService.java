package br.com.wrs.services;

import br.com.wrs.base.Endpoint;
import br.com.wrs.dao.MinisterioDAO;
import br.com.wrs.dto.MinisterioDTO;
import br.com.wrs.modelo.Ministerio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.UUID;

@Service
@Path("/ministerio")
public class MinisterioService extends Endpoint {
	
	
	@Autowired
	public MinisterioDAO dao;
	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public String getListMinistery(@QueryParam("user_id") UUID user_id) {
		
		Ministerio min = new Ministerio();
		min.setId(user_id);
		
		@SuppressWarnings("unchecked")
		ArrayList<MinisterioDTO> list =  (ArrayList<MinisterioDTO>) dao.getAll(min);
		
		
	//ArrayList<MinisterioDTO> list =  (ArrayList<MinisterioDTO>) dao.getMinisterio(user_id);
		
		return gs.toJson(list);
	}
	
	@POST
	@Path("/create")
	@Produces({MediaType.APPLICATION_JSON})
	public String createMinistry(@BeanParam Ministerio usr) {
		 dao.post(usr);
		return gs.toJson("ok");
	}
	

}
