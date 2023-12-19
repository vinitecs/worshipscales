package br.com.wrs.modelo;

import javax.ws.rs.FormParam;

import br.com.wrs.base.Entidade;

public class UsuarioInstrumento extends Entidade {
	
		
		@FormParam("usrId")
		public Integer usrId;
		
		@FormParam("insId")
		public Integer insId;
		
		@FormParam("escalaId")
		public Integer escalaId;
		
		@FormParam("nomeInstrumento")
		public String  nomeInstrumento;
		
		
		public Integer getUsrId() {
			return usrId;
		}
		public void setUsrId(Integer usrId) {
			this.usrId = usrId;
		}
		public Integer getInsId() {
			return insId;
		}
		public void setInsId(Integer insId) {
			this.insId = insId;
		}
		public Integer getEscalaId() {
			return escalaId;
		}
		public void setEscalaId(Integer escalaId) {
			this.escalaId = escalaId;
		}
		public String getNomeInstrumento() {
			return nomeInstrumento;
		}
		public void setNomeInstrumento(String nomeInstrumento) {
			this.nomeInstrumento = nomeInstrumento;
		}
		
		/*@Override
		public int hashCode() {
			return Objects.hash(insId);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			UsuarioInstrumento other = (UsuarioInstrumento) obj;
			return Objects.equals(insId, other.insId);
		}*/
		
		

}
