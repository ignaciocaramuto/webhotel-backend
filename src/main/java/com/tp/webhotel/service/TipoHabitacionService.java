package com.tp.webhotel.service;

import com.tp.webhotel.model.Cliente;
import com.tp.webhotel.model.TipoHabitacion;
import com.tp.webhotel.repository.TipoHabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TipoHabitacionService {

    private final TipoHabitacionRepository tipoHabitacionRepository;

    @Autowired
    public TipoHabitacionService(TipoHabitacionRepository tipoHabitacionRepository) {
        this.tipoHabitacionRepository = tipoHabitacionRepository;
    }

    public List<TipoHabitacion> getTipoHabitaciones() {
        return tipoHabitacionRepository.findAll();
    }

    public void agregarNuevoTipoHabitacion(TipoHabitacion tipoHabitacion) {
        boolean existe = tipoHabitacionRepository.existsById(tipoHabitacion.getIdTipoHabitacion());
        if (existe) {
            throw new IllegalStateException("El tipo de habitación ya fue registrado anteriormente");
        }
        tipoHabitacionRepository.save(tipoHabitacion);
    }

    @Transactional
    public void actualizarTipoHabitacion(
            int id,
            String denominacion,
            String descripcion,
            int capacidadPersonas,
            float precioPorDia) {
        TipoHabitacion tipoHabitacion = tipoHabitacionRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("El tipo de habitación con id " + id + "no existe"));
        if (denominacion != null && denominacion.length() > 0 &&
                !Objects.equals(tipoHabitacion.getDenominacion(), denominacion)) {
            tipoHabitacion.setDenominacion(denominacion);
        }
        if (descripcion != null && descripcion.length() > 0 &&
                !Objects.equals(tipoHabitacion.getDescripcion(), descripcion)) {
            tipoHabitacion.setDescripcion(descripcion);
        }
        if (capacidadPersonas > 0 && !Objects.equals(tipoHabitacion.getCapacidadPersonas(), capacidadPersonas)) {
            tipoHabitacion.setCapacidadPersonas(capacidadPersonas);
        }
        if (precioPorDia > 0 && !Objects.equals(tipoHabitacion.getPrecioPorDia(), precioPorDia)) {
            tipoHabitacion.setPrecioPorDia(precioPorDia);
        }
    }

    public void eliminarTipoHabitacion(int id) {
        boolean existe = tipoHabitacionRepository.existsById(id);
        if (!existe) {
            throw new IllegalStateException("El tipo de habitación con id " + id + " no existe");
        }
        tipoHabitacionRepository.deleteById(id);
    }
}
