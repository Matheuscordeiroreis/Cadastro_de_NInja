package dev.java10x.Cadastro_de_ninja.Missaoes;

import jakarta.persistence.*;

@Entity
@Table (name = "tb_missoes")
public class MissoesModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String nomemissao;
    private int niveldedificuldade;

    public MissoesModel() {
    }

    public MissoesModel(long id, int niveldedificuldade, String nomemissao) {
        this.id = id;
        this.niveldedificuldade = niveldedificuldade;
        this.nomemissao = nomemissao;
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


