package br.com.wrs.modelo;

import br.com.wrs.base.Entidade;

public class Instrumento extends Entidade {

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
