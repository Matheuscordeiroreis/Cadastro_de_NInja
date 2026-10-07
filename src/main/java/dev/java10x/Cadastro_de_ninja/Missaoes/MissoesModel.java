package dev.java10x.Cadastro_de_ninja.Missaoes;

import dev.java10x.Cadastro_de_ninja.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "tb_missoes")
public class MissoesModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String nomemissao;
    private int niveldedificuldade;
    @OneToMany
    private List<NinjaModel> ninjas;

    public MissoesModel() {
    }

    public List<NinjaModel> getNinjas() {
        return ninjas;
    }

    public void setNinjas(List<NinjaModel> ninjas) {
        this.ninjas = ninjas;
    }

    public MissoesModel(long id, int niveldedificuldade, String nomemissao, List ninjas) {
        this.id = id;
        this.niveldedificuldade = niveldedificuldade;
        this.nomemissao = nomemissao;
        this.ninjas = ninjas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomemissao() {
        return nomemissao;
    }

    public void setNomemissao(String nomemissao) {
        this.nomemissao = nomemissao;
    }

    public int getNiveldedificuldade() {
        return niveldedificuldade;
    }

    public void setNiveldedificuldade(int niveldedificuldade) {
        this.niveldedificuldade = niveldedificuldade;
    }


}


