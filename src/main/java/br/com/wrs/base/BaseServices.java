package br.com.wrs.base;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.google.gson.Gson;

import br.com.wrs.security.UserSS;

//import br.com.vd.bean.UsuarioEmpresa;

public class BaseServices {
	
    
	
	public Gson gs = new Gson();
	protected ApplicationContext context; 	
	protected DefaultListableBeanFactory beanFactory; 

	//protected UsuarioEmpresa usuarioLogado;
	
	
	
	public static UserSS isAutenticated() {
		return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	
	@Autowired 
    public void setApplicationContext(ApplicationContext ctx) { 
        if (!DefaultListableBeanFactory.class.isAssignableFrom(ctx.getAutowireCapableBeanFactory().getClass())) { 
            throw new IllegalArgumentException("BeanFactory deve ser do tipo DefaultListableBeanFactory"); 
        } 
        
        this.context = ctx; 
        this.beanFactory = (DefaultListableBeanFactory) ctx.getAutowireCapableBeanFactory(); 
    } 	
}
