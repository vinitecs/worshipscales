package br.com.wrs.dao;

import br.com.wrs.base.DAO;
import br.com.wrs.base.Entidade;
import br.com.wrs.dto.EscalasDTO;
import br.com.wrs.dto.MinistroEscaladoDTO;
import br.com.wrs.modelo.Escalas;
import br.com.wrs.modelo.UsuarioEscala;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class EscalasDAO extends DAO{


	RowMapper<EscalasDTO> listEscalas = new RowMapper<EscalasDTO>() {
		
		public EscalasDTO mapRow(ResultSet rs, int rowColumn) throws SQLException {
			EscalasDTO esc= new EscalasDTO();
				esc.setEscalaId(rs.getLong("escala_id"));				
				esc.setDataEscala(rs.getDate("data_escala"));
				esc.setMinistros((ArrayList<MinistroEscaladoDTO>) filterMinistros( rs.getLong("escala_id")));
			return esc;
		}
	};

	RowMapper<MinistroEscaladoDTO> ministroEscala = new RowMapper<MinistroEscaladoDTO>() {
		public MinistroEscaladoDTO mapRow(ResultSet rs, int rowColumn)throws SQLException {
			MinistroEscaladoDTO minEsc= new MinistroEscaladoDTO();
			minEsc.setMinId(rs.getInt("ministerio_id"));
			minEsc.setNomeMinistro(rs.getString("nome_usuario"));
			minEsc.setInstrumento(rs.getString("nome_instrumento"));			
			return minEsc;
		}
	};
	
	
	@Override
	public boolean checkUser(Entidade object) {
		 
		return false;
	}

	@Override
	protected Object insert(Entidade object) {
		Escalas sc = (Escalas) object;
		
		String sql ="INSERT INTO ESCALAS ("
										+" min_id"
										+",data_escala"
										+") VALUES ("
										+" :min_id"
										+",:data_escala"
										+")";
		
		
		
		
		fillParameters(sc);
		return namedJdbcTemplate.update(sql, parameters);
	}
	
	public int insertMusicoScale(UsuarioEscala bean) {
		
		String sql = " INSERT INTO USUARIOINSTRUMENTOMINISTERIO ( "
													           + " 	min_id "
													           + " 	,usr_id "
													           + " 	,ins_id "
													           + " 	,escala_id "
													           + " 	) "
													           + " VALUES ( "
													           + " 	:min_id "
													           + " 	,:usr_id "
													           + " 	,:ins_id "
													           + " 	,:escala_id "
													           + " 	) ";
			fillParameterScale(bean);
			return namedJdbcTemplate.update(sql, parameters);
	}

	@Override
	protected Object update(Entidade object) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<?> getByFilter(String filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> getAll(Entidade object) {

		return null;

	}
	
	public List<EscalasDTO> getScales(Integer minid){
		
		
		String sql = " SELECT ESC.min_id "
		           + " 	,ESC.data_escala "
		           + " 	,ESC.escala_id "
		           + " FROM ESCALAS ESC "
		           + " INNER JOIN MINISTERIO MINS ON MINS.min_id = ESC.min_id "
		           + " WHERE MINS.min_id = " + minid;

			System.out.println(sql);
		
		return jdbcTemplate.query(sql, listEscalas);
	}
	
	public List<MinistroEscaladoDTO> filterMinistros(Long escId){
		
		String sql = " SELECT USRINSMIN.min_id AS ministerio_id "
		           + " 	,USR.nome AS nome_usuario "
		           + " 	,INS.nome AS nome_instrumento "
		           + " FROM USUARIO USR "
		           + " INNER JOIN USUARIOINSTRUMENTOMINISTERIO USRINSMIN ON USRINSMIN.usr_id = USR.usr_id "
		           + " INNER JOIN INSTRUMENTO INS ON INS.ins_id = USRINSMIN.ins_id "
		           + " WHERE USRINSMIN.escala_id ="+ escId;

		
		return jdbcTemplate.query(sql, ministroEscala);
	}

	@Override
	public Boolean remove(Entidade object) {
		// TODO Auto-generated method stub
		return null;
	}

	public EscalasDTO allScalles() {
		EscalasDTO dto = null;
		
		
		
		return dto;
	}
	
	
	private void fillParameterScale(UsuarioEscala sc) {
		parameters = new MapSqlParameterSource();
		parameters.addValue("usr_id", sc.getUsrId());
		parameters.addValue("min_id", sc.getMinId());
		parameters.addValue("ins_id", sc.getInsId());
		parameters.addValue("escala_id", sc.getEscId());
		
	}
	
	
	
	@Override
	protected void fillParameters(Entidade object) {
		Escalas  sc =  (Escalas) object;		
		parameters = new MapSqlParameterSource();
		parameters.addValue("min_id", sc.getMinId());
		parameters.addValue("data_escala", sc.getDataEscala(), java.sql.Types.DATE);
		
	}

	@Override
	public Entidade getById(UUID id) {
		return null;
	}

}
