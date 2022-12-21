package br.com.wrs.bean;

import javax.ws.rs.FormParam;


import br.com.wrs.base.Bean;
import br.com.wrs.enums.Perfil;

public class Usuario extends Bean{

	
		
		@FormParam("nome")
		private String nome;
		
		@FormParam("email")
		private String email;
		
		@FormParam("senha")
		private String senha;
		
		@FormParam("dataNascimento")
		private  String dataNascimento;
				
		@FormParam("telefone")
		private String telefone;
		
		@FormParam("perfil")
		private Integer perfil; 
		
	
		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha =  senha;
		}

		public String getTelefone() {
			return telefone;
		}

		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}

		public String getDataNascimento() {
			return dataNascimento;
		}

		public void setDataNascimento(String dataNascimento) {
			this.dataNascimento = dataNascimento;
		}

		public Perfil getPerfis() {
			return Perfil.toEnum(perfil);
		}
		
		public void setPerfil(Perfil perfil) {
			this.perfil = perfil.getCod();
		}
}
