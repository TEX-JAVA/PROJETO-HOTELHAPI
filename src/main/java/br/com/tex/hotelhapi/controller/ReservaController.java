//package br.com.tex.hotelhapi.controller;
//
//import br.com.tex.hotelhapi.repository.ReservaRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/reservas")
//public class ReservaController {
//    @Autowired
//    private ReservaRepository reservaRepository;
//
//    @GetMapping
//    public ResponseEntity lista(){
//        List<ReservaOutputDto> reservas = this.reservaRepository.findAll();
//        if(reservas==null)
//            return ResponseEntity.noContent().build();
//    }
//}
