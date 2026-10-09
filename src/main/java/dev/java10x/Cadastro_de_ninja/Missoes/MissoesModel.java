package dev.java10x.Cadastro_de_ninja.Missoes;

import dev.java10x.Cadastro_de_ninja.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table (name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissoesModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "nomemissao")
    private String nomemissao;
    @Column(name = "niveldificuldade")
    private int niveldedificuldade;
    @OneToMany
    private List<NinjaModel> ninjas;

}
