package br.com.wrs.base;

public interface  EntidadeCRUDService<E> {
	
	E id();
	
	E entity(E entidade);
	
	E remove(E id);	
	
	E listarById(E entidade);

}
