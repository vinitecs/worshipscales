package br.com.wrs.dto;

import br.com.wrs.enums.TipoMinisterio;
import br.com.wrs.modelo.InstrumentoMinisterio;
import br.com.wrs.modelo.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MinisterioDTO {

	private String nomeMinisterio;
	private String igreja;
	private Usuario usuario;
	private List<InstrumentoMinisterio> instrumentoMinisterios = new ArrayList<>();
	private TipoMinisterio tipoMinisterio;

}
