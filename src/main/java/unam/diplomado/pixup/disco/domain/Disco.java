package unam.diplomado.pixup.disco.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "disco")
public class Disco implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private double precio;
    private int existencia;
    private double descuento;
    private Date fechaLanzamiento;
    private String imagen;
    @ManyToOne(targetEntity = Disquera.class)
    @JoinColumn(name = "id_disquera", nullable = false)
    private Disquera disquera;
    @ManyToOne(targetEntity = Artista.class)
    @JoinColumn(name = "id_artista", nullable = false)
    private Artista artista;
    @ManyToOne(targetEntity = GeneroMusical.class)
    @JoinColumn(name = "id_genero_musical", nullable = false)
    private GeneroMusical generoMusical;
}
