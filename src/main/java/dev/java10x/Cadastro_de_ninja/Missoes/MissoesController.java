package dev.java10x.Cadastro_de_ninja.Missoes;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    @GetMapping("listar")
    public String listarMissaoes(){
        return "Missões lsitadas com sucesso";
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
