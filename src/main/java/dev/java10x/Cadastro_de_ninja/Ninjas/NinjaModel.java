package dev.java10x.Cadastro_de_ninja.Ninjas;
import dev.java10x.Cadastro_de_ninja.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table (name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "email")
    private String email;
    @Column(name = "idade")
    private int idade;
    @ManyToOne
    @JoinColumn (name = "missoes_id")
    private List<MissoesModel> missoes;

}
