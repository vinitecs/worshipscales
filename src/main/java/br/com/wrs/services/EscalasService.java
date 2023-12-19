package br.com.wrs.services;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wrs.base.BC;
import br.com.wrs.modelo.Escalas;
import br.com.wrs.modelo.UsuarioEscala;
import br.com.wrs.dao.EscalasDAO;

@Service
@Path("/scales")
public class EscalasService extends BC{

	
	@Autowired
	private EscalasDAO dao;
	
	@POST	
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/createScale")
	public String createScale(@BeanParam Escalas sc) throws Exception{
		Integer res = (Integer) dao.post(sc);
		
		if(res < 0) {
			return  gs.toJson("escala não foi criada ");
		}
		return  gs.toJson(sc);
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
