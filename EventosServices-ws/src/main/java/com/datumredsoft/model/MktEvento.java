package com.datumredsoft.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the MKT_EVENTOS database table.
 * 
 */
@Entity
@Table(name="MKT_EVENTOS")
@NamedQuery(name="MktEvento.findAll", query="SELECT m FROM MktEvento m")
public class MktEvento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_EVENTO")
	private int idEvento;

	@Column(name="DESCRIPCION")
	private String descripcion;

	@Column(name="DURACION")
	private String duracion;

	@Column(name="FECHA")
	private String fecha;

	@Column(name="HORA")
	private String hora;

	@Column(name="NOMBRE")
	private String nombre;

	@Column(name="TEMAS")
	private String temas;

	@Column(name="UBICACION")
	private String ubicacion;
	
	@Column(name = "FECHA_HORA_INICIO")
	private Date fechaHoraInicio;
	
	@Column(name = "ID_TIPO_EVENTO")
	private int idTipoEvento;

	//bi-directional many-to-one association to MktRegistro
	@OneToMany(mappedBy="mktEvento")
	private List<MktRegistro> mktRegistros;

	public MktEvento() {
	}

	public int getIdEvento() {
		return this.idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDuracion() {
		return this.duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTemas() {
		return this.temas;
	}

	public void setTemas(String temas) {
		this.temas = temas;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getIdTipoEvento() {
		return idTipoEvento;
	}

	public void setIdTipoEvento(int idTipoEvento) {
		this.idTipoEvento = idTipoEvento;
	}

	public List<MktRegistro> getMktRegistros() {
		return this.mktRegistros;
	}

	public void setMktRegistros(List<MktRegistro> mktRegistros) {
		this.mktRegistros = mktRegistros;
	}

	public Date getFechaHoraInicio() {
		return fechaHoraInicio;
	}

	public void setFechaHoraInicio(Date fechaHoraInicio) {
		this.fechaHoraInicio = fechaHoraInicio;
	}

	public MktRegistro addMktRegistro(MktRegistro mktRegistro) {
		getMktRegistros().add(mktRegistro);
		mktRegistro.setMktEvento(this);

		return mktRegistro;
	}

	public MktRegistro removeMktRegistro(MktRegistro mktRegistro) {
		getMktRegistros().remove(mktRegistro);
		mktRegistro.setMktEvento(null);

		return mktRegistro;
	}

}