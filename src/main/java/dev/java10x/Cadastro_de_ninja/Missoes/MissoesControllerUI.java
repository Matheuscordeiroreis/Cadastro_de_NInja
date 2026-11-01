package dev.java10x.Cadastro_de_ninja.Missoes;

import dev.java10x.Cadastro_de_ninja.Ninjas.NinjaDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/missoes/ui")
public class MissoesControllerUI {

    private final MissoesService missoesService;

    public MissoesControllerUI(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public String verNinja(Model model){
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        model.addAttribute("missoes", missoes);
        return "ListarMissoes";
    }

    @GetMapping("/criar")
    public String FormularioMissao(Model model) {
        model.addAttribute("missoes", new MissoesDTO());
        return "AdicionarMissao";
    }

    @PostMapping("/salvar")
    public String salvarNinja(@ModelAttribute MissoesDTO missoesDTO, RedirectAttributes redirectAttributes) {
        missoesService.criarMissoes(missoesDTO);
        redirectAttributes.addFlashAttribute("mensagem", "Missão cadastrado com sucesso");
        return "redirect:/missoes/ui/listar";
    }

    @GetMapping("/editar/{id}")
    public String EditarMissao (@PathVariable Long id, Model model){
        MissoesDTO missaoAtualizada = missoesService.listarMissoesID(id);
        model.addAttribute("missaoAtualizado", missaoAtualizada);
        return "AlterarMissoes";
    }

    @PostMapping("/salvarAlterado")
    public String salvarMissaoAlterado(@ModelAttribute  MissoesDTO missoesDTO, RedirectAttributes redirectAttributes) {
        missoesService.atualizarMissoes(missoesDTO.getId(), missoesDTO);
        redirectAttributes.addFlashAttribute("mensagem", "Missão cadastrado com sucesso");
        return "redirect:/missoes/ui/listar";
    }

    @GetMapping("/deletar/{id}")
    public String deletarMissaoPorId(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        boolean deletada = missoesService.deletarMissao(id);
        if (deletada) {
            redirectAttributes.addFlashAttribute("mensagem" , "Missão excluida com sucesso!");
        } else {
            redirectAttributes.addFlashAttribute("erro" , "Não e possivel excluir uma missão que possui ninjas vinculados!");
        }

        return "redirect:/missoes/ui/listar";
    }




}
