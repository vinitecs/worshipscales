package br.com.wrs.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.persistence.EntityManager;
import java.util.List;
public abstract  class DAO<E extends Entidade>{

	
protected final String WHERE = " where ";
protected final String AND = " and ";
protected final String OR = " or ";
protected final String WHERE_AND = "";

	protected String whereAnd(String f) {
		return f.trim() == "" ? WHERE : AND;
	}



	protected  MapSqlParameterSource parameters;
	
	@Autowired
	protected NamedParameterJdbcTemplate namedJdbcTemplate; 
	
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Autowired
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}

  public abstract boolean checkUser(E object);


abstract protected Object insert(E object);
abstract protected Object update(E object);

//abstract public Object post(Bean object);

abstract public List<?> getByFilter(String filter);
//abstract public List<?> getAll();
abstract public List<?> getAll(Entidade object);

abstract public Boolean remove(Entidade object);

abstract protected void fillParameters(Entidade object);

	public void post(E object) {
		getEntityManager().persist(object);
		getEntityManager().flush();
	}

protected String toFilter(Entidade object){
	return this.filter;
}

protected String filterSQL(Entidade object) {
	filter = "";
	
	return prepareFilter(object);
}
	
private String prepareFilter(Entidade object) {
	
	if (object instanceof SC) {
		SC sc = (SC) object;
		
		String f = sc.filterSQL();
		this.parameters = sc.getParameters();

		return f;
	} else {
		fillParameters(object);

		return toFilter(object);
	}
}	

private String filter = "";

protected void addFilter(String f) {
	addFilter(f, whereAnd(filter));		
}

protected void addFilter(String f, String condition) {
	filter += " " + condition + f + " ";
}	
}
