package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Distrito;

public interface IDistritoService {
	public boolean grabar(Distrito distrito);
	
	public void eliminar(int CDistrito);
	public Optional<Distrito> listarId(int CDistrito);
	public List<Distrito> listar();
	public List<Distrito> buscarDistrito(String NDistrito);	
}
