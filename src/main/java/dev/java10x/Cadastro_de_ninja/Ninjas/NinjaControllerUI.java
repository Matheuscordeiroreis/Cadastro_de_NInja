package dev.java10x.Cadastro_de_ninja.Ninjas;

import dev.java10x.Cadastro_de_ninja.Missoes.MissoesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUI {

    private final NinjaService ninjaService;
    private final MissoesRepository missoesRepository;


    public NinjaControllerUI(NinjaService ninjaService, MissoesRepository missoesRepository){
        this.ninjaService = ninjaService;
        this.missoesRepository = missoesRepository;
    }

    @GetMapping("/listar")
    public String verNinjas(Model model){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        model.addAttribute("ninjas", ninjas);
        return "ListarNinjas";
    }

    @GetMapping("/deletar/{id}")
    public String deletarNinjaPorId(@PathVariable Long id){
        ninjaService.deletarNinja(id);
        return "redirect:/ninjas/ui/listar";
    }

    // Adicionar ninja (CREATE)
    @GetMapping("/criar")
    public String FormularioNinja(Model model) {
        model.addAttribute("ListadeMissoes",missoesRepository.findAll());
        model.addAttribute("ninjas", new NinjaDTO());
        return "AdicionarNinjas";
    }

    @PostMapping("/salvar")
    public String salvarNinja(@ModelAttribute NinjaDTO ninjas, RedirectAttributes redirectAttributes) {
        ninjaService.criarNinja(ninjas);
        redirectAttributes.addFlashAttribute("mensagem", "Ninja cadastrado com sucesso");
        return "redirect:/ninjas/ui/listar";
    }

    @GetMapping("/editar/{id}")
    public String EditarNinja (@PathVariable Long id, Model model){
        NinjaDTO ninjaAtualizado = ninjaService.listarNinjasId(id);
        model.addAttribute("ninjaAtualizado", ninjaAtualizado);
        model.addAttribute("ListadeMissoes", missoesRepository.findAll());
        return "AlterarNinja";
    }

    @PostMapping("/salvarAlterado")
    public String salvarNinjaAlterado(@ModelAttribute  NinjaDTO ninjaDTO, RedirectAttributes redirectAttributes) {
        ninjaService.atualizarNinja(ninjaDTO.getId(), ninjaDTO);
        redirectAttributes.addFlashAttribute("mensagem", "Ninja cadastrado com sucesso");
        return "redirect:/ninjas/ui/listar";
    }

    //Procurar Ninja por ID (READ)
    @PostMapping("/listar/{id}")
    public String listarNinjasId(@PathVariable Long id, Model model) {
        NinjaDTO ninja = ninjaService.listarNinjasId(id);
        if (ninja !=null){
            model.addAttribute("ninjas", ninja);
            return "VerdetalheNinja";
        }else {
            model.addAttribute("mensagem", "Ninja nao encontrado");
            return "redirect:/ninjas/ui/listar";
        }



    }





}


