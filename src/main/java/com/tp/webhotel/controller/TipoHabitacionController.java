package com.tp.webhotel.controller;

import com.tp.webhotel.dtos.TipoHabitacionDto;
import com.tp.webhotel.model.TipoHabitacion;
import com.tp.webhotel.service.TipoHabitacionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.List;

//@CrossOrigin(origins = {"http://localhost:8080"}) Esto se utiliza para permitir las peticiones de ciertos origenes unicamente, cuando tengamos el front lo descomentamos
@RestController
@RequestMapping(path = "/api/tipohabitaciones")
@AllArgsConstructor
@Validated
public class TipoHabitacionController {

    private final TipoHabitacionService tipoHabitacionService;

    @GetMapping
    public List<TipoHabitacion> getAll() {
        return tipoHabitacionService.getAll();
    }

    @GetMapping("/{id}")
    public TipoHabitacion getById(@PathVariable("id") int id){ return tipoHabitacionService.getById(id);}

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody @Valid TipoHabitacionDto tipoHabitacionDto){
        tipoHabitacionService.create(tipoHabitacionDto);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TipoHabitacion update(@PathVariable("id") int id,@RequestBody @Valid TipoHabitacionDto tipoHabitacionDto) {
        return tipoHabitacionService.update(id, tipoHabitacionDto);
    }
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id){
        tipoHabitacionService.delete(id);
    }
}
