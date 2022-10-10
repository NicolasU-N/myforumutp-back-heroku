package co.edu.utp.misiontic2022.myforumutp.service.impl;

import co.edu.utp.misiontic2022.myforumutp.dto.RolDto;
import co.edu.utp.misiontic2022.myforumutp.exception.NotFoundException;
import co.edu.utp.misiontic2022.myforumutp.mapper.RolMapper;
import co.edu.utp.misiontic2022.myforumutp.model.Rol;
import co.edu.utp.misiontic2022.myforumutp.repository.RolRepository;
import co.edu.utp.misiontic2022.myforumutp.service.RolService;
import co.edu.utp.misiontic2022.myforumutp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Locale;

public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private RolMapper rolMapper;

    @Autowired
    private MessageUtil messageUtil;

    @Override
    public RolDto getRolById(Long id) {
        return rolMapper.toDto(rolRepository.findById(id).orElseThrow(() -> new NotFoundException(messageUtil.getMessage("Rol not found", null, Locale.getDefault()))));
    }

    @Override
    public List<Rol> getAllRol() {
        return rolRepository.findAll();
    }

    @Transactional
    @Override
    public void saveRol(RolDto usuarioDto) {
        Rol person = rolMapper.toEntity(usuarioDto);
        rolRepository.save(person);
    }

    @Transactional
    @Override
    public void updateRol(Long id, RolDto usuarioDto) {
        Rol person1 = rolRepository.findById(id).orElseThrow(() -> new NotFoundException(messageUtil.getMessage("notFound", null, Locale.getDefault())));
        rolMapper.updateEntity(usuarioDto, person1);
        rolRepository.save(person1);
    }

    @Override
    public void deleteRolById(Long id) {
        Rol person1 = rolRepository.findById(id).orElseThrow(() -> new NotFoundException(messageUtil.getMessage("notFound", null, Locale.getDefault())));
        rolRepository.deleteById(id);
    }
}
