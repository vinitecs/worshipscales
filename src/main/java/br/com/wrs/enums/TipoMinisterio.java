package br.com.wrs.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoMinisterio {

    LOUVOR("louvor",1),
    VOLUNTARIO("Voluntário",2);



    private String nome;
    private Integer tipo;

}
