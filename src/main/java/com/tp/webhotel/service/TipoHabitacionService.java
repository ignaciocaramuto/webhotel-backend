package com.tp.webhotel.service;

import com.tp.webhotel.dtos.TipoHabitacionDto;
import com.tp.webhotel.exceptions.NotFoundException;
import javax.persistence.EntityNotFoundException;
import com.tp.webhotel.model.TipoHabitacion;
import com.tp.webhotel.repository.TipoHabitacionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TipoHabitacionService {

    private TipoHabitacionRepository tipoHabitacionRepository;


    public List<TipoHabitacion> getAll() {
        return tipoHabitacionRepository.findAll();
    }

    public TipoHabitacion getById(int id){
        return tipoHabitacionRepository.findById(id).orElseThrow(EntityNotFoundException::new);

    }


    public TipoHabitacion create(TipoHabitacionDto tipoHabitacionDto) {
       return tipoHabitacionRepository.save(tipoHabitacionDto.toTipoHabitacion());
    }

    @Transactional
    public TipoHabitacion update(int id,TipoHabitacionDto tipoHabitacionDto) {
        TipoHabitacion tipoHabitacionUpdate = tipoHabitacionRepository.getById(id);
        tipoHabitacionUpdate.setDescripcion(tipoHabitacionDto.descripcion);
        tipoHabitacionUpdate.setDenominacion(tipoHabitacionDto.denominacion);
        tipoHabitacionUpdate.setCapacidadPersonas(tipoHabitacionDto.cantidadPersonas);
        tipoHabitacionUpdate.setPrecioPorDia(tipoHabitacionDto.precioPorDia);

        return tipoHabitacionRepository.save(tipoHabitacionUpdate);


    }


    public void delete(int id) {
        tipoHabitacionRepository.deleteById(id);
    }
}
