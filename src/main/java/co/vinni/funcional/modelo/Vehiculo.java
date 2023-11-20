package co.vinni.funcional.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VEHICULO_SEQ")
    @SequenceGenerator(sequenceName = "sq_vehiculos", allocationSize = 1, name = "VEHICULO_SEQ")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="propietario_id", nullable=false)
    @JsonIgnore
    private Propietario propietario;

    @OneToMany(mappedBy="vehiculo")
    private Set<SeguroTodoRiesgo> segurosTodoRiesgo = new HashSet<>();

    public void addSeguroTodoRiesgo(SeguroTodoRiesgo seguroTodoRiesgo){
        segurosTodoRiesgo.add(seguroTodoRiesgo);
        seguroTodoRiesgo.setVehiculo(this);
    }

    public void removeSeguroTodoRiesgo(SeguroTodoRiesgo seguroTodoRiesgo){
        segurosTodoRiesgo.remove(seguroTodoRiesgo);
        seguroTodoRiesgo.setVehiculo(null);
    }
}
