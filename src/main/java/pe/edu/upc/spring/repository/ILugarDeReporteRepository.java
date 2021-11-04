package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.LugarDeReporte;

@Repository //siempre indicar que es una interfaz de tipo repository
public interface ILugarDeReporteRepository extends JpaRepository<LugarDeReporte, Integer>{
	//@Query("from Pet p where p.namePet like %:namePet%")
	//List<Direccion> buscarNombre(@Param("namePet") String namePet);
	
	@Query("from Direccion d where d.distrito.NDistrito like %:NDistrito%")
	List<LugarDeReporte> buscarDistrito(@Param("NDistrito") String NDistrito);
	
	//@Query("from Pet p where p.dueno.nameMaster like %:nameMaster%")
	//List<Direccion> buscarPropietario(@Param("nameMaster") String nameMaster);
	
}
