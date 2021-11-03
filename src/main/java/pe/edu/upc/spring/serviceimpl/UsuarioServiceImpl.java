package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Usuario;
import pe.edu.upc.spring.repository.IUsuarioRepository;
import pe.edu.upc.spring.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired //ya no es inject
	private IUsuarioRepository dUsuario;  //drace: objeto o representacion de IRaceRepository
	
	@Override
	@Transactional //los que no impliquen listados solo seran de tipo transactional
	public boolean grabar(Usuario usuario) {
		Usuario objUsuario = dUsuario.save(usuario);
		if (objUsuario == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public void eliminar(int CUsuario) {
		dUsuario.deleteById(CUsuario); //solo necesita el id que se desea eliminar
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> listarId(int CUsuario) {
		return dUsuario.findById(CUsuario);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> listar() {
		return dUsuario.findAll(); //devuelve todo en una lista
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> buscarNombre(String NUsuario) {
		return dUsuario.buscarNombre(NUsuario); //esto es el único método propio que se hico en IRepository
	}

}
