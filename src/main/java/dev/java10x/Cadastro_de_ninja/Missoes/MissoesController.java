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

    @GetMapping("/listar/{id}")
    public MissoesModel verMissoesId(@PathVariable Long id){
        return missoesService.listarMissoesID(id);
    }

    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missoes){
        return missoesService.criarMissoes(missoes);
    }

    @PutMapping("/alterar/{id}")
    public MissoesModel alterarMissao(@PathVariable Long id, @RequestBody MissoesModel missoesAtualizada){
        return missoesService.atualizarMissoes(id, missoesAtualizada);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id){
        missoesService.deletarMissao(id);
    }

}
