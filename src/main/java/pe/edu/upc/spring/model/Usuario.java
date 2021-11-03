package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CUsuario;
	
	@Column(name="NUsuario", length=60, nullable=false)
	private String NUsuario;
	
	@Column(name="NDNI", length=8, nullable=false)
	private int NDNI;
	
	@Column(name="NEmail", length=60, nullable=false)
	private String NEmail;
	
	@Column(name="QPuntos", nullable=false)
	private int QPuntos;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(int cUsuario, String nUsuario, int nDNI, String nEmail, int qPuntos) {
		super();
		CUsuario = cUsuario;
		NUsuario = nUsuario;
		NDNI = nDNI;
		NEmail = nEmail;
		QPuntos = qPuntos;
	}

	public int getCUsuario() {
		return CUsuario;
	}

	public void setCUsuario(int cUsuario) {
		CUsuario = cUsuario;
	}

	public String getNUsuario() {
		return NUsuario;
	}

	public void setNUsuario(String nUsuario) {
		NUsuario = nUsuario;
	}

	public int getNDNI() {
		return NDNI;
	}

	public void setNDNI(int nDNI) {
		NDNI = nDNI;
	}

	public String getNEmail() {
		return NEmail;
	}

	public void setNEmail(String nEmail) {
		NEmail = nEmail;
	}

	public int getQPuntos() {
		return QPuntos;
	}

	public void setQPuntos(int qPuntos) {
		QPuntos = qPuntos;
	}
		
}
