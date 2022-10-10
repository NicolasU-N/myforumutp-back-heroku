package co.edu.utp.misiontic2022.myforumutp.service;

import co.edu.utp.misiontic2022.myforumutp.dto.RolDto;
import co.edu.utp.misiontic2022.myforumutp.model.Rol;

import java.util.List;

public interface RolService {

    RolDto getRolById(Long id);

    List<Rol> getAllRol();

    void saveRol(RolDto usuarioDto);

    void updateRol(Long id, RolDto usuarioDto);

    void deleteRolById(Long id);
}
