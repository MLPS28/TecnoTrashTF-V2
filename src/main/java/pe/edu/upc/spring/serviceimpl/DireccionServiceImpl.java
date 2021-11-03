package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Direccion;
import pe.edu.upc.spring.repository.IDireccionRepository;
import pe.edu.upc.spring.service.IDireccionService;

@Service
public class DireccionServiceImpl implements IDireccionService {

	@Autowired
	private IDireccionRepository dDireccion;  //drace: objeto o representacion de IRaceRepository
	
	@Override
	@Transactional //los que no impliquen listados solo seran de tipo transactional
	public boolean grabar(Direccion direccion) {
		Direccion objDireccion = dDireccion.save(direccion);
		if (objDireccion == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public void eliminar(int CDireccion) {
		dDireccion.deleteById(CDireccion); //solo necesita el id que se desea eliminar
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Direccion> buscarId(int CDireccion) {
		return dDireccion.findById(CDireccion);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Direccion> listarId(int CDireccion) {
		return dDireccion.findById(CDireccion);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Direccion> listar() {
		return dDireccion.findAll(); //devuelve todo en una lista
	}

	/*@Override
	@Transactional(readOnly = true)
	public List<Direccion> buscarNombre(String nameRace) {
		return dDireccion.buscarNombre(nameRace); //esto es el único método propio que se hico en IRepository
	}  */
	
	@Override
	@Transactional(readOnly = true)
	public List<Direccion> buscarDistrito(String NDistrito) {
		return dDireccion.buscarDistrito(NDistrito); 
	}
	
	/* @Override
	@Transactional(readOnly = true)
	public List<Direccion> buscarPropietario(String nameMaster) {
		return dDireccion.buscarPropietario(nameMaster); 
	} */

}
