package co.edu.utp.misiontic2022.myforumutp.service;

import co.edu.utp.misiontic2022.myforumutp.dto.PublicacionDto;
import co.edu.utp.misiontic2022.myforumutp.dto.SavePublicacionDto;

import java.util.List;

public interface PublicacionService {

    PublicacionDto getPublicacionById(Long id);

    List<PublicacionDto> getPublicacionesByAsunto(String asunto);

    List<PublicacionDto> getAllPublicaciones();

    void savePublicacion(SavePublicacionDto savePublicacionDto);

    void updatePublicacion(Long id, PublicacionDto publicacionDto);

    void deletePublicacionById(Long id);

}
