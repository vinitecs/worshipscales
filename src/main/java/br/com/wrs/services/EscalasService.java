package br.com.wrs.services;

import br.com.wrs.base.Endpoint;
import br.com.wrs.dao.EscalasDAO;
import br.com.wrs.modelo.Escalas;
import br.com.wrs.modelo.UsuarioEscala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Service
@Path("/scales")
public class EscalasService extends Endpoint {

	
	@Autowired
	private EscalasDAO dao;
	
	@POST	
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/createScale")
	public String createScale(@BeanParam Escalas sc) throws Exception{
		dao.post(sc);
		return  gs.toJson("ok");
	}
	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public String getScales(@QueryParam("minId") Integer minId) {
		return gs.toJson(dao.getScales(minId));
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/insertMinistro")
	public String insertMusico(@BeanParam UsuarioEscala usrEsc) {
		Integer insert = dao.insertMusicoScale(usrEsc);
		return gs.toJson(insert);
	}
	
}
