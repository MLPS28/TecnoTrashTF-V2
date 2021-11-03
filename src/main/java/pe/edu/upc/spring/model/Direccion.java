package pe.edu.upc.spring.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="LugarDeReporte")
public class Direccion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CDireccion;
	
	@Column(name="NDireccion", length=80, nullable=false)
	private String NDireccion;
	
	@Column(name="NumDireccion", nullable=false)
	private String NumDireccion;
	
	@ManyToOne
	@JoinColumn(name="CDistrito", nullable=false)
	private Distrito distrito;
	
	@ManyToOne
	@JoinColumn(name="CTipoVia", nullable=false)
	private TipoVia tipovia;

	public Direccion() {
		super();

	}

	public Direccion(int cDireccion, String nDireccion, String numDireccion, Distrito distrito, TipoVia tipovia) {
		super();
		CDireccion = cDireccion;
		NDireccion = nDireccion;
		NumDireccion = numDireccion;
		this.distrito = distrito;
		this.tipovia = tipovia;
	}

	public int getCDireccion() {
		return CDireccion;
	}

	public void setCDireccion(int cDireccion) {
		CDireccion = cDireccion;
	}

	public String getNDireccion() {
		return NDireccion;
	}

	public void setNDireccion(String nDireccion) {
		NDireccion = nDireccion;
	}

	public String getNumDireccion() {
		return NumDireccion;
	}

	public void setNumDireccion(String numDireccion) {
		NumDireccion = numDireccion;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public TipoVia getTipovia() {
		return tipovia;
	}

	public void setTipovia(TipoVia tipovia) {
		this.tipovia = tipovia;
	}	
	
}
