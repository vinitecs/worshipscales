package br.com.wrs.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class InstrumentoDTO {
	
	@JsonProperty
	private Integer id;	
	
	@JsonProperty
	private Integer minId;		

	
}
