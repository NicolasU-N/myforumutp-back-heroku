package co.edu.utp.misiontic2022.myforumutp.repository;

import co.edu.utp.misiontic2022.myforumutp.model.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {
//    @Query("SELECT publicacion FROM Publicacion publicacion " + " WHERE publicacion.parent_id IS NULL")
//    List<Publicacion> findAllRoots();
//
//    @Query("SELECT category FROM Category category" + " WHERE category.rootCategory.categoryId IN :rootIds ")
//    List<Publicacion> findAllSubCategoriesInRoot(@Param("rootIds") List<Long> rootIds);

    List<Publicacion> findByAsuntoContains(String asunto);
}
