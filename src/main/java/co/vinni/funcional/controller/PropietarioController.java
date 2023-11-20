package co.vinni.funcional.controller;

import co.vinni.funcional.modelo.Propietario;
import co.vinni.funcional.servicios.PropietarioServicio;
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
@RequestMapping("/propietario")
public class PropietarioController {
    @Autowired
    private final PropietarioServicio propietarioServicio;

    @GetMapping
    public ResponseEntity<List<Propietario>> obtenerPropietarios() {
        var propietarios = propietarioServicio.buscarTodos();
        return new ResponseEntity<>(propietarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Propietario> obtenerPropietarioXId(@PathVariable Long id) {
        var propietario = propietarioServicio.buscarXId(id);
        return new ResponseEntity<>(propietario, HttpStatus.OK);
    }
}
