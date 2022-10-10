package co.edu.utp.misiontic2022.myforumutp.repository;

import co.edu.utp.misiontic2022.myforumutp.model.Usuario;
import co.edu.utp.misiontic2022.myforumutp.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {
}
