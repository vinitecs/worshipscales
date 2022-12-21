package br.com.wrs.bean;

import javax.ws.rs.FormParam;

import br.com.wrs.base.Bean;

public class Instrumento extends Bean{

		private Integer minId; 
		private  String nomeInstrumento;
		
		
		public Integer getMinId() {
			return minId;
		}
		public void setMinId(Integer minId) {
			this.minId = minId;
		}
		public String getNomeInstrumento() {
			return nomeInstrumento;
		}
		public void setNomeInstrumento(String nomeInstrumento) {
			this.nomeInstrumento = nomeInstrumento;
		}
		
		

}
