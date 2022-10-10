package co.edu.utp.misiontic2022.myforumutp.mapper;

import co.edu.utp.misiontic2022.myforumutp.dto.RolDto;
import co.edu.utp.misiontic2022.myforumutp.model.Rol;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UsuarioMapper.class})
public interface RolMapper {

    @Named("Rol")
//    @Mapping(target = "nombre", source = "role.code")
    RolDto toDto(Rol rol);

    @Named("toListDTONoRol")
    @IterableMapping(qualifiedByName = "Rol")
    List<RolDto> toDtoList(List<Rol> roles);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(RolDto rolDto, @MappingTarget Rol rol);

    Rol toEntity(RolDto rolDto);

}
