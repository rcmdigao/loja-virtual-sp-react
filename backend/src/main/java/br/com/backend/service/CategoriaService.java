package br.com.backend.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.backend.entity.Categoria;
import br.com.backend.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public List<Categoria> buscarTodos(){
        return categoriaRepository.findAll();
    }

    public Categoria buscarPorId(Long id){
        Optional<Categoria> objeto = categoriaRepository.findById(id);
        return objeto.get();
    }

    public Categoria inserir(Categoria objeto) {
        objeto.setDataCriacao(new Date());
        Categoria cidadeNova = categoriaRepository.saveAndFlush(objeto);
        return cidadeNova;
    }

    public Categoria alterar(Categoria objeto) {
        objeto.setDataAtualizaçao(new Date());
        return categoriaRepository.saveAndFlush(objeto);
    }

    public void excluir(Long id) {
        Categoria objeto = categoriaRepository.findById(id).get();
        categoriaRepository.delete(objeto);
    }
    
}
