package co.vinni.funcional.servicios;

import co.vinni.funcional.modelo.Propietario;
import co.vinni.funcional.repositorio.PropietarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PropietarioServicio {
    @Autowired
    private final PropietarioRepositorio propietarioRepositorio;

    public Propietario buscarXId(Long id) {
        return propietarioRepositorio.findById(id).orElseThrow();
    }

    public List<Propietario> buscarTodos() {
        return propietarioRepositorio.findAll();
    }
}
