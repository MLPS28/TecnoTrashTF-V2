package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.UsuarioPremio;
import pe.edu.upc.spring.repository.IUsuarioPremioRepository;
import pe.edu.upc.spring.service.IUsuarioPremioService;

@Service
public class UsuarioPremioServiceImpl implements IUsuarioPremioService {

	@Autowired
	private IUsuarioPremioRepository dUsuarioPremio;  //drace: objeto o representacion de IRaceRepository
	
	@Override
	@Transactional //los que no impliquen listados solo seran de tipo transactional
	public boolean grabar(UsuarioPremio usuariopremio) {
		UsuarioPremio objUsuarioPremio = dUsuarioPremio.save(usuariopremio);
		if (objUsuarioPremio == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public void eliminar(int CUsuarioPremio) {
		dUsuarioPremio.deleteById(CUsuarioPremio); //solo necesita el id que se desea eliminar
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<UsuarioPremio> buscarId(int CUsuarioPremio) {
		return dUsuarioPremio.findById(CUsuarioPremio);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<UsuarioPremio> listarId(int CUsuarioPremio) {
		return dUsuarioPremio.findById(CUsuarioPremio);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UsuarioPremio> listar() {
		return dUsuarioPremio.findAll(); //devuelve todo en una lista
	}

	/*@Override
	@Transactional(readOnly = true)
	public List<Direccion> buscarNombre(String nameRace) {
		return dDireccion.buscarNombre(nameRace); //esto es el único método propio que se hico en IRepository
	}  */
	
	@Override
	@Transactional(readOnly = true)
	public List<UsuarioPremio> buscarUsuario(String NUsuario) {
		return dUsuarioPremio.buscarUsuario(NUsuario); 
	}
	
	/* @Override
	@Transactional(readOnly = true)
	public List<Direccion> buscarPropietario(String nameMaster) {
		return dDireccion.buscarPropietario(nameMaster); 
	} */

}
