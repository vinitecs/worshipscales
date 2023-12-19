package br.com.wrs.security;

import br.com.wrs.util.JWTUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

	private UserDetailsService userDetailsService;
	private JWTUtil jwtUtil;
	
	public JWTAuthorizationFilter(AuthenticationManager authenticationManager,JWTUtil jwtUtil,UserDetailsService userDetailsService ) {
		super(authenticationManager);
		this.userDetailsService= userDetailsService;
		this.jwtUtil = jwtUtil;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chaim) throws IOException, ServletException {

		String getHeader = req.getHeader("Authorization");


		if(getHeader != null  && getHeader.startsWith("Bearer ")) {
			UsernamePasswordAuthenticationToken auth = getAuthentication(req, getHeader.substring(7));

			if(auth != null) {
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		}

		chaim.doFilter(req, res);

	}

	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest req, String token) {
		
		if(jwtUtil.tokenValido(token)) {
			String username = jwtUtil.getUsername(token);
			UserDetails user = userDetailsService.loadUserByUsername(username);
			return new UsernamePasswordAuthenticationToken(user, null,user.getAuthorities());
		}
		
	
	return null;
	}
}
