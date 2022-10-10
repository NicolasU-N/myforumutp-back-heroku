package co.edu.utp.misiontic2022.myforumutp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {

    private Long id;

    private String username;

    private String password;

    private String correo;

    private String celular;

    private Set<PublicacionDto> publicaciones;

    private Set<RolDto> roles;

    private Date createdAt;

}
