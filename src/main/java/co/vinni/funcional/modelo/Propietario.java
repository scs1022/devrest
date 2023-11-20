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
public class Propietario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROPIETARIO_SEQ")
    @SequenceGenerator(sequenceName = "sq_propietarios", allocationSize = 1, name = "PROPIETARIO_SEQ")
    private long id;
    private String nombres;
    private String apellidos;
    private long numdocumento;

    @OneToMany(mappedBy = "propietario")
    private Set<Vehiculo> vehiculos = new HashSet<>();

    public void addVehiculo(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
        vehiculo.setPropietario(this);
    }

    public void removeVehiculo(Vehiculo vehiculo){
        vehiculos.remove(vehiculo);
        vehiculo.setPropietario(null);
    }
}
