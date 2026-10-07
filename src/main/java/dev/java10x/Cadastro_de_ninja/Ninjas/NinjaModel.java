package dev.java10x.Cadastro_de_ninja.Ninjas;
import dev.java10x.Cadastro_de_ninja.Missaoes.MissoesModel;
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
    private long id;
    private String nome;
    private String email;
    private int idade;
    @ManyToOne
    @JoinColumn (name = "missoes_id")
    private List<MissoesModel> missoes;

    }
}
