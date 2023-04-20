package br.com.tex.hotelhapi.controller;

import br.com.tex.hotelhapi.model.ClasseUsuario;
import br.com.tex.hotelhapi.model.Usuario;
import br.com.tex.hotelhapi.model.dto.UsuarioInputDto;
import br.com.tex.hotelhapi.model.dto.UsuarioOutputDto;
import br.com.tex.hotelhapi.repository.ClasseUsuarioRepository;
import br.com.tex.hotelhapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ClasseUsuarioRepository classeUsuarioRepository;
    @GetMapping
    public ResponseEntity lista(){
        List<Usuario> usuarios = this.usuarioRepository.findAll();
        if(usuarios.size() == 0)
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(usuarios.stream().map(usuario -> new UsuarioOutputDto(usuario)).toList());
    }
    @PostMapping
    public ResponseEntity cadastra(@RequestBody @Valid UsuarioInputDto usuarioDto, UriComponentsBuilder uriBuilder){
        ClasseUsuario classeUsuario = this.classeUsuarioRepository.getReferenceById(usuarioDto.getClasseUsuarioId());
        Usuario usuario = usuarioDto.toUsuario(classeUsuario);
        Usuario salvo = this.usuarioRepository.save(usuario);

        return ResponseEntity
                .created(uriBuilder.path("/usuarios/{id}").buildAndExpand(salvo.getId()).toUri())
                .body(new UsuarioOutputDto(salvo));
    }
    @GetMapping("/{id}")
    public ResponseEntity buscaPor(@PathVariable int id){
        Usuario usuario = this.usuarioRepository.getReferenceById(id);
        return ResponseEntity.ok(new UsuarioOutputDto(usuario));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deletaPor(@PathVariable int id){
        Usuario usuario = this.usuarioRepository.getReferenceById(id);
        this.usuarioRepository.deleteById(usuario.getId());

        return ResponseEntity.ok().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity altera(@PathVariable int id, @RequestBody UsuarioInputDto dto){
        this.usuarioRepository.getReferenceById(id);
        Usuario usuario = dto.toUsuario(this.classeUsuarioRepository.findById(dto.getClasseUsuarioId()).get());
        usuario.setId(id);
        Usuario alterado = this.usuarioRepository.save(usuario);

        return ResponseEntity.ok(new UsuarioOutputDto(alterado));
    }
}