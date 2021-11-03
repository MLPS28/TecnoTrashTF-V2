package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.TipoVia;

@Repository							   //<sobre que entidad, El primary key(el cual es int este caso se pone integer)>
public interface ITipoViaRepository extends JpaRepository<TipoVia, Integer>{ //gracias a Extends, iracerepository puede hacer uso de las operaciones de jpare
	@Query("from TipoVia t where t.NTipoVia like %:NTipoVia%")
	List<TipoVia> buscarTipoVia(@Param("NTipoVia") String NTipoVia); //este es el unico metodo propio de esta interfaz
}
