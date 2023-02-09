package br.com.backend.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.backend.entity.Produto;
import br.com.backend.entity.ProdutoImagens;
import br.com.backend.repository.ProdutoImagensRepository;
import br.com.backend.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProdutoImagensService {

    private final ProdutoImagensRepository produtoImagensRepository;
    private final ProdutoRepository produtoRepository;

    public List<ProdutoImagens> buscarTodos(){
        return produtoImagensRepository.findAll();
    }

    public ProdutoImagens buscarPorId(Long id){
        Optional<ProdutoImagens> objeto = produtoImagensRepository.findById(id);
        return objeto.get();
    }

    public ProdutoImagens inserir(Long idProduto, MultipartFile file) {
        
        Produto produto = produtoRepository.findById(idProduto).get();
        ProdutoImagens objeto = new ProdutoImagens();

        try {
            
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String nomeImagem = String.valueOf(produto.getId()) + file.getOriginalFilename();
                Path caminho = Paths.get("c:/imagens" + nomeImagem);
                Files.write(caminho, bytes);
                objeto.setNome(nomeImagem);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        objeto.setProduto(produto);
        objeto = produtoImagensRepository.saveAndFlush(objeto);


        return objeto;
    }

    public ProdutoImagens alterar(ProdutoImagens objeto) {
        return produtoImagensRepository.saveAndFlush(objeto);
    }

    public void excluir(Long id) {
        ProdutoImagens objeto = produtoImagensRepository.findById(id).get();
        produtoImagensRepository.delete(objeto);
    }
    
}
