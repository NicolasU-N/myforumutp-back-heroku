package co.edu.utp.misiontic2022.myforumutp.mapper;

import co.edu.utp.misiontic2022.myforumutp.dto.PublicacionDto;
import co.edu.utp.misiontic2022.myforumutp.model.Publicacion;
import co.edu.utp.misiontic2022.myforumutp.model.Voto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UsuarioLightMapper.class})
public interface PublicacionMapper {

    @Named("NoUsuarioPublicacion")
    @Mappings({
//            @Mapping(target = "votos", qualifiedByName = "NoPublicacionVotos"),
//            @Mapping(target = "usuario", ignore = true),
//            @Mapping(target = "usuario.username", source = "usuario.username"),
            @Mapping(target = "usuario", qualifiedByName = "UsuarioLight"),
    })
    PublicacionDto toDto(Publicacion publicacion);

    @Named("toDtoListNoUsuario") //toListDTONoUsuario
    @IterableMapping(qualifiedByName = "NoUsuarioPublicacion")
    List<PublicacionDto> toDtoList(List<Publicacion> publicaciones);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(PublicacionDto publicacionDto, @MappingTarget Publicacion publicacion);

    Publicacion toEntity(PublicacionDto publicacionDto);

    @BeforeMapping
    default void defineLikesAndDislikes(Publicacion publicacion, @MappingTarget PublicacionDto dto) {
        Long likes = 0L;
        Long dislikes = 0L;
        for (Voto voto : publicacion.getVotos()) {
            likes = likes + voto.getLikes();
            dislikes = dislikes + voto.getDislikes();
        }
        dto.setLikes(likes);
        dto.setDislikes(dislikes);
    }

}
