package co.vinni.funcional.repositorio;

import co.vinni.funcional.modelo.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropietarioRepositorio extends JpaRepository<Propietario, Long> {
}
