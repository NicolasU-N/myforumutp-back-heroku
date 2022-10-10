package co.edu.utp.misiontic2022.myforumutp.mapper;

import co.edu.utp.misiontic2022.myforumutp.dto.UsuarioDto;
import co.edu.utp.misiontic2022.myforumutp.model.Usuario;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RolMapper.class, PublicacionMapper.class})
public interface UsuarioMapper {

    @Named("NoUsuario")
    @Mappings({
            @Mapping(target = "publicaciones", qualifiedByName = "NoUsuarioPublicacion"),
            @Mapping(target = "roles", qualifiedByName = "Rol"),
            @Mapping(target = "password", ignore = true)
    })
    UsuarioDto toDto(Usuario person);


    @Named("toListDTONoUsuario") //toListDTONoUsuario
    @IterableMapping(qualifiedByName = "NoUsuario")
    List<UsuarioDto> toDtoList(List<Usuario> usuarios);

//    default List<UsuarioDto> toDtoList(List<Usuario> userList) {
//        if (userList == null) {
//            return new ArrayList<>();
//        }
//        return userList.stream().map(this::toDto).collect(Collectors.toList());
//    }

    Usuario toEntity(UsuarioDto personDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(UsuarioDto personDto, @MappingTarget Usuario person);

}
