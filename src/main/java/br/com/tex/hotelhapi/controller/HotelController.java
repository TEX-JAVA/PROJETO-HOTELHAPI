package br.com.tex.hotelhapi.controller;

import br.com.tex.hotelhapi.model.Hotel;
import br.com.tex.hotelhapi.model.dto.QuartosPorHotelOutputDto;
import br.com.tex.hotelhapi.model.dto.ServicosPorHotelOutputDto;
import br.com.tex.hotelhapi.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/hoteis")
public class HotelController {
    @Autowired
    HotelRepository hotelRepository;
    @GetMapping("/{id}/servicos")
    public ResponseEntity buscaServicosPorHotel(@PathVariable int id){
        Hotel hotel = this.hotelRepository.getReferenceById(id);
        ServicosPorHotelOutputDto dto = new ServicosPorHotelOutputDto(hotel);

        return ResponseEntity.ok(dto);
    }
    @GetMapping("/{id}/quartos")
    public ResponseEntity buscaQuartosPorHotel(@PathVariable int id){
        Hotel hotel = this.hotelRepository.getReferenceById(id);
        QuartosPorHotelOutputDto dto = new QuartosPorHotelOutputDto(hotel);

        return ResponseEntity.ok(dto);
    }
}
