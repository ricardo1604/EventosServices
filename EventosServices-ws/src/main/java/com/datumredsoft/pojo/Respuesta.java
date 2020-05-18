package com.datumredsoft.pojo;

import java.io.Serializable;

public class Respuesta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8125236730759558787L;
	
	private int codigo;
	private String repuesta;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getRepuesta() {
		return repuesta;
	}
	
	public void setRepuesta(String repuesta) {
		this.repuesta = repuesta;
	}

	
}
