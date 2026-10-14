package dev.java10x.Cadastro_de_ninja.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa e minha primeira mesagem nessa rota";
    }


    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado";
    }


    //Procurar Ninja por ID (READ)
    @GetMapping("/todosID")
    public String verNinjasID(){
        return "Ninja por id";
    }

    //Mostrar todos os ninjas (READ)
    @GetMapping("/todos")
    public String verNinjas(){
        return "Ninja por id";
    }


    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjasId(){
        return "Alterar Ninjas por ID";
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/DeletarNinjas")
    public String deletarNinjas(){
        return "Deletar Ninjas";
    }



}
