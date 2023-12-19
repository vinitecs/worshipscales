package br.com.wrs.dao;

import br.com.wrs.base.DAO;
import br.com.wrs.base.Entidade;
import br.com.wrs.dto.CredenciaisDTO;
import br.com.wrs.enums.Perfil;
import br.com.wrs.modelo.Usuario;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Repository
public class UsuarioDAO extends DAO{
	
	private final  RowMapper<CredenciaisDTO> credDto = new RowMapper<CredenciaisDTO> (){

		public CredenciaisDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			CredenciaisDTO usr = new CredenciaisDTO();
        	usr.setId(UUID.fromString(rs.getString("id")));
        	usr.setUsuario(rs.getString("email"));
        	usr.setEmail(rs.getString("email"));
        	usr.setSenha(rs.getString("senha"));
        	usr.addPerfil(Perfil.toEnum(rs.getInt("perfil")));
        	
		return usr;
		}
	};

	@Override
	public boolean checkUser(Entidade object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Object insert(Entidade object) {

		return null ;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean remove(Entidade object) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public CredenciaisDTO auth(String email) {
		
		String sql = " SELECT "
					+ " USR.id"
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
	protected void fillParameters(Entidade obj) {
		
		Usuario usr = (Usuario) obj;
		parameters = new  MapSqlParameterSource();		
		parameters.addValue("nome", usr.getNome());
		parameters.addValue("senha", usr.getSenha());
		parameters.addValue("email", usr.getEmail());		
		parameters.addValue("datanascimento", usr.getDataNascimento(), java.sql.Types.DATE );
		parameters.addValue("telefone", usr.getTelefone());
		parameters.addValue("perfil",usr.getPerfis().getCod() );
	}

	@Override
	public Entidade getById(UUID id) {
		Usuario	usuario = getEntityManager().find(Usuario.class, id);
		return usuario;
	}

}
