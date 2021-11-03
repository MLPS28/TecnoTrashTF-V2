package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Reporte;
import pe.edu.upc.spring.repository.IReporteRepository;
import pe.edu.upc.spring.service.IReporteService;

@Service
public class ReporteServiceImpl implements IReporteService {

	@Autowired
	private IReporteRepository dReporte;  //drace: objeto o representacion de IRaceRepository
	
	@Override
	@Transactional //los que no impliquen listados solo seran de tipo transactional
	public boolean grabar(Reporte reporte) {
		Reporte objReporte = dReporte.save(reporte);
		if (objReporte == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public void eliminar(int CReporte) {
		dReporte.deleteById(CReporte); //solo necesita el id que se desea eliminar
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Reporte> buscarId(int CReporte) {
		return dReporte.findById(CReporte);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Reporte> listarId(int CReporte) {
		return dReporte.findById(CReporte);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Reporte> listar() {
		return dReporte.findAll(); //devuelve todo en una lista
	}

	
	
	/*@Override
	@Transactional(readOnly = true)
	public List<Reporte> buscarDistrito(String NDistrito) {
		return dReporte.buscarDistrito(NDistrito); 
	}*/
	
	

}
