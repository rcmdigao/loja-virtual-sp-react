package br.com.backend.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.backend.entity.Marca;
import br.com.backend.repository.MarcaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MarcaService {

    private final MarcaRepository marcaRepository;

    public List<Marca> buscarTodos(){
        return marcaRepository.findAll();
    }

    public Marca buscarPorId(Long id){
        Optional<Marca> obj = marcaRepository.findById(id);
        return obj.get();
    }

    public Marca inserir(Marca marca) {
        marca.setDataCriacao(new Date());
        Marca marcaNova = marcaRepository.saveAndFlush(marca);
        return marcaNova;
    }

    public Marca alterar(Marca marca) {
        marca.setDataAtualizaçao(new Date());
        return marcaRepository.saveAndFlush(marca);
    }

    public void excluir(Long id) {
        Marca marca = marcaRepository.findById(id).get();
        marcaRepository.delete(marca);
    }
    
}
