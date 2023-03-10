package br.com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.backend.entity.Marca;
import br.com.backend.service.MarcaService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/marca")
public class MarcaController {

    @Autowired
    private final MarcaService marcaService;

    @GetMapping("/")
    public List<Marca> buscarTodos() {
        return marcaService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> buscarPorId(@PathVariable Long id) {
        Marca obj = marcaService.buscarPorId(id);
        return ResponseEntity.ok().body(obj);

    }

    @PostMapping("/")
    public Marca inserir(@RequestBody Marca marca) {
        return marcaService.inserir(marca);
    }

    @PutMapping("/")
    public Marca alterar(@RequestBody Marca marca) {
        return marcaService.alterar(marca);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        marcaService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
