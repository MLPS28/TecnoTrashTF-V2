package pe.edu.upc.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="Reporte")
public class Reporte implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CReporte;
	
	@Column(name="TDescripcion", length=80, nullable=false)
	private String TDescripcion;
	
	@Column(name="QPuntosReporte", nullable=false)
	private int QPuntosReporte;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DFecha")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date DFecha;
	
	
	@ManyToOne
	@JoinColumn(name="CDireccion", nullable=false)
	private Direccion direccion;

	public Reporte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reporte(int cReporte, String tDescripcion, int qPuntosReporte, Date dFecha,
			Direccion direccion) {
		super();
		CReporte = cReporte;
		TDescripcion = tDescripcion;
		QPuntosReporte = qPuntosReporte;
		DFecha = dFecha;
		this.direccion = direccion;
	}

	public int getCReporte() {
		return CReporte;
	}

	public void setCReporte(int cReporte) {
		CReporte = cReporte;
	}

	public String getTDescripcion() {
		return TDescripcion;
	}

	public void setTDescripcion(String tDescripcion) {
		TDescripcion = tDescripcion;
	}

	public int getQPuntosReporte() {
		return QPuntosReporte;
	}

	public void setQPuntosReporte(int qPuntosReporte) {
		QPuntosReporte = qPuntosReporte;
	}

	public Date getDFecha() {
		return DFecha;
	}

	public void setDFecha(Date dFecha) {
		DFecha = dFecha;
	}
	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	
	
	
}
