package br.com.tex.hotelhapi.controller;

import br.com.tex.hotelhapi.model.Hotel;
import br.com.tex.hotelhapi.model.dto.HotelInputDto;
import br.com.tex.hotelhapi.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hoteis")
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping
    public List<Hotel> lista(){
        return hotelRepository.findAll();
    }

//    @PostMapping
//    public void cadastra(@RequestBody HotelInputDto hotel){
//        System.out.printf(hotel);
//    }
}
