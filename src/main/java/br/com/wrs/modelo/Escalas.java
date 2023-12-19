package br.com.wrs.modelo;

import br.com.wrs.base.Entidade;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.ws.rs.FormParam;

@Getter
@Setter
@Entity
@Table(name="escalas")
public class Escalas extends Entidade {

		@FormParam("minId")
		@Column(name = "ministerio_id")
		private Integer minId;

		@FormParam("dataEscala")
		@Column(name = "data_escala")
		private String dataEscala;


}
