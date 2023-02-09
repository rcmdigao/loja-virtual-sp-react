package br.com.backend.config;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.backend.entity.Cidade;
import br.com.backend.entity.Estado;
import br.com.backend.repository.CidadeRepository;
import br.com.backend.repository.EstadoRepository;
import br.com.backend.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Component
@RequiredArgsConstructor
@Slf4j
public class DataLoader implements CommandLineRunner {
    
    private final AtomicLong counter = new AtomicLong(); // Gerando numeros aleatorios

    private final EstadoRepository estadoRepository;
    private final CidadeRepository cidadeRepository;
    private final PessoaRepository pessoaRespository;

	@Override
	public void run(String... args) throws Exception {

        Estado es1 = new Estado(counter.incrementAndGet(), "Distrito Federal", "DF");
        estadoRepository.save(es1);
        log.info("Estado 1:" + es1);

        Estado es2 = new Estado(counter.incrementAndGet(), "Rio de Janeiro", "RJ");
        estadoRepository.save(es2);
        log.info("Estado 2:" + es2);

        Cidade c1 = new Cidade(counter.incrementAndGet(), "Brasília", es1);
        cidadeRepository.save(c1);
        log.info("Cidade 1:" + c1);

        Cidade c2 = new Cidade(counter.incrementAndGet(), "Rio das Ostras", es2);
        cidadeRepository.save(c2);
        log.info("Cidade 2:" + c2);

        //********************************************************************************************************************* */

        /*
        Pessoa p1 = new Pessoa(
                    counter.incrementAndGet(), 
                    "Rodrigo", 
                    "929.857.691-91", 
                    "email@gmail.com", 
                    "123", 
                    "Condominio", 
                    "73092902", 
                    c1, 
                    new Date(), 
                    new Date()
            );
        pessoaRespository.save(p1);
     */


	}



}
