package br.com.wrs.bean;

import java.util.ArrayList;

import javax.ws.rs.FormParam;

import br.com.wrs.base.Bean;

public class Escalas extends Bean{
		
		@FormParam("minId")
		private Integer minId;
		
		@FormParam("dataEscala")
		private String dataEscala;
		
		
		public Integer getMinId() {
			return minId;
		}
		public void setMinId(Integer minId) {
			this.minId = minId;
		}
		public String getDataEscala() {
			return dataEscala;
		}
		public void setDataEscala(String dataEscala) {
			this.dataEscala = dataEscala;
		}
	
		
		
		
		
}
