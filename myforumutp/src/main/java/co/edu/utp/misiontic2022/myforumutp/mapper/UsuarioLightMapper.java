package co.edu.utp.misiontic2022.myforumutp.mapper;

import co.edu.utp.misiontic2022.myforumutp.dto.PublicacionDto;
import co.edu.utp.misiontic2022.myforumutp.dto.UsuarioLightDto;
import co.edu.utp.misiontic2022.myforumutp.model.Publicacion;
import co.edu.utp.misiontic2022.myforumutp.model.Rol;
import co.edu.utp.misiontic2022.myforumutp.model.Usuario;
import co.edu.utp.misiontic2022.myforumutp.model.Voto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PublicacionMapper.class})
public interface UsuarioLightMapper {

    @Named("UsuarioLight")
    UsuarioLightDto toDto(Usuario usuario);

    @Named("toDtoListUsuarioLight")
    @IterableMapping(qualifiedByName = "UsuarioLight")
    List<UsuarioLightDto> toDtoList(List<Usuario> usuarios);

    @BeforeMapping
    default void defineIsAdmin(Usuario usuario, @MappingTarget UsuarioLightDto dto) {
        for (Rol rol : usuario.getRoles()) {
            if("admin".equalsIgnoreCase(rol.getNombre())){
                dto.setAdmin(true);
            }
        }
    }

}
