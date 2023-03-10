package com.tp.webhotel.service;

import com.tp.webhotel.model.Habitacion;
import com.tp.webhotel.model.TipoHabitacion;
import com.tp.webhotel.repository.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class HabitacionService {

    private HabitacionRepository habitacionRepository;
    private TipoHabitacionService tipoHabitacionService;

    @Autowired
    public HabitacionService(HabitacionRepository habitacionRepository,TipoHabitacionService tipoHabitacionService) {
        this.habitacionRepository = habitacionRepository;
        this.tipoHabitacionService = tipoHabitacionService;
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
    public Habitacion actualizarHabitacion(Habitacion habitacion) {
        int idHabitacion = habitacion.getIdHabitacion();
        habitacionRepository.findById(idHabitacion)
                .orElseThrow(() -> new IllegalStateException("La habitación con id " + idHabitacion + " no existe"));

        int idTipoHabitacion = habitacion.getTipoHabitacion().getIdTipoHabitacion();
        System.out.print(idTipoHabitacion);
        TipoHabitacion tipoHabitacion = tipoHabitacionService.getById(idTipoHabitacion);
        habitacionRepository.save(habitacion);
        return habitacion;

    }

    public void eliminarHabitacion(int id) {
        boolean existe = habitacionRepository.existsById(id);
        if (!existe) {
            throw new IllegalStateException("La habitación con id " + id + " no existe");
        }
        habitacionRepository.deleteById(id);
    }
}
