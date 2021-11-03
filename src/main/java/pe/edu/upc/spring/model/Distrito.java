package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Districto")
public class Distrito implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CDistrito;
	
	@Column(name="NDistrito", length=60, nullable=false)
	private String NDistrito;

	public Distrito() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Distrito(int cDistrito, String nDistrito) {
		super();
		CDistrito = cDistrito;
		NDistrito = nDistrito;
	}

	public int getCDistrito() {
		return CDistrito;
	}

	public void setCDistrito(int cDistrito) {
		CDistrito = cDistrito;
	}

	public String getNDistrito() {
		return NDistrito;
	}

	public void setNDistrito(String nDistrito) {
		NDistrito = nDistrito;
	}

}
