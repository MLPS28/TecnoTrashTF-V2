package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.TipoVia;

public interface ITipoViaService {
	public boolean grabar(TipoVia tipovia);
	
	public void eliminar(int CTipoVia);
	public Optional<TipoVia> listarId(int CTipoVia);
	public List<TipoVia> listar();
	public List<TipoVia> buscarTipoVia(String NTipoVia);	
}
