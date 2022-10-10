package co.edu.utp.misiontic2022.myforumutp.dto;

import co.edu.utp.misiontic2022.myforumutp.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicacionDto {

    private Long id;

    private String asunto;

    private String contenido;

//    private Publicacion publicacion;

    private Set<PublicacionDto> comentarios; //= new HashSet<>()

    private UsuarioLightDto usuario;

//    private Set<VotoDto> votos;

    private Long likes;

    private Long dislikes;

    private Date createdAt;

    private Long createdBy;

}
