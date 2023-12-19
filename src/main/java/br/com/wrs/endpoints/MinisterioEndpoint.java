package br.com.wrs.endpoints;

import br.com.wrs.base.BaseServices;
import br.com.wrs.modelo.Ministerio;
import br.com.wrs.dao.MinisterioDAO;
import br.com.wrs.dto.MinisterioDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.UUID;

@Service
@Path("/ministerio")
public class MinisterioEndpoint extends BaseServices{
	
	
	@Autowired
	public MinisterioDAO dao;
	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public String getListMinistery(@QueryParam("userId") UUID user_id) {
		
		Ministerio min = new Ministerio();
		min.setId(user_id);
		
		//@SuppressWarnings("unchecked")
		//ArrayList<MinisterioDTO> list =  (ArrayList<MinisterioDTO>) dao.getAll(min);
		
		
	   ArrayList<MinisterioDTO> list =  (ArrayList<MinisterioDTO>) dao.getMinisterio(user_id);
		
		return gs.toJson(list);
	}
	
	@POST
	@Path("/create")
	@Produces({MediaType.APPLICATION_JSON})
	public String createMinistry(Ministerio usr) {
		Integer CadMin = (Integer) dao.post(usr);
		return gs.toJson(CadMin);
	}
	

	@DELETE
	@Path("/delete")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public String deleteMinistry(@QueryParam("minId") Integer minId) {
	/*Integer min = (Integer) dao.remove(minId);
		gs.toJson(min);*/

		return 	null;
	}
	
	
	
	

}
