package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.LugarDeReporte;

public interface ILugarDeReporteService {
	public boolean grabar(LugarDeReporte lugardereporte);
	public void eliminar(int CDireccion);
	public Optional<LugarDeReporte> listarId(int CDireccion);
	public Optional<LugarDeReporte> buscarId(int CDireccion);
	public List<LugarDeReporte> listar();
	//public List<Pet> buscarNombre(String namePet);	
	public List<LugarDeReporte> buscarDistrito(String NDireccion);	
	//public List<Pet> buscarPropietario(String nameMaster);	
}

