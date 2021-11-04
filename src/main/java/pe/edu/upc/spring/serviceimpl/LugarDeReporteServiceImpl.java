package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.LugarDeReporte;
import pe.edu.upc.spring.repository.ILugarDeReporteRepository;
import pe.edu.upc.spring.service.ILugarDeReporteService;

@Service
public class LugarDeReporteServiceImpl implements ILugarDeReporteService {

	@Autowired
	private ILugarDeReporteRepository dDireccion;  //drace: objeto o representacion de IRaceRepository
	
	@Override
	@Transactional //los que no impliquen listados solo seran de tipo transactional
	public boolean grabar(LugarDeReporte lugardereporte) {
		LugarDeReporte objLugarDeReporte = dDireccion.save(lugardereporte);
		if (objLugarDeReporte == null)
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
	public Optional<LugarDeReporte> buscarId(int CDireccion) {
		return dDireccion.findById(CDireccion);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<LugarDeReporte> listarId(int CDireccion) {
		return dDireccion.findById(CDireccion);
	}

	@Override
	@Transactional(readOnly = true)
	public List<LugarDeReporte> listar() {
		return dDireccion.findAll(); //devuelve todo en una lista
	}

	/*@Override
	@Transactional(readOnly = true)
	public List<Direccion> buscarNombre(String nameRace) {
		return dDireccion.buscarNombre(nameRace); //esto es el único método propio que se hico en IRepository
	}  */
	
	@Override
	@Transactional(readOnly = true)
	public List<LugarDeReporte> buscarDistrito(String NDistrito) {
		return dDireccion.buscarDistrito(NDistrito); 
	}
	
	/* @Override
	@Transactional(readOnly = true)
	public List<Direccion> buscarPropietario(String nameMaster) {
		return dDireccion.buscarPropietario(nameMaster); 
	} */

}
