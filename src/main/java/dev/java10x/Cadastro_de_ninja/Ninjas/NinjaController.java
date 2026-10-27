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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninjas) {
        return ninjaService.criarNinja(ninjas);
    }

    //Procurar Ninja por ID (READ)
    @GetMapping("/listar/{id}")
    public NinjaDTO listarNinjasId(@PathVariable Long id) {
        return ninjaService.listarNinjasId(id);
    }

    //Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaDTO> verNinjas(){
        return ninjaService.listarNinjas();
    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaDTO) {
        return ninjaService.atualizarNinja(id, ninjaDTO);
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id){
        ninjaService.deletarNinja(id);
    }

}
