package co.edu.utp.misiontic2022.myforumutp.repository;

import co.edu.utp.misiontic2022.myforumutp.model.Publicacion;
import co.edu.utp.misiontic2022.myforumutp.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
}
