package co.edu.utp.misiontic2022.myforumutp.service;

import co.edu.utp.misiontic2022.myforumutp.dto.UsuarioDto;

import java.util.List;

public interface UsuarioService {

    UsuarioDto getUsuarioById(Long id);

    UsuarioDto getUsuarioByCorreo(String correo);

    List<UsuarioDto> getAllUsuarios();

    void saveUsuario(UsuarioDto usuarioDto);

    void updateUsuario(Long id, UsuarioDto usuarioDto);

    void deleteUsuarioById(Long id);

}
