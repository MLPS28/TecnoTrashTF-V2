package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.UsuarioPremio;

public interface IUsuarioPremioService {
	public boolean grabar(UsuarioPremio usuariopremio);
	public void eliminar(int CUsuarioPremio);
	public Optional<UsuarioPremio> listarId(int CUsuarioPremio);
	public Optional<UsuarioPremio> buscarId(int CUsuarioPremio);
	public List<UsuarioPremio> listar();
	//public List<Pet> buscarNombre(String namePet);	
	public List<UsuarioPremio> buscarUsuario(String NUsuario);	
	//public List<Pet> buscarPropietario(String nameMaster);	
}

