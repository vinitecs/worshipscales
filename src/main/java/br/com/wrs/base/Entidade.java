package br.com.wrs.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public class Entidade {

	@Id
	@GeneratedValue
	private UUID id;

	@JsonIgnore
	public boolean isNew( UUID id){
		return Objects.nonNull(id);
	}
	
}
