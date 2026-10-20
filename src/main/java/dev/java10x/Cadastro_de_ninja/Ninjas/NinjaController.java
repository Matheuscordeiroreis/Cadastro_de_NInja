package dev.java10x.Cadastro_de_ninja.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado com sucesso";
    }


    //Procurar Ninja por ID (READ)
    @GetMapping("/listarID")
    public String verNinjasID(){
        return "Ninjas listado por id com sucesso";
    }

    //Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> verNinjas(){
        return ninjaService.listarNinjas();
    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar")
    public String alterarNinjasId(){
        return "Alterar Ninjas com sucesso";
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletarNinjas")
    public String deletarNinjas(){
        return "Ninja deletado com sucesso";
    }



}
