package br.com.backend.entity;

import lombok.*;
import lombok.EqualsAndHashCode.Include;
import javax.persistence.*;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import static javax.persistence.GenerationType.IDENTITY;
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "permissao")
public class Permissao {

    @Include
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_criacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Column(name = "data_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
}
