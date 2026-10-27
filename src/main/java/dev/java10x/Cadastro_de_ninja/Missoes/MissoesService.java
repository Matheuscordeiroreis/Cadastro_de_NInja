package dev.java10x.Cadastro_de_ninja.Missoes;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {
    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

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

    public void deletarMissao (Long id){
        missoesRepository.deleteById(id);
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
