package br.com.wrs.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/wrs")
public class JerseyAppConfig extends ResourceConfig {
	
	public JerseyAppConfig() {
		packages("br.com.wrs.bc");
	}

}
