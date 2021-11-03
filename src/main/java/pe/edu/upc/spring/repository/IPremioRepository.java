package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Premio;

@Repository							   //<sobre que entidad, El primary key(el cual es int este caso se pone integer)>
public interface IPremioRepository extends JpaRepository<Premio, Integer>{ //gracias a Extends, iracerepository puede hacer uso de las operaciones de jpare
	@Query("from Premio p where p.NPremio like %:NPremio%")
	List<Premio> buscarPremio(@Param("NPremio") String NPremio); //este es el unico metodo propio de esta interfaz
}
