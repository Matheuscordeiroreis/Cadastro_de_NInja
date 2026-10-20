package dev.java10x.Cadastro_de_ninja.Missoes;
import dev.java10x.Cadastro_de_ninja.Ninjas.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MissoesService {
    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }
}