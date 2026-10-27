package dev.java10x.Cadastro_de_ninja.Ninjas;

import dev.java10x.Cadastro_de_ninja.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaDTO {
    private Long id;
    private String nome;
    private String email;
    private Integer idade;
    private MissoesModel missoes;
    private String rank;
}
