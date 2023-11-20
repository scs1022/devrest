package co.vinni.funcional.repositorios;

import co.vinni.funcional.modelo.Soat;
import co.vinni.funcional.modelo.Vehiculo;
import co.vinni.funcional.repositorio.VehiculoRepositorio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class VehiculoRepositorioTest {
    @Autowired
    private VehiculoRepositorio vehiculoRepositorio;
    @Test
    public void adicionar() {

        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setModelo(2019);
        vehiculo.setPlaca("RWW232");
        Set<Soat> itemsSet = new HashSet<>();
        vehiculo.setSoats(itemsSet);
        var soat = new Soat();
        vehiculo.addSoat (soat);

        vehiculoRepositorio.save(vehiculo);

    }
    @Test
    void consultarTodos(){
        List<Vehiculo> vehiculoList = vehiculoRepositorio.findAll ();
        for (Vehiculo vehiculo:vehiculoList) {
            System.out.println(vehiculo);
            for (Soat soat:vehiculo.getSoats()) {
                System.out.println("Soat"+soat);
            }
        }

    }
}
