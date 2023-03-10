package com.tp.webhotel.controller;

import com.tp.webhotel.model.Cliente;
import com.tp.webhotel.model.Habitacion;
import com.tp.webhotel.service.HabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

//@CrossOrigin(origins = {"http://localhost:8080"}) Esto se utiliza para permitir las peticiones de ciertos origenes unicamente, cuando tengamos el front lo descomentamos
@RestController
@RequestMapping(path = "api/habitaciones")
public class HabitacionController {
    private final HabitacionService habitacionService;

    @Autowired
    public HabitacionController(HabitacionService habitacionService) {
        this.habitacionService = habitacionService;
    }

    @GetMapping(path = "/all")
    public List<Habitacion> getHabitaciones() {
        return habitacionService.getHabitaciones();
    }

    @PostMapping(path="/register")
    public void registrarNuevaHabitacion(@RequestBody Habitacion habitacion) {
        habitacionService.agregarNuevaHabitacion(habitacion);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Habitacion> actualizarHabitacion(@RequestBody Habitacion habitacion) {
        Habitacion updateHabitacion = habitacionService.actualizarHabitacion(habitacion);
        return new ResponseEntity<>(updateHabitacion, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{habitacionId}")
    public void eliminarHabitacion(@PathVariable("habitacionId") int id){
        habitacionService.eliminarHabitacion(id);
    }
}
