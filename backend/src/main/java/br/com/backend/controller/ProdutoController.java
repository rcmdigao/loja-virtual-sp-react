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

import br.com.backend.entity.Produto;
import br.com.backend.service.ProdutoService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping("/")
    public List<Produto> buscarTodos() {
        return produtoService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        Produto objeto = produtoService.buscarPorId(id);
        return ResponseEntity.ok().body(objeto);

    }

    @PostMapping("/")
    public Produto inserir(@RequestBody Produto objeto) {
        return produtoService.inserir(objeto);
    }

    @PutMapping("/")
    public Produto alterar(@RequestBody Produto objeto) {
        return produtoService.alterar(objeto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        produtoService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
