package br.com.tex.hotelhapi.controller;

import br.com.tex.hotelhapi.model.ClasseUsuario;
import br.com.tex.hotelhapi.model.Usuario;
import br.com.tex.hotelhapi.model.dto.*;
import br.com.tex.hotelhapi.repository.ClasseUsuarioRepository;
import br.com.tex.hotelhapi.repository.UsuarioRepository;
import br.com.tex.hotelhapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import javax.validation.Valid;
import java.util.List;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ClasseUsuarioRepository classeUsuarioRepository;
    @GetMapping
    public ResponseEntity lista(){
        List<Usuario> usuarios = this.usuarioRepository.findAll();
        if(usuarios.size() == 0)
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(usuarios.stream()
                .map(usuario -> new UsuarioOutputDto(usuario)).toList());
    }
    @GetMapping("/{id}")
    public ResponseEntity buscaPor(@PathVariable int id){
        Usuario usuario = this.usuarioRepository.getReferenceById(id);

        return ResponseEntity.ok(new UsuarioOutputDto(usuario));
    }
    @PostMapping
    public ResponseEntity cadastra(@RequestBody @Valid UsuarioInputDto usuarioDto, UriComponentsBuilder uriBuilder){
        ClasseUsuario classeUsuario = this.classeUsuarioRepository.getReferenceById(usuarioDto.getClasseUsuarioId());
        Usuario usuario = usuarioDto.toUsuario(classeUsuario);

        if(this.usuarioService.emailExiste(usuario.getEmail()) != null){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST).body("E-mail já cadastrado");
        }

        Usuario salvo = this.usuarioRepository.save(usuario);

        return ResponseEntity
                .created(uriBuilder.path("/usuarios/{id}").buildAndExpand(salvo.getId()).toUri())
                .body(new UsuarioOutputDto(salvo));
    }
    @PutMapping("/{id}")
    public ResponseEntity altera(@PathVariable int id, @RequestBody UsuarioInputDto dto){
        this.usuarioRepository.getReferenceById(id);
        Usuario usuario = dto.toUsuario(this.classeUsuarioRepository.findById(dto.getClasseUsuarioId()).get());
        usuario.setId(id);
        Usuario alterado = this.usuarioRepository.save(usuario);

        return ResponseEntity.ok(new UsuarioOutputDto(alterado));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deletaPor(@PathVariable int id){
        Usuario usuario = this.usuarioRepository.getReferenceById(id);
        this.usuarioRepository.deleteById(usuario.getId());

        return ResponseEntity.ok().build();
    }
    @PostMapping("/validar-senha")
    public ResponseEntity validarSenha(@RequestBody UsuarioLoginInputDto usuarioLoginInputDto){
        boolean senhaValida = usuarioService.validarSenha(usuarioLoginInputDto);
        return senhaValida ?
                ResponseEntity.ok(new UsuarioOutputDto(usuarioService.emailExiste(usuarioLoginInputDto.getEmail()))) :
                ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("Senha Incorreta");
    }
    @GetMapping("/{id}/reservas")
    public ResponseEntity buscaReservasPorUsuario(@PathVariable int id){
        Usuario usuario = this.usuarioRepository.getReferenceById(id);
        ReservaPorUsuarioOutputDto dto = new ReservaPorUsuarioOutputDto(usuario);

        return ResponseEntity.ok(dto);
    }
}