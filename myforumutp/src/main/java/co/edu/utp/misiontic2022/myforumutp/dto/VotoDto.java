package co.edu.utp.misiontic2022.myforumutp.dto;

import co.edu.utp.misiontic2022.myforumutp.model.Publicacion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VotoDto {

    private Long id;

    private Long likes;

    private Long dislikes;

    private Publicacion publicacion;

    private Date createdAt;

}
