package co.edu.utp.misiontic2022.myforumutp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioLightDto {

    private boolean isAdmin;

    private String username;

    private String correo;

    private Date createdAt;

}
