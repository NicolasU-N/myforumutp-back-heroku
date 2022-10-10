package co.edu.utp.misiontic2022.myforumutp.mapper;

import co.edu.utp.misiontic2022.myforumutp.dto.VotoDto;
import co.edu.utp.misiontic2022.myforumutp.model.Voto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VotoMapper {

    @Named("NoPublicacionVotos")
    @Mappings({
//            @Mapping(target = "votos.publicacion", ignore = true),
            @Mapping(target = "publicacion.votos", ignore = true),
    })
    VotoDto toDto(Voto voto);

    @Named("NoVotos")
    @IterableMapping(qualifiedByName = "NoPublicacionVotos")
    List<VotoDto> toDtoList(List<Voto> votos);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(VotoDto votoDto, @MappingTarget Voto voto);

    Voto toEntity(VotoDto votoDto);
}
