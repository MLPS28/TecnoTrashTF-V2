package pe.edu.upc.spring.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
/*import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;*/
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Users;

@Repository							   //<sobre que entidad, El primary key(el cual es int este caso se pone integer)>
public interface IUsuarioRepository extends JpaRepository<Users, Long>{ //gracias a Extends, iracerepository puede hacer uso de las operaciones de jpare
	public Users findByUsername(String username);
	
	/*@Query("from Usuario u where u.NUsuario like %:NUsuario%")
	List<Usuario> buscarNombre(@Param("NUsuario") String NUsuario); //este es el unico metodo propio de esta interfaz
*/
}
