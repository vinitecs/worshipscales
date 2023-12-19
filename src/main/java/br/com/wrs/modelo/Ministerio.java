package br.com.wrs.modelo;

import br.com.wrs.base.Entidade;
import br.com.wrs.enums.TipoMinisterio;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name="ministerio")
public class Ministerio extends Entidade {


	@Column(name="nome_ministerio")
	private String nomeMinisterio;

	@Column(name="nome_igreja")
	private String igreja;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario_lider",nullable = false)
	private Usuario usuario;

	@OneToMany
	@JoinColumn(name = "instrumento_id",nullable = false)
	private List<InstrumentoMinisterio> instrumentoMinisterios = new ArrayList<>();


	@Column(name="tipo_mininisterio")
	private TipoMinisterio tipoMinisterio;



}
