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
@Table(name="instrumento_ministerio")
public class InstrumentoMinisterio extends Entidade {

    @Column(name="nome_instrumento")
    private String nome;

}
