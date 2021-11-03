package pe.edu.upc.spring.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Reporte;

@Repository //siempre indicar que es una interfaz de tipo repository
public interface IReporteRepository extends JpaRepository<Reporte, Integer>{
	

	
	//@Query("from Reporte r where r.distrito.NDistrito like %:NDistrito%")
	//List<Reporte> buscarDistrito(@Param("NDistrito") String NDistrito);
	
}
