package co.vinni.funcional.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeguroTodoRiesgo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEGUROTODORIESGO_SEQ")
    @SequenceGenerator(sequenceName = "sq_segurotodoriesgo", allocationSize = 1, name = "SEGUROTODORIESGO_SEQ")
    private long id;
    private Date vencimiento;
    private boolean vigente;
    private long valor;
    private int vigencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="vehiculo_id", nullable=false)
    @JsonIgnore
    private Vehiculo vehiculo;
}
