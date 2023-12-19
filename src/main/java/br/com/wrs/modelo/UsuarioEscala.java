package br.com.wrs.modelo;

import javax.ws.rs.FormParam;

import br.com.wrs.base.Entidade;

public class UsuarioEscala extends Entidade {

		
		@FormParam("usrId")
		private Integer usrId;
		
		@FormParam("insId")
		private Integer insId;
		
		@FormParam("escId")
		private Integer escId;
		
		@FormParam("minId")
		private Integer minId;
		
		
		public Integer getUsrId() {
			return usrId;
		}
		public void setUsrId(Integer usrId) {
			this.usrId = usrId;
		}
		public Integer getInsId() {
			return insId;
		}
		public void setUnsId(Integer unsId) {
			this.insId = unsId;
		}
		public Integer getEscId() {
			return escId;
		}
		public void setEscId(Integer escId) {
			this.escId = escId;
		}
		public Integer getMinId() {
			return minId;
		}
		public void setMinId(Integer minId) {
			this.minId = minId;
		}
		public void setInsId(Integer insId) {
			this.insId = insId;
		}
		
		
		
		
		
	
}
