package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Premio;
import pe.edu.upc.spring.repository.IPremioRepository;
import pe.edu.upc.spring.service.IPremioService;

@Service
public class PremioServiceImpl implements IPremioService {

	@Autowired //ya no es inject
	private IPremioRepository dPremio;  //drace: objeto o representacion de IRaceRepository
	
	@Override
	@Transactional //los que no impliquen listados solo seran de tipo transactional
	public boolean grabar(Premio premio) {
		Premio objPremio = dPremio.save(premio);
		if (objPremio == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public void eliminar(int CPremio) {
		dPremio.deleteById(CPremio); //solo necesita el id que se desea eliminar
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Premio> listarId(int CPremio) {
		return dPremio.findById(CPremio);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Premio> listar() {
		return dPremio.findAll(); //devuelve todo en una lista
	}

	@Override
	@Transactional(readOnly = true)
	public List<Premio> buscarPremio(String NPremio) {
		return dPremio.buscarPremio(NPremio); //esto es el único método propio que se hico en IRepository
	}

}
