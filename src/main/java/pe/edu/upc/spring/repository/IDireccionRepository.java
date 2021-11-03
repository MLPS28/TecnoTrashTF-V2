package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Direccion;

@Repository //siempre indicar que es una interfaz de tipo repository
public interface IDireccionRepository extends JpaRepository<Direccion, Integer>{
	//@Query("from Pet p where p.namePet like %:namePet%")
	//List<Direccion> buscarNombre(@Param("namePet") String namePet);
	
	@Query("from Direccion d where d.distrito.NDistrito like %:NDistrito%")
	List<Direccion> buscarDistrito(@Param("NDistrito") String NDistrito);
	
	//@Query("from Pet p where p.dueno.nameMaster like %:nameMaster%")
	//List<Direccion> buscarPropietario(@Param("nameMaster") String nameMaster);
	
}
