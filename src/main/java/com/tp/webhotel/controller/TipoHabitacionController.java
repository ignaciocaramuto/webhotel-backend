package com.tp.webhotel.controller;

import com.tp.webhotel.model.TipoHabitacion;
import com.tp.webhotel.service.TipoHabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

//@CrossOrigin(origins = {"http://localhost:8080"}) Esto se utiliza para permitir las peticiones de ciertos origenes unicamente, cuando tengamos el front lo descomentamos
@RestController
@RequestMapping(path = "api/tipohabitaciones")
public class TipoHabitacionController {

    private final TipoHabitacionService tipoHabitacionService;

    @Autowired
    public TipoHabitacionController(TipoHabitacionService tipoHabitacionService) {
        this.tipoHabitacionService = tipoHabitacionService;
    }

    @GetMapping(path="/all")
    public List<TipoHabitacion> getTipoHabitaciones() {
        return tipoHabitacionService.getTipoHabitaciones();
    }

    @PostMapping(path = "/register")
    public void registrarNuevoTipoHabitacion(@RequestBody TipoHabitacion tipoHabitacion){
        tipoHabitacionService.agregarNuevoTipoHabitacion(tipoHabitacion);
    }

    @PutMapping(path = "/{tipoHabitacionId}")
    public void actualizarTipoHabitacion(
            @PathVariable("tipoHabitacionId") int id,
            @RequestParam(required = false) String denominacion,
            @RequestParam(required = false) String descripcion,
            @RequestParam(required = false) int capacidadPersonas,
            @RequestParam(required = false) float precioPorDia) {
        tipoHabitacionService.actualizarTipoHabitacion(id, denominacion, descripcion, capacidadPersonas, precioPorDia);
    }
    @DeleteMapping(path = "/{tipoHabitacionId}")
    public void eliminarCliente(@PathVariable("tipoHabitacionId") int id){
        tipoHabitacionService.eliminarTipoHabitacion(id);
    }
}
