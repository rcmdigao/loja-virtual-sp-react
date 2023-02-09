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
@Entity(name = "estado")
public class Estado {

    @Include
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sigla")
    private String sigla;
}
