package br.com.wrs.modelo;

import br.com.wrs.base.Entidade;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import java.util.UUID;
@Getter
@Setter
@Entity
@Table(name="minsiterio")
public class Ministerio extends Entidade {


	@FormParam("usuarioLiderId")
	@Column(name="usuario_lider_id")
	private UUID usuarioLiderId;
	
	@FormParam("nome")
	@Column(name="usuario_lider_nome")
	private String nome;


}
