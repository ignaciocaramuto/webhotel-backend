package com.tp.webhotel.service;

import com.tp.webhotel.model.Habitacion;
import com.tp.webhotel.repository.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class HabitacionService {

    private final HabitacionRepository habitacionRepository;

    @Autowired
    public HabitacionService(HabitacionRepository habitacionRepository) {
        this.habitacionRepository = habitacionRepository;
    }

    public List<Habitacion> getHabitaciones() {
        return habitacionRepository.findAll();
    }

    public void agregarNuevaHabitacion(Habitacion habitacion) {
        // TODO: analizar si es necesaria la validación ya que el id es autoincremental
        Optional<Habitacion> existeHabitacion = habitacionRepository.findById(habitacion.getNroHabitacion());
        if (existeHabitacion.isPresent()) {
            throw new IllegalStateException("La habitación ya ha sido registrada anteriormente");
        }
        habitacionRepository.save(habitacion);
    }

    @Transactional
    public void actualizarHabitacion(int id, int idTipoHabitacion) {
        Habitacion habitacion = habitacionRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("La habitación con id " + id + " no existe"));
        // TODO: agregar validación de existencia de idTipoHabitacion
        habitacion.setIdTipoHabitacion(idTipoHabitacion);
    }

    public void eliminarHabitacion(int id) {
        boolean existe = habitacionRepository.existsById(id);
        if (!existe) {
            throw new IllegalStateException("La habitación con id " + id + " no existe");
        }
        habitacionRepository.deleteById(id);
    }
}
