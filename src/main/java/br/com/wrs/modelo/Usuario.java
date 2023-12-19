package br.com.wrs.modelo;

import br.com.wrs.base.Entidade;
import br.com.wrs.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name="usuario")
public class Usuario extends Entidade {


		@Column(name="nome")
		private String nome;

		@Column(name="sobrenome")
		private String sobrenome;

		@Column(name="email")
		private String email;

		@Column(name="senha")
		private String senha;

		@Column(name="data_nascimento")
		private  String dataNascimento;

		@Column(name="telefone")
		private String telefone;

		@Column(name="perfil")
		private Integer perfil;


		@Column(name="confirmar_email")
		private boolean  confirmarEmail;

		@Column(name="foto_perfil")
		private String fotoPerfil;


		@JsonIgnore
		public Perfil getPerfis() {
			return Perfil.toEnum(perfil);
		}

		@JsonIgnore
		public void setPerfil(Perfil perfil) {
			this.perfil = perfil.getCod();
		}
}
