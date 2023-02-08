package br.com.backend.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.backend.entity.Cidade;
import br.com.backend.repository.CidadeRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CidadeService {

    private final CidadeRepository cidadeRepository;

    public List<Cidade> buscarTodos(){
        return cidadeRepository.findAll();
    }

    public Cidade buscarPorId(Long id){
        Optional<Cidade> objeto = cidadeRepository.findById(id);
        return objeto.get();
    }

    public Cidade inserir(Cidade objeto) {
        objeto.setDataCriacao(new Date());
        Cidade cidadeNova = cidadeRepository.saveAndFlush(objeto);
        return cidadeNova;
    }

    public Cidade alterar(Cidade objeto) {
        objeto.setDataAtualizaçao(new Date());
        return cidadeRepository.saveAndFlush(objeto);
    }

    public void excluir(Long id) {
        Cidade objeto = cidadeRepository.findById(id).get();
        cidadeRepository.delete(objeto);
    }
    
}
