package br.com.wrs.modelo;

import br.com.wrs.base.Entidade;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(schema = "public", name="escalas")
public class Escalas extends Entidade {


		@Column(name = "ministerio_id")
		private Integer minId;


		@Column(name = "data_escala")
		private String dataEscala;


}
