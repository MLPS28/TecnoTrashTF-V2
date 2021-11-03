package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Premio")
public class Premio implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CPremio;
	
	@Column(name="NPremio", length=60, nullable=false)
	private String NPremio;

	public Premio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Premio(int cPremio, String nPremio) {
		super();
		CPremio = cPremio;
		NPremio = nPremio;
	}

	public int getCPremio() {
		return CPremio;
	}

	public void setCPremio(int cPremio) {
		CPremio = cPremio;
	}

	public String getNPremio() {
		return NPremio;
	}

	public void setNPremio(String nPremio) {
		NPremio = nPremio;
	}

	
}
