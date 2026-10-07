package dev.java10x.Cadastro_de_ninja.Missaoes;

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
    private long id;
    private String nomemissao;
    private int niveldedificuldade;
    @OneToMany
    private List<NinjaModel> ninjas;

}
