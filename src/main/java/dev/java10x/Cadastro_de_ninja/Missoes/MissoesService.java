package dev.java10x.Cadastro_de_ninja.Missoes;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {
    private final MissoesRepository missoesRepository;
    private final  MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    public List<MissoesDTO> listarMissoes() {
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    public MissoesDTO listarMissoesID(Long id) {
        Optional <MissoesModel> listarMissaoID = missoesRepository.findById(id);
        return listarMissaoID.map(missoesMapper::map).orElse(null);
    }

    public MissoesDTO criarMissoes (MissoesDTO missoes){
        MissoesModel missoesModel = missoesMapper.map(missoes);
        missoesRepository.save(missoesModel);
        return missoesMapper.map(missoesModel);
    }

    public boolean deletarMissao (Long id) {
        MissoesModel missao = missoesRepository.findById(id).orElse(null);
        if (missao == null) {
            return false;
        } else if (missao.getNinjas() != null && !missao.getNinjas().isEmpty()) {
            return false;
        }
        missoesRepository.delete(missao);
        return true;
    }

    public MissoesDTO atualizarMissoes (Long id, MissoesDTO missaoDTO) {
        Optional<MissoesModel> missoesExistente = missoesRepository.findById(id);
        if (missoesExistente.isPresent()){
            MissoesModel missaoAtualizada = missoesMapper.map(missaoDTO);
            missaoAtualizada.setId(id);
            MissoesModel missaoSalva = missoesRepository.save(missaoAtualizada);
            return missoesMapper.map(missaoSalva);
        }
        return null;
    }

    }
