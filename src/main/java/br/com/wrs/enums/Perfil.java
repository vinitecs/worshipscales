package br.com.wrs.enums;

public enum Perfil {
	 
	LIDER(1,"ROLE_LIDER"),
	 MUSICO(2,"ROLE_MUSICO"),
	 MINISTRO(3,"ROLE_MINISTRO");
	
	private  Perfil(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	private Integer cod;
	private String descricao;
	
	public Integer  getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	
	public static Perfil toEnum(Integer cod ) {
		if(cod == null) {
			return null;
		}
		
		for(Perfil x : Perfil.values()) {
			if(x.getCod() == cod ) {
				return x;
			}			
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	 
}
