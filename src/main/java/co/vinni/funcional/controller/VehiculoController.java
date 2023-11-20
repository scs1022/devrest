package co.vinni.funcional.controller;

import co.vinni.funcional.modelo.Vehiculo;
import co.vinni.funcional.servicios.VehiculoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehiculo")
public class VehiculoController {
    @Autowired
    private final VehiculoServicio vehiculoServicio;
    @GetMapping
    public ResponseEntity<List<Vehiculo>> obtenerVehiculos() {
        var vehiculos = vehiculoServicio.buscarTodos();
        return new ResponseEntity<>(vehiculos, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> obtenerVehiculoXId(@PathVariable Long id) {
        var vehiculo = vehiculoServicio.buscarXId(id);
        return new ResponseEntity<>(vehiculo, HttpStatus.OK);
    }
}
