package co.edu.utp.misiontic2022.myforumutp.controller;


import co.edu.utp.misiontic2022.myforumutp.dto.PublicacionDto;
import co.edu.utp.misiontic2022.myforumutp.dto.SavePublicacionDto;
import co.edu.utp.misiontic2022.myforumutp.service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api/publicacion")
@RestController
@CrossOrigin(origins = "*")
public class PublicacionController {

    private final Map<String, Object> response = new HashMap<>();

    @Autowired
    private PublicacionService publicacionService;

    @GetMapping("/all")
    private ResponseEntity<?> findAllPublicaciones() {
        response.clear();
        response.put("publicaciones", publicacionService.getAllPublicaciones());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> findById(@PathVariable Long id) {
        response.clear();
        response.put("publicacion", publicacionService.getPublicacionById(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/asunto")
    private ResponseEntity<?> findByAsunto(@RequestParam(required = true) String asunto) {
        response.clear();
        response.put("publicaciones", publicacionService.getPublicacionesByAsunto(asunto));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/new")
    private ResponseEntity<?> savePublicacion(@Valid @RequestBody SavePublicacionDto savePublicacionDto) {
        //response.clear();
        publicacionService.savePublicacion(savePublicacionDto);
        response.put("message", "Save Publicacion successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> updatePublicacion(@PathVariable Long id, @RequestBody PublicacionDto publicacionDto) {
        response.clear();
        publicacionService.updatePublicacion(id, publicacionDto);
        response.put("message", "Publicacion updated successfully");
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deletePublicacionById(@PathVariable Long id) {
        response.clear();
        publicacionService.deletePublicacionById(id);
        response.put("message", "Publicacion deleted Successfully");
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

}
