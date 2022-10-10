package co.edu.utp.misiontic2022.myforumutp.service.impl;

import co.edu.utp.misiontic2022.myforumutp.dto.PublicacionDto;
import co.edu.utp.misiontic2022.myforumutp.dto.SavePublicacionDto;
import co.edu.utp.misiontic2022.myforumutp.exception.NotFoundException;
import co.edu.utp.misiontic2022.myforumutp.mapper.PublicacionMapper;
import co.edu.utp.misiontic2022.myforumutp.model.Publicacion;
import co.edu.utp.misiontic2022.myforumutp.model.Usuario;
import co.edu.utp.misiontic2022.myforumutp.repository.PublicacionRepository;
import co.edu.utp.misiontic2022.myforumutp.repository.UsuarioRepository;
import co.edu.utp.misiontic2022.myforumutp.service.PublicacionService;
import co.edu.utp.misiontic2022.myforumutp.util.MessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class PublicacionServiceImpl implements PublicacionService {

    private static final Logger LOG = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PublicacionRepository publicacionRepository;

    @Autowired
    private PublicacionMapper publicacionMapper;

    @Autowired
    private MessageUtil messageUtil;

    @Override
    public PublicacionDto getPublicacionById(Long id) {
        LOG.info("GET / publicacion ID");
        return publicacionMapper.toDto(publicacionRepository.findById(id).orElseThrow(() -> new NotFoundException(messageUtil.getMessage("publicacionNotFound", null, Locale.getDefault()))));
    }

    @Override
    public List<PublicacionDto> getPublicacionesByAsunto(String asunto) {
        LOG.info("GET / publicaciones asunto");
        return publicacionMapper.toDtoList(publicacionRepository.findByAsuntoContains(asunto));
    }

    @Override
    public List<PublicacionDto> getAllPublicaciones() {
        LOG.info("GET / all-publicaciones");
        return publicacionMapper.toDtoList(publicacionRepository.findAll());
    }

    @Override
    public void savePublicacion(SavePublicacionDto savePublicacionDto) {
        Usuario myuser = usuarioRepository.findByCorreo(savePublicacionDto.getUser_email()).orElseThrow(() -> new NotFoundException(messageUtil.getMessage("usuarioNotFound", null, Locale.getDefault())));
        Publicacion publicacion = new Publicacion();
        publicacion.setUsuario(myuser);
        publicacion.setAsunto(savePublicacionDto.getAsunto());
        publicacion.setContenido(savePublicacionDto.getContenido());
        publicacion.setCreatedBy(myuser.getId());
//        PublicacionDto publicacionDto = new PublicacionDto();
//        Publicacion publicacion = publicacionMapper.toEntity(publicacionDto);
        publicacionRepository.save(publicacion);
    }

    @Override
    public void updatePublicacion(Long id, PublicacionDto publicacionDto) {
        Publicacion publicacion = publicacionRepository.findById(id).orElseThrow(() -> new NotFoundException(messageUtil.getMessage("publicacionNotFound", null, Locale.getDefault())));
        publicacionMapper.updateEntity(publicacionDto, publicacion);
        publicacionRepository.save(publicacion);
    }

    @Override
    public void deletePublicacionById(Long id) {
        Publicacion publicacion = publicacionRepository.findById(id).orElseThrow(() -> new NotFoundException(messageUtil.getMessage("publicacionNotFound", null, Locale.getDefault())));
        publicacionRepository.deleteById(id);
    }
}
