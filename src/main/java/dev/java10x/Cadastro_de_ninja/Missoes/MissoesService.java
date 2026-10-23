package dev.java10x.Cadastro_de_ninja.Missoes;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {
    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }

    public MissoesModel listarMissoesID(Long id) {
        Optional <MissoesModel> listarMissaoID = missoesRepository.findById(id);
        return listarMissaoID.orElse(null);
    }

    public MissoesModel criarMissoes (MissoesModel missoes){
        return missoesRepository.save(missoes);
    }

    public void deletarMissao (Long id){
        missoesRepository.deleteById(id);
    }

    public MissoesModel atualizarMissoes (Long id, MissoesModel missaoAtualizada) {
        if (missoesRepository.existsById(id)){
            missaoAtualizada.setId(id);
            return missoesRepository.save(missaoAtualizada);
        }return null;
    }




    }
