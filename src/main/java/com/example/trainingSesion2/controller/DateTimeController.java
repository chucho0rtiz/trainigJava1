package com.example.trainingSesion2.controller;

import com.example.trainingSesion2.configuration.UniTime;
import com.example.trainingSesion2.time.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
@RequestMapping("/api/v1/date")
public class DateTimeController {
    UniTime uniTime;
    public DateTimeController(UniTime uniTime) {
        this.uniTime = uniTime;
    }

    @GetMapping("/time")
    private HoraDia time(){
        LocalTime time = LocalTime.now();
        Hora hora = Hora.of(time.getHour());
        Minuto minuto = Minuto.of(time.getMinute());
        Segundo segundo = Segundo.of(time.getSecond());
        //UnidadTiempo unidadTiempo = UnidadTiempo.of("Horas");
        Long mediaNoche = UnidadTiempo.time(UnidadTiempo.valueOf(uniTime.getTiempo()), time);
        return HoraDia.from( hora, minuto, segundo , mediaNoche);
    }
}
