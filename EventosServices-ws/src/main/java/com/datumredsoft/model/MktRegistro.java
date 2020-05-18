package com.datumredsoft.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MKT_REGISTROS database table.
 * 
 */
@Entity
@Table(name="MKT_REGISTROS")
@NamedQuery(name="MktRegistro.findAll", query="SELECT m FROM MktRegistro m")
public class MktRegistro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_INVITADO")
	private int idInvitado;

	@Column(name="APELLIDOS")
	private String apellidos;

	@Column(name="ASISTENCIA")
	private byte asistencia;

	@Column(name="CIUDAD")
	private String ciudad;

	@Column(name="DEPARTAMENTO")
	private String departamento;

	@Column(name="EMAIL")
	private String email;

	@Column(name="EMPRESA")
	private String empresa;

	@Column(name="CARGO")
	private String cargo;
	
	@Column(name="NOMBRES")
	private String nombres;

	@Column(name="NUM_TELEFONO")
	private String numTelefono;

	@Column(name="PAIS")
	private String pais;

	//bi-directional many-to-one association to MktEvento
	@ManyToOne
	@JoinColumn(name="ID_EVENTO", insertable = false, updatable = false)
	private MktEvento mktEvento;

	public MktRegistro() {
	}

	public int getIdInvitado() {
		return this.idInvitado;
	}

	public void setIdInvitado(int idInvitado) {
		this.idInvitado = idInvitado;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public byte getAsistencia() {
		return this.asistencia;
	}

	public void setAsistencia(byte asistencia) {
		this.asistencia = asistencia;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getNumTelefono() {
		return this.numTelefono;
	}

	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public MktEvento getMktEvento() {
		return this.mktEvento;
	}

	public void setMktEvento(MktEvento mktEvento) {
		this.mktEvento = mktEvento;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}