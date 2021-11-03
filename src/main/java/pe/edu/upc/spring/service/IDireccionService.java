package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Direccion;

public interface IDireccionService {
	public boolean grabar(Direccion direccion);
	public void eliminar(int CDireccion);
	public Optional<Direccion> listarId(int CDireccion);
	public Optional<Direccion> buscarId(int CDireccion);
	public List<Direccion> listar();
	//public List<Pet> buscarNombre(String namePet);	
	public List<Direccion> buscarDistrito(String NDireccion);	
	//public List<Pet> buscarPropietario(String nameMaster);	
}

