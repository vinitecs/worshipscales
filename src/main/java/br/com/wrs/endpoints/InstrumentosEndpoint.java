package br.com.wrs.endpoints;

import br.com.wrs.base.BaseServices;
import br.com.wrs.dao.InstrumentoDAO;
import br.com.wrs.dto.InstrumentoDTO;
import br.com.wrs.modelo.Instrumento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;



@Service
@Path("/instrumentos")
public class InstrumentosEndpoint extends BaseServices {
	
	
	@Autowired
	private InstrumentoDAO dao;
	
	@GET
	@Path("/listar")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes(MediaType.APPLICATION_JSON)	
	public Response listtarInstrumentos() {
		return Response.ok(dao.listar()).build();
	}
	
	
	
	@POST
	@Path("/vincularInstrumento")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes(MediaType.APPLICATION_JSON)	
	public Response vincularInstrumentos(InstrumentoDTO instrumentos) {
		
		dao.vincularInstrumentoAoMinisterio(instrumentos);
		
		return Response.ok().build();
	}
	
	@POST
	@Path("/desvincularInstrumentosDoMinisterio")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes(MediaType.APPLICATION_JSON)	
	public Response desvincularInstrumentosPorMinisterio(InstrumentoDTO instrumentosParaDeletar) {
		
		dao.desvincularInstrumentoAoMinisterio(instrumentosParaDeletar);
		
		return Response.ok().build();
	}
	
	
	@GET
	@Path("/listarInstrumentosDoMinisterio")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes(MediaType.APPLICATION_JSON)	
	public Response ListarInstrumentosPorMinisterio(@QueryParam("ministerioId") Integer ministerioId) {
		
		List<Instrumento> instrumentos = dao.getByFilter(ministerioId.toString());
		return Response.ok().entity(instrumentos).build();
	}
	
}
