package br.com.backend.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.backend.entity.Produto;
import br.com.backend.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public List<Produto> buscarTodos(){
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id){
        Optional<Produto> objeto = produtoRepository.findById(id);
        return objeto.get();
    }

    public Produto inserir(Produto objeto) {
        objeto.setDataCriacao(new Date());
        Produto pessoaNova = produtoRepository.saveAndFlush(objeto);
        return pessoaNova;
    }

    public Produto alterar(Produto objeto) {
        objeto.setDataAtualizacao(new Date());
        return produtoRepository.saveAndFlush(objeto);
    }

    public void excluir(Long id) {
        Produto objeto = produtoRepository.findById(id).get();
        produtoRepository.delete(objeto);
    }
    
}
