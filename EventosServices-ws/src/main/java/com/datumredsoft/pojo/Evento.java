package com.datumredsoft.pojo;

import java.io.Serializable;

public class Evento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2972300706006244706L;

	private int id;
	private String nombre;
	private String descripcion;
	private String temas;
	private String ubicacion;
	private String fecha;
	private String hora;
	private String duracion;
	private String idTipoEvento;
	private String fechaHoraInicio;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTemas() {
		return temas;
	}
	public void setTemas(String temas) {
		this.temas = temas;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public String getIdTipoEvento() {
		return idTipoEvento;
	}
	public void setIdTipoEvento(String idTipoEvento) {
		this.idTipoEvento = idTipoEvento;
	}
	public String getFechaHoraInicio() {
		return fechaHoraInicio;
	}
	public void setFechaHoraInicio(String fechaHoraInicio) {
		this.fechaHoraInicio = fechaHoraInicio;
	}
	@Override
	public String toString() {
		return "Evento [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", temas=" + temas
				+ ", ubicacion=" + ubicacion + ", fecha=" + fecha + ", hora=" + hora + ", duracion=" + duracion
				+ ", idTipoEvento=" + idTipoEvento + ", fechaHoraInicio=" + fechaHoraInicio + "]";
	}
	
	
}
