package co.vinni.funcional.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FUNCIO_SEQ")
    @SequenceGenerator(sequenceName = "sq_vehiculos", allocationSize = 1, name = "FUNCIO_SEQ")
    private long id;

    private String placa;
    private int modelo;

    @OneToMany(mappedBy="vehiculo")
    private Set<Soat> soats;


    public void addSoat(Soat soat) {
        soats.add(soat);
        soat.setVehiculo (this);
    }
    public void removeSoat(Soat soat) {
        soats.remove(soat);
        soat.setVehiculo(null);
    }
}
