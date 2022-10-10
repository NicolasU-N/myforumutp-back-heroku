package co.edu.utp.misiontic2022.myforumutp.config.security.jwt.controller;

import co.edu.utp.misiontic2022.myforumutp.config.security.jwt.JwtProvider;
import co.edu.utp.misiontic2022.myforumutp.config.security.jwt.dto.JwtDto;
import co.edu.utp.misiontic2022.myforumutp.config.security.jwt.dto.LoginRequestDto;
import co.edu.utp.misiontic2022.myforumutp.config.security.jwt.service.MyUserDetailsService;
import co.edu.utp.misiontic2022.myforumutp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private UsuarioRepository userRepository;

    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequestDto loginRequestDto) throws Exception {
        Map<String, Object> response = new HashMap<>();
        HttpStatus httpStatus = null;
        String message = null;

        String jwt = null;

        try {
            UsernamePasswordAuthenticationToken userToken = new UsernamePasswordAuthenticationToken(
                    loginRequestDto.getEmail(),
                    loginRequestDto.getPassword()
            );

            Authentication authentication =  this.authenticationManager.authenticate(userToken);

            jwt = jwtProvider.generateToken(authentication);
            httpStatus = HttpStatus.OK;
            message = "You're welcome" ;
        } catch (BadCredentialsException e) {
            httpStatus = HttpStatus.UNAUTHORIZED;
            message = "Bad credentials";
            throw new Exception("ERROR: Bad credentials!");
        }

        response.put("status", httpStatus);
        response.put("code", httpStatus.value());
        response.put("message", message);
        response.put("token", jwt);
//        userRepository.findByCorreo()
        response.put("username", jwtProvider.username(jwt));

        return new ResponseEntity<>(response, httpStatus);
    }
}
