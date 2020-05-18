package com.datumredsoft.pojo;

import java.io.Serializable;

public class TipoEvento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3551916837471438218L;

	private String idTipoEvento;
	private String tipoEvento;
	
	
	public String getIdTipoEvento() {
		return idTipoEvento;
	}
	public void setIdTipoEvento(String idTipoEvento) {
		this.idTipoEvento = idTipoEvento;
	}
	public String getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	
	
}
