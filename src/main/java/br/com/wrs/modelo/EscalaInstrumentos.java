package br.com.wrs.modelo;

import br.com.wrs.base.Entidade;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="escala_instrumentos")
public class EscalaInstrumentos extends Entidade {

    @Column(name="instrumento_id")
    private UUID InstrumentoId;
}
