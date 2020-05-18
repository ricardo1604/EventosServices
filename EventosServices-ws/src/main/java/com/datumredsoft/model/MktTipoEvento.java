package com.datumredsoft.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MKT_TIPO_EVENTO database table.
 * 
 */
@Entity
@Table(name="MKT_TIPO_EVENTO")
@NamedQuery(name="MktTipoEvento.findAll", query="SELECT m FROM MktTipoEvento m")
public class MktTipoEvento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_TIPO_EVENTO")
	private int idTipoEvento;

	@Column(name="DESCRIPCION")
	private String descripcion;

	@Column(name="NOMBRE")
	private String nombre;

	//bi-directional many-to-one association to MktEvento
	//@OneToMany(mappedBy="mktTipoEvento")
	//private List<MktEvento> mktEventos;

	public MktTipoEvento() {
	}

	public MktTipoEvento(int idTipoEvento) {
		super();
		this.idTipoEvento = idTipoEvento;
	}



	public int getIdTipoEvento() {
		return this.idTipoEvento;
	}

	public void setIdTipoEvento(int idTipoEvento) {
		this.idTipoEvento = idTipoEvento;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/*
	public List<MktEvento> getMktEventos() {
		return this.mktEventos;
	}

	public void setMktEventos(List<MktEvento> mktEventos) {
		this.mktEventos = mktEventos;
	}

	public MktEvento addMktEvento(MktEvento mktEvento) {
		getMktEventos().add(mktEvento);
		mktEvento.setMktTipoEvento(this);

		return mktEvento;
	}
	

	public MktEvento removeMktEvento(MktEvento mktEvento) {
		getMktEventos().remove(mktEvento);
		mktEvento.setMktTipoEvento(null);

		return mktEvento;
	}
	 */
}