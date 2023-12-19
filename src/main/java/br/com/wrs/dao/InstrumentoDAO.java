package br.com.wrs.dao;

import br.com.wrs.base.Entidade;
import br.com.wrs.base.DAO;
import br.com.wrs.dto.InstrumentoDTO;
import br.com.wrs.modelo.Instrumento;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Repository
public  class InstrumentoDAO extends DAO {
	
	RowMapper<Instrumento> instrumento = new RowMapper<Instrumento>() {
		public Instrumento mapRow(ResultSet rs, int rowNum) throws SQLException {
			Instrumento ins = new Instrumento();

				ins.setId(UUID.fromString(rs.getString("ins_id")));
				ins.setNomeInstrumento(rs.getString("nome"));
				
			return ins;
			
		}
		
	};
	
	RowMapper<InstrumentoDTO> instrumentoDTO = new RowMapper<InstrumentoDTO>() {
		public InstrumentoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			InstrumentoDTO ins = new InstrumentoDTO();

				ins.setId(rs.getInt("ins_id"));
				ins.setMinId(rs.getInt("minId"));
				
			return ins;
			
		}
		
	};
	

	@Override
	public boolean checkUser(Entidade object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Object insert(Entidade object) {
		return null;
	}

	@Override
	protected Object update(Entidade object) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Instrumento> getByFilter(String filter) {

		String sql = " SELECT INST.ins_id,INST.nome "
		           + " FROM INSTRUMENTO_MINISTERIO INSMIN "
		           + " INNER JOIN INSTRUMENTO INST ON INST.ins_id = INSMIN.ins_id"
		           + " WHERE INSMIN.minid ="+ filter;
		
		
		return jdbcTemplate.query(sql, instrumento);
	}

	@Override
	public List<?> getAll(Entidade object) {

		return null;
	}

	@Override
	public Boolean remove(Entidade object) {
		return null;
	}


	@Override
	protected void fillParameters(Entidade object) {
		
		
	}
	
	
	public List<Instrumento> listar() {
		
		String sql = " SELECT * "
			    + " FROM INSTRUMENTO ";

		return jdbcTemplate.query(sql, instrumento);
	}

	
	
	public Integer  vincularInstrumentoAoMinisterio(InstrumentoDTO object) {
		
		String sql = " INSERT INTO INSTRUMENTO_MINISTERIO ( "
											           + " 	 minId "
											           + " 	,ins_id "
											           + " 	)VALUES( "
											           + " 	 :minId "
											           + " 	,:ins_id "
											           + " 	); ";
		
		fillParametersMinisterio(object);
		
		return namedJdbcTemplate.update(sql,parameters);
	}
	

	
	public Integer  desvincularInstrumentoAoMinisterio(InstrumentoDTO object) {
		
		String sql = " DELETE "
		           + "   FROM instrumento_ministerio "
		           + "  WHERE ins_id ="+ object.getId()
		           + " 	  AND minId =" +  object.getMinId();
		
		fillParametersMinisterio(object);
		
		System.out.println(sql);
		
		return namedJdbcTemplate.update(sql,parameters);
	}
	
	
	public InstrumentoDTO  instrumentoAoMinisterioByFilter(InstrumentoDTO object) {
		
		String sql = " SELECT INST_MIN.INS_ID,"
				   + " 		  INST_MIN.MINID"
		           + "  FROM INSTRUMENTO_MINISTERIO INST_MIN "
		           + " INNER JOIN INSTRUMENTO INSTR ON INSTR.INS_ID = INST_MIN.ins_id "
		           + " WHERE INST_MIN.ins_id = "+ object.getId()
		           + "   AND INST_MIN.minId = "+ object.getMinId();
		
		System.out.println(sql);
		
		try {
			return jdbcTemplate.queryForObject(sql,instrumentoDTO);
		} catch (Exception e) {
			return null;
		}
		
		
	}
	
	
	
	protected void fillParametersMinisterio(InstrumentoDTO instrumentoDTO) {
        
		parameters = new MapSqlParameterSource();
		parameters.addValue("minId", instrumentoDTO.getMinId());
		parameters.addValue("ins_id",instrumentoDTO.getId()); 
		 
		
	}
	

}
