package br.com.wrs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import br.com.wrs.base.Bean;
import br.com.wrs.base.DAO;
import br.com.wrs.bean.Usuario;
import br.com.wrs.dto.CredenciaisDTO;
import br.com.wrs.enums.Perfil;

@Repository
public class UsuarioDAO extends DAO{
	
	private final  RowMapper<CredenciaisDTO> credDto = new RowMapper<CredenciaisDTO> (){

		public CredenciaisDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			CredenciaisDTO usr = new CredenciaisDTO();
        	usr.setUsrId(rs.getInt("usr_id"));
        	usr.setUsuario(rs.getString("email"));
        	usr.setEmail(rs.getString("email"));
        	usr.setSenha(rs.getString("senha"));
        	usr.addPerfil(Perfil.toEnum(rs.getInt("perfil")));
        	
		return usr;
		}
	};

	@Override
	public boolean checkUser(Bean object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Object insert(Bean object) {
		Usuario usr = (Usuario) object;
		
		String sql =  "INSERT INTO USUARIO ("					
										+ "  nome"
										+ ", email"
										+ ", senha"
										+ ", datanascimento"
										+ ", telefone"
										+ ", perfil"
										+ "  )VALUES( "
										+  " :nome"
										+ ", :email"
										+ ", :senha"
										+ ", :datanascimento "
										+ ", :telefone"
										+ ", :perfil"
										+ " )";
		
		fillParameters(usr);
		System.out.println(sql);
		return namedJdbcTemplate.update(sql,parameters);
	}

	@Override
	protected Object update(Bean object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getById(Bean object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> getByFilter(String filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> getAll(Bean object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean remove(Bean object) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public CredenciaisDTO auth(String email) {
		
		String sql = " SELECT "
					+ " USR.usr_id"
					+ ",USR.email"
					+ ",USR.senha"
					+ ",USR.perfil"					
		           + " FROM USUARIO USR"
		           + " WHERE email = ':EMAIL' ";
		
		sql = sql.replace(":EMAIL", email);
		System.out.println(sql);
		return  jdbcTemplate.queryForObject(sql, credDto);

	}

	@Override
	protected void fillParameters(Bean obj) {
		
		Usuario usr = (Usuario) obj;
		parameters = new  MapSqlParameterSource();		
		parameters.addValue("nome", usr.getNome());
		parameters.addValue("senha", usr.getSenha());
		parameters.addValue("email", usr.getEmail());		
		parameters.addValue("datanascimento", usr.getDataNascimento(), java.sql.Types.DATE );
		parameters.addValue("telefone", usr.getTelefone());
		parameters.addValue("perfil",usr.getPerfis().getCod() );
	}

}
