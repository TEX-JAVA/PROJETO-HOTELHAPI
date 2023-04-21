package br.com.tex.hotelhapi.controller;

import br.com.tex.hotelhapi.model.*;
import br.com.tex.hotelhapi.model.dto.ReservaInputDto;
import br.com.tex.hotelhapi.model.dto.ReservaOutputDto;
import br.com.tex.hotelhapi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/reservas")
public class ReservaController {
    @Autowired
    private ReservaRepository reservaRepository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private QuartoRepository quartoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @GetMapping
    public ResponseEntity lista(){
        List<Reserva> reservas = this.reservaRepository.findAll();
        if(reservas.size() == 0)
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(reservas.stream()
                .map(reserva -> new ReservaOutputDto(reserva)).toList());
    }
    @GetMapping("/{id}")
    public ResponseEntity buscaPor(@PathVariable int id){
        Reserva reserva = this.reservaRepository.getReferenceById(id);

        return ResponseEntity.ok(new ReservaOutputDto(reserva));
    }
    @PostMapping
    public ResponseEntity cadastra(@RequestBody @Valid ReservaInputDto reservaDto, UriComponentsBuilder uriBuilder) {
        Hotel hotel = this.hotelRepository.getReferenceById(reservaDto.getIdHotel());
        Quarto quarto = this.quartoRepository.getReferenceById(reservaDto.getIdQuarto());
        Usuario usuario = this.usuarioRepository.getReferenceById(reservaDto.getIdUsuario());
        Reserva reservaSalva = reservaRepository.save(reservaDto.toReserva(hotel, usuario, quarto));

        return ResponseEntity
                .created(uriBuilder.path("reservas/{id}").buildAndExpand(reservaSalva.getId()).toUri())
                .body(new ReservaOutputDto(reservaSalva));
    }
    @PutMapping("/{id}")
    public ResponseEntity altera(@PathVariable int id, @RequestBody ReservaInputDto dto){
        this.reservaRepository.getReferenceById(id);
        Hotel hotel = this.hotelRepository.getReferenceById(dto.getIdHotel());
        Quarto quarto = this.quartoRepository.getReferenceById(dto.getIdQuarto());
        Usuario usuario = this.usuarioRepository.getReferenceById(dto.getIdUsuario());
        Reserva reserva = dto.toReserva(hotel,usuario,quarto);
        reserva.setId(id);
        Reserva alterada = this.reservaRepository.save(reserva);

        return ResponseEntity.ok(new ReservaOutputDto(reserva));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deletaPor(@PathVariable int id){
        Reserva reserva = this.reservaRepository.getReferenceById(id);
        this.reservaRepository.deleteById(reserva.getId());

        return ResponseEntity.ok().build();
    }
}
