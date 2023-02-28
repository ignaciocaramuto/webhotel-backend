package com.tp.webhotel.controller;

import com.tp.webhotel.model.Cliente;
import com.tp.webhotel.model.Habitacion;
import com.tp.webhotel.service.HabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(path = "api/habitaciones")
public class HabitacionController {
    private final HabitacionService habitacionService;

    @Autowired
    public HabitacionController(HabitacionService habitacionService) {
        this.habitacionService = habitacionService;
    }

    @GetMapping
    public List<Habitacion> getHabitaciones() {
        return habitacionService.getHabitaciones();
    }

    @PostMapping
    public void registrarNuevaHabitacion(@RequestBody Habitacion habitacion) {
        habitacionService.agregarNuevaHabitacion(habitacion);
    }

    @PutMapping(path = "{habitacionId}")
    public void actualizarHabitacion(
            @PathVariable("habitacionId") int id,
            @RequestParam() int idTipoHabitacion) {
        habitacionService.actualizarHabitacion(id, idTipoHabitacion);
    }

    @DeleteMapping(path = "{habitacionId}")
    public void eliminarHabitacion(@PathVariable("habitacionId") int id){
        habitacionService.eliminarHabitacion(id);
    }
}
