package dev.java10x.Cadastro_de_ninja.Missoes;

import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

     public MissoesModel map (MissoesDTO missoesDTO){
         MissoesModel missoesModel = new MissoesModel();
         missoesModel.setId(missoesDTO.getId());
         missoesModel.setNomemissao(missoesDTO.getNomemissao());
         missoesModel.setNiveldedificuldade(missoesDTO.getNiveldedificuldade());
         missoesModel.setNinjas(missoesDTO.getNinjas());

         return missoesModel;
     }

    public MissoesDTO map (MissoesModel missoesModel){
        MissoesDTO missoesDTO = new MissoesDTO();
        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setNomemissao(missoesModel.getNomemissao());
        missoesDTO.setNiveldedificuldade(missoesModel.getNiveldedificuldade());
        missoesDTO.setNinjas(missoesModel.getNinjas());

        return missoesDTO;
    }
}
