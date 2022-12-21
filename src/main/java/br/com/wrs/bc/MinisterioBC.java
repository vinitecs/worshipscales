package br.com.wrs.bc;

import java.util.ArrayList;
import java.util.List;

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
import br.com.wrs.bean.Ministerio;
import br.com.wrs.dao.MinisterioDAO;
import br.com.wrs.dto.MinisterioDTO;

@Service
@Path("/ministerio")
public class MinisterioBC extends BC{
	
	
	@Autowired
	public MinisterioDAO dao;
	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public String getListMinistery(@QueryParam("user_id") Integer user_id) {
		
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
		Integer CadMin = (Integer) dao.post(usr);
		return gs.toJson(CadMin);
	}
	

}
