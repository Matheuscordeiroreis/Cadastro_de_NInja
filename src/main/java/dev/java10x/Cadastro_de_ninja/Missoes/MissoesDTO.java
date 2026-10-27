package dev.java10x.Cadastro_de_ninja.Missoes;

import dev.java10x.Cadastro_de_ninja.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissoesDTO {

    private Long id;
    private String nomemissao;
    private Integer niveldedificuldade;
    private List<NinjaModel> ninjas;
}
