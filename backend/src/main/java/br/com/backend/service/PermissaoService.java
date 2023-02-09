package br.com.backend.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.backend.entity.Permissao;
import br.com.backend.repository.PermissaoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PermissaoService {

    private final PermissaoRepository permissaoRepository;

    public List<Permissao> buscarTodos(){
        return permissaoRepository.findAll();
    }

    public Permissao buscarPorId(Long id){
        Optional<Permissao> objeto = permissaoRepository.findById(id);
        return objeto.get();
    }

    public Permissao inserir(Permissao objeto) {
        objeto.setDataCriacao(new Date());
        Permissao pessoaNova = permissaoRepository.saveAndFlush(objeto);
        return pessoaNova;
    }

    public Permissao alterar(Permissao objeto) {
        objeto.setDataAtualizacao(new Date());
        return permissaoRepository.saveAndFlush(objeto);
    }

    public void excluir(Long id) {
        Permissao objeto = permissaoRepository.findById(id).get();
        permissaoRepository.delete(objeto);
    }
    
}
