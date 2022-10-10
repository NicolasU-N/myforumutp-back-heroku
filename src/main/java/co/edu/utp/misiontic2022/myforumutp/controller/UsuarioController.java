package co.edu.utp.misiontic2022.myforumutp.controller;


import co.edu.utp.misiontic2022.myforumutp.dto.UsuarioDto;
import co.edu.utp.misiontic2022.myforumutp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final Map<String, Object> response = new HashMap<>();

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/all")
    private ResponseEntity<?> findAllUsuarios() {
        response.clear();
        response.put("usuarios", usuarioService.getAllUsuarios());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getUsuarioById(@PathVariable Long id) {
        response.clear();
        response.put("usuario", usuarioService.getUsuarioById(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/correo")
    private ResponseEntity<?> getUsuarioByCorreo(@RequestParam(required = true) String correo) {
        response.clear();
        response.put("usuario", usuarioService.getUsuarioByCorreo(correo));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/new")
    private ResponseEntity<?> saveUsuario(@Valid @RequestBody UsuarioDto usuarioDto) {
        response.clear();
        usuarioService.saveUsuario(usuarioDto);
        response.put("message", "Usuario creado exitosamente");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> updateUsuario(@PathVariable Long id, @RequestBody UsuarioDto usuarioDto) {
        response.clear();
        usuarioService.updateUsuario(id, usuarioDto);
        response.put("message", "Usuario updated successfully");
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteUsuarioById(@PathVariable Long id) {
        response.clear();
        usuarioService.deleteUsuarioById(id);
        response.put("message", "Usuario deleted Successfully");
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

}
