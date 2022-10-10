package co.edu.utp.misiontic2022.myforumutp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String asunto;

    @Column(columnDefinition = "TEXT")
    private String contenido;

    @OneToOne
    @JoinColumn(name = "parent_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Publicacion publicacion;

    //, orphanRemoval = true
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "publicacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Publicacion> comentarios = new HashSet<>();

    // bi-directional many-to-one association to Usuario
    //@JsonIgnoreProperties({"publicacion"})
    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Usuario usuario;

    //bi-directional many-to-one association to votos //, orphanRemoval = true
    @OneToMany(mappedBy = "publicacion")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Voto> votos;

    @CreationTimestamp
    private Date createdAt;

    private Long createdBy;
}
