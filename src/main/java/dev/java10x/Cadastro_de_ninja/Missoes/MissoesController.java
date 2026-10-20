package dev.java10x.Cadastro_de_ninja.Missoes;
import dev.java10x.Cadastro_de_ninja.Ninjas.NinjaModel;
import dev.java10x.Cadastro_de_ninja.Ninjas.NinjaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    private MissoesService missoesService;

    @GetMapping("/listar")
    public List<MissoesModel> verMissoes(){
        return missoesService.listarMissoes();
    }

    @PostMapping("/criar")
    public String criarMissao(){
        return "Missão Criada com sucesso";
    }

    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missão Alterada com sucesso";
    }

    @DeleteMapping("/deletarMissao")
    public String deletarMissao(){
        return "Missão deletada com sucesso";
    }

}
