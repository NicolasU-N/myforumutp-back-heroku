package co.edu.utp.misiontic2022.myforumutp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SavePublicacionDto {

    private String asunto;

    private String contenido;

    private String user_email;

}