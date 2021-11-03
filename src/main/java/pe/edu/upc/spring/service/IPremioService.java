package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Premio;

public interface IPremioService {
	public boolean grabar(Premio premio);
	
	public void eliminar(int CPremio);
	public Optional<Premio> listarId(int CPremio);
	public List<Premio> listar();
	public List<Premio> buscarPremio(String NPremio);	
}
