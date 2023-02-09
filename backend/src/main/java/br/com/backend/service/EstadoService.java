package br.com.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.backend.entity.Estado;
import br.com.backend.repository.EstadoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EstadoService {

    private final EstadoRepository estadoRepository;

    public List<Estado> buscarTodos() {
        return estadoRepository.findAll();
    }

    public Estado inserir(Estado estado) {
        Estado estadoNovo = estadoRepository.saveAndFlush(estado);
        return estadoNovo;
    }

    public Estado alterar(Estado estado) {
        return estadoRepository.saveAndFlush(estado);
    }

    public void excluir(Long id) {
        Estado estado = estadoRepository.findById(id).get();
        estadoRepository.delete(estado);
    }


}
