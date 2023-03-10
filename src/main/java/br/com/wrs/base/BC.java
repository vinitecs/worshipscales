package br.com.wrs.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;

import com.google.gson.Gson;

//import br.com.vd.bean.UsuarioEmpresa;

public class BC {
	protected ApplicationContext context; 	
	protected DefaultListableBeanFactory beanFactory; 

	//protected UsuarioEmpresa usuarioLogado;
	
	public Gson gs = new Gson();

	
	@Autowired 
    public void setApplicationContext(ApplicationContext ctx) { 
        if (!DefaultListableBeanFactory.class.isAssignableFrom(ctx.getAutowireCapableBeanFactory().getClass())) { 
            throw new IllegalArgumentException("BeanFactory deve ser do tipo DefaultListableBeanFactory"); 
        } 
        
        this.context = ctx; 
        this.beanFactory = (DefaultListableBeanFactory) ctx.getAutowireCapableBeanFactory(); 
    } 	
}
