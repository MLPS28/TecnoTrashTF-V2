package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Reporte;

public interface IReporteService {
	
	public boolean grabar(Reporte reporte);
	public void eliminar(int CReporte);
	public Optional<Reporte> listarId(int CReporte);
	public Optional<Reporte> buscarId(int CReporte);
	public List<Reporte> listar();
		
	//public List<Reporte> buscarDistrito(String NDireccion);	

}

