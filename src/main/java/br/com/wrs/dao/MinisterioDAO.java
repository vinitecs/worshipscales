package br.com.wrs.dao;

import br.com.wrs.base.DAO;
import br.com.wrs.base.Entidade;
import br.com.wrs.dto.MinisterioDTO;
import br.com.wrs.dto.MinistroDTO;
import br.com.wrs.modelo.Instrumento;
import br.com.wrs.modelo.Ministerio;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class MinisterioDAO extends DAO{
	
	RowMapper<MinisterioDTO> listaMinisterio = new RowMapper<MinisterioDTO>(){	     
		public MinisterioDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MinisterioDTO min = new MinisterioDTO();
			
			min.setLiderId(rs.getInt("lider_id"));
			min.setNomeLider(rs.getString("nome_lider"));
			min.setNomeMinisterio(rs.getString("nome_ministerio"));	
			min.setMinId(rs.getInt("minId"));						
			min.setUsr(getUsrMinistry(min.getMinId()));
			
			
			return min;
		}
	};
	
	
	

	RowMapper<MinistroDTO> listaMinistro = new RowMapper<MinistroDTO>(){	     
		public MinistroDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MinistroDTO mins = new MinistroDTO();
			
			mins.setUsr_id(rs.getInt("usr_id"));
			mins.setNome(rs.getString("nome"));
			if(rs.getString("tipo_ministerio").equals("m")) {				
				mins.setInstrumento(getMinistroInstrumento(rs.getInt("usr_id")));
			}
			
			return mins;
		}
	};
	RowMapper<Instrumento> listInstrumento = new RowMapper<Instrumento>() {
		public Instrumento mapRow(ResultSet rs, int rowNum) throws SQLException{
			Instrumento ins = new Instrumento();
			
		ins.setId(UUID.fromString(rs.getString("ins_id")));
		ins.setNomeInstrumento(rs.getString("nome"));
			return ins;
		}
	};

	@Override
	public boolean checkUser(Entidade object) {

		return false;
	}

	@Override
	protected Object insert(Entidade object) {
		Ministerio min = (Ministerio) object;
		
		String sql = "INSERT INTO MINISTERIO ("
											+ "  usr_id_lider"
											+ ", datacriacao"
											+ ", nome"
											+ "	)VALUES("
											+ "  :usr_id_lider"
											+ ", :datacriacao"
											+ ", :nome"
											+ ")"; 
		
		fillParameters(min);
		
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
		Ministerio min = (Ministerio) object;

		String sql = " SELECT MINS.min_id AS minId "
					   + "   ,MINS.usr_id_lider AS lider_id "
			           + " 	 ,USR.nome AS nome_lider "
			           + " 	 ,MINS.nome AS nome_ministerio "
		           + " FROM USUARIO USR "
		           + " INNER JOIN MINISTERIO MINS ON MINS.usr_id_lider = USR.usr_id "
		           + " WHERE MINS.usr_id_lider =" + min.getId();
		
		System.out.println(sql);
		return jdbcTemplate.query(sql, listaMinisterio);
	}
	
	
	public ArrayList<MinisterioDTO> getMinisterio(UUID usrId){
		
		String sql = " SELECT MINS.min_id AS minId"
				    + "  ,MINS.usr_id_lider AS lider_id "
		           + " 	 ,USR.nome AS nome_lider "
		           + " 	 ,MINS.nome AS nome_ministerio "
	           + " FROM usuario USR "		       
	           + " INNER JOIN USUARIOMINISTERIO USRMINS ON USRMINS.usr_Id = USR.usr_id "
	           + " INNER JOIN MINISTERIO  MINS ON MINS.min_id = USRMINS.min_id"
	           + " WHERE USRMINS.usr_Id ="+ usrId;
		
		System.out.println(sql);
		ArrayList<MinisterioDTO> list = (ArrayList<MinisterioDTO>) jdbcTemplate.query(sql, listaMinisterio);
		
		
		return list;
	}
	
	
	public ArrayList<MinistroDTO> getUsrMinistry(Integer UsrID){
		
		String sql = " SELECT USR.usr_id "
		           + " 	,USR.nome "
		           + ",MINIS.tipo_ministerio"
		           + " FROM USUARIO USR "
		           + " INNER JOIN USUARIOMINISTERIO USRMINIS ON USR.usr_id = USRMINIS.usr_id "
		           + " INNER JOIN MINISTERIO MINIS ON MINIS.min_id = USRMINIS.min_id "
		           + " WHERE MINIS.min_id = " + UsrID;


	//System.out.println(sql);
		return (ArrayList<MinistroDTO>) jdbcTemplate.query(sql, listaMinistro);
	}
	public ArrayList<Instrumento> getMinistroInstrumento(Integer usr_id ){
		
		
		String sql = " SELECT INS.ins_id "
		           + " 	,INS.nome "
		           + " FROM USUARIOINSTRUMENTOMINISTERIO USRINSMIN "
		           + " INNER JOIN MINISTERIO MINIS ON MINIS.min_id = USRINSMIN.min_id "
		           + " INNER JOIN INSTRUMENTO INS ON INS.ins_id = USRINSMIN.ins_id "
		           + " WHERE USRINSMIN.usr_id =" + usr_id;
		
	//	System.out.println(sql);
		           
		return (ArrayList<Instrumento>) jdbcTemplate.query(sql, listInstrumento);
	}

	@Override
	public Boolean remove(Entidade object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void fillParameters(Entidade obj) {
		Ministerio min = (Ministerio) obj;

		parameters = new MapSqlParameterSource();
		parameters.addValue("nome", min.getNome());
		parameters.addValue("usr_id_lider", min.getUsuarioLiderId());

	}

}
