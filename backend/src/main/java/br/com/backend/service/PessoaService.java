package br.com.backend.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.backend.entity.Pessoa;
import br.com.backend.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public List<Pessoa> buscarTodos(){
        return pessoaRepository.findAll();
    }

    public Pessoa buscarPorId(Long id){
        Optional<Pessoa> objeto = pessoaRepository.findById(id);
        return objeto.get();
    }

    public Pessoa inserir(Pessoa objeto) {
        objeto.setDataCriacao(new Date());
        Pessoa pessoaNova = pessoaRepository.saveAndFlush(objeto);
        return pessoaNova;
    }

    public Pessoa alterar(Pessoa objeto) {
        objeto.setDataAtualizacao(new Date());
        return pessoaRepository.saveAndFlush(objeto);
    }

    public void excluir(Long id) {
        Pessoa objeto = pessoaRepository.findById(id).get();
        pessoaRepository.delete(objeto);
    }
    
}
