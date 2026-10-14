package dev.java10x.Cadastro_de_ninja.Missoes;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    @GetMapping("listar")
    public String listarMissaoes(){
        return "Missoes lsitadas com sucesso";
    }

    @PostMapping("/criar")
    public String criarMissao(){
        return "Missao Criada com sucesso";
    }

    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missao Alterada com sucesso";
    }

}
