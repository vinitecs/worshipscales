package br.com.wrs.base;

import br.com.wrs.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;

import com.google.gson.Gson;
import org.springframework.security.core.context.SecurityContextHolder;

//import br.com.vd.bean.UsuarioEmpresa;

public class Endpoint {

	protected ApplicationContext context;
	protected DefaultListableBeanFactory beanFactory; 

	public Gson gs = new Gson();

	@Autowired 
    public void setApplicationContext(ApplicationContext ctx) { 
        if (!DefaultListableBeanFactory.class.isAssignableFrom(ctx.getAutowireCapableBeanFactory().getClass())) { 
            throw new IllegalArgumentException("BeanFactory deve ser do tipo DefaultListableBeanFactory"); 
        }

        this.context = ctx; 
        this.beanFactory = (DefaultListableBeanFactory) ctx.getAutowireCapableBeanFactory(); 
    }


    public  static  UserSS authenticated() {
        try {
            return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }
        catch(Exception e) {
            return null;
        }
    }
}
