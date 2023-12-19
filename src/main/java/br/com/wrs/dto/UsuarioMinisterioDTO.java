package br.com.wrs.dto;

import br.com.wrs.base.Entidade;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class UsuarioMinisterioDTO  extends Entidade {
		
	@Getter
	@Setter
	private Integer usuarioLider;
	
	
	
}
