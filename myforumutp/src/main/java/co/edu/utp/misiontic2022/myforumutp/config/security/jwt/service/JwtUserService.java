package co.edu.utp.misiontic2022.myforumutp.config.security.jwt.service;

import co.edu.utp.misiontic2022.myforumutp.exception.NotFoundException;
import co.edu.utp.misiontic2022.myforumutp.model.Usuario;
import co.edu.utp.misiontic2022.myforumutp.repository.UsuarioRepository;
import co.edu.utp.misiontic2022.myforumutp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class JwtUserService {

    //D.I
    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private MessageUtil messageUtil;

    public List<Usuario> findAll() {
        return this.repository.findAll();
    }

    /*
     * https://www.baeldung.com/spring-data-derived-queries
     **/
    public Usuario findByEmail(String email) {
        return this.repository.findByCorreo(email).orElseThrow(() -> new NotFoundException(messageUtil.getMessage("usuarioNotFound", null, Locale.getDefault())));
    }

    public void save(Usuario user) {
        this.repository.save(user);
    }

}
