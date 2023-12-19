package br.com.wrs.dao;

import br.com.wrs.base.DAO;
import br.com.wrs.base.Entidade;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioLiderDAO extends DAO {

	@Override
	public boolean checkUser(Entidade object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Object insert(Entidade object) {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	protected void fillParameters(Entidade object) {
		// TODO Auto-generated method stub
		
	}

}
