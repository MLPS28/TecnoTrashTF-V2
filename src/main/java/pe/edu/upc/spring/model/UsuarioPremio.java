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
@Table(name="UsuarioPremio")
public class UsuarioPremio implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CUsuarioPremio;
	
	@Column(name="QReporte", nullable=false)
	private int QReporte;

	@Temporal(TemporalType.DATE)
	@Column(name="DFecha")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date DFecha;
	
	@ManyToOne
	@JoinColumn(name="CPremio", nullable=false)
	private Premio premio;
	
	@ManyToOne
	@JoinColumn(name="CUsuario", nullable=false)
	private Usuario usuario;

	public UsuarioPremio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsuarioPremio(int cUsuarioPremio, int qReporte, Date dFecha, Premio premio, Usuario usuario) {
		super();
		CUsuarioPremio = cUsuarioPremio;
		QReporte = qReporte;
		DFecha = dFecha;
		this.premio = premio;
		this.usuario = usuario;
	}

	public int getCUsuarioPremio() {
		return CUsuarioPremio;
	}

	public void setCUsuarioPremio(int cUsuarioPremio) {
		CUsuarioPremio = cUsuarioPremio;
	}

	public int getQReporte() {
		return QReporte;
	}

	public void setQReporte(int qReporte) {
		QReporte = qReporte;
	}

	public Date getDFecha() {
		return DFecha;
	}

	public void setDFecha(Date dFecha) {
		DFecha = dFecha;
	}

	public Premio getPremio() {
		return premio;
	}

	public void setPremio(Premio premio) {
		this.premio = premio;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
