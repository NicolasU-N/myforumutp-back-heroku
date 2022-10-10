package co.edu.utp.misiontic2022.myforumutp.service.impl;

import co.edu.utp.misiontic2022.myforumutp.dto.UsuarioDto;
import co.edu.utp.misiontic2022.myforumutp.exception.NotFoundException;
import co.edu.utp.misiontic2022.myforumutp.mapper.UsuarioMapper;
import co.edu.utp.misiontic2022.myforumutp.model.Usuario;
import co.edu.utp.misiontic2022.myforumutp.repository.UsuarioRepository;
import co.edu.utp.misiontic2022.myforumutp.service.UsuarioService;
import co.edu.utp.misiontic2022.myforumutp.util.MessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Locale;


@Service
public class UsuarioServiceImpl implements UsuarioService {

    private static final Logger LOG = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    private MessageUtil messageUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UsuarioDto getUsuarioById(Long id) {
        LOG.info("GET / usuario ID");
        return usuarioMapper.toDto(usuarioRepository.findById(id).orElseThrow(() -> new NotFoundException(messageUtil.getMessage("usuarioNotFound", null, Locale.getDefault()))));
//        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public UsuarioDto getUsuarioByCorreo(String correo) {
        LOG.info("GET / usuario correo");
        return usuarioMapper.toDto(usuarioRepository.findByCorreo(correo).orElseThrow(() -> new NotFoundException(messageUtil.getMessage("usuarioNotFound", null, Locale.getDefault()))));
//        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public List<UsuarioDto> getAllUsuarios() {
        LOG.info("GET / all-usuarios");
        //List<Usuario> myusers = usuarioRepository.findAll();
        //List<UsuarioDto> myusersDTO = usuarioMapper.toDtoList(usuarioRepository.findAll());
        return usuarioMapper.toDtoList(usuarioRepository.findAll());
    }

    @Transactional
    @Override
    public void saveUsuario(UsuarioDto usuarioDto) {
        usuarioDto.setPassword(passwordEncoder.encode(usuarioDto.getPassword()));
        Usuario person = usuarioMapper.toEntity(usuarioDto);
        usuarioRepository.save(person);
    }

    @Transactional
    @Override
    public void updateUsuario(Long id, UsuarioDto usuarioDto) {
        Usuario person1 = usuarioRepository.findById(id).orElseThrow(() -> new NotFoundException(messageUtil.getMessage("usuarioNotFound", null, Locale.getDefault())));
        usuarioMapper.updateEntity(usuarioDto, person1);
        usuarioRepository.save(person1);
    }

    @Override
    public void deleteUsuarioById(Long id) {
        Usuario person1 = usuarioRepository.findById(id).orElseThrow(() -> new NotFoundException(messageUtil.getMessage("usuarioNotFound", null, Locale.getDefault())));
        usuarioRepository.deleteById(id);
    }
}
