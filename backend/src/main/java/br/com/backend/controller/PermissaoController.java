package br.com.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.backend.entity.Permissao;
import br.com.backend.service.PermissaoService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/permissao")
public class PermissaoController {

    private final PermissaoService permissaoService;

    @GetMapping("/")
    public List<Permissao> buscarTodos() {
        return permissaoService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Permissao> buscarPorId(@PathVariable Long id) {
        Permissao objeto = permissaoService.buscarPorId(id);
        return ResponseEntity.ok().body(objeto);

    }

    @PostMapping("/")
    public Permissao inserir(@RequestBody Permissao objeto) {
        return permissaoService.inserir(objeto);
    }

    @PutMapping("/")
    public Permissao alterar(@RequestBody Permissao objeto) {
        return permissaoService.alterar(objeto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        permissaoService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
