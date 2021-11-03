package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TipoVia")
public class TipoVia implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CTipoVia;
	
	@Column(name="NTipoVia", length=60, nullable=false)
	private String NTipoVia;

	public TipoVia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoVia(int cTipoVia, String nTipoVia) {
		super();
		CTipoVia = cTipoVia;
		NTipoVia = nTipoVia;
	}

	public int getCTipoVia() {
		return CTipoVia;
	}

	public void setCTipoVia(int cTipoVia) {
		CTipoVia = cTipoVia;
	}

	public String getNTipoVia() {
		return NTipoVia;
	}

	public void setNTipoVia(String nTipoVia) {
		NTipoVia = nTipoVia;
	}

	
}
