package br.com.wrs.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/wrs")
public class JerseyAppConfig extends ResourceConfig {
	
	public JerseyAppConfig() {
		packages("br.com.wrs.bc");
	}

}
