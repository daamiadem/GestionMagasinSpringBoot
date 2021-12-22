package tn.esprit.spring.DAO.mapper;

import tn.esprit.spring.DAO.entity.DetailFactureEntity;
import tn.esprit.spring.DAO.model.DetailFacture;

import java.util.ArrayList;
import java.util.List;

// Auther: AZZABI HAMZA
public class DetailFactureEntityMapper {
    public static DetailFacture mapDetailFactureEntityToDetailFacture (DetailFactureEntity detailFactureEntity) {
        return new DetailFacture(detailFactureEntity.getIdDetailFacture(), detailFactureEntity.getQte(), detailFactureEntity.getPrixTotal(), detailFactureEntity.getPourcentageRemise(), detailFactureEntity.getMontantRemise() ,detailFactureEntity.getProduit() , FactureEntityMapper.mapFactureEntityToFacture(detailFactureEntity.getFacture()));
    }

    public static DetailFactureEntity mapDetailFactureToDetailFactureEntity (DetailFacture detailFacture) {
        return new DetailFactureEntity(detailFacture.getIdDetailFacture(), detailFacture.getQte(), detailFacture.getPrixTotal(), detailFacture.getPourcentageRemise(), detailFacture.getMontantRemise() ,detailFacture.getProduit() , FactureEntityMapper.mapFactureToFactureEntity(detailFacture.getFacture()));
    }

    public static List<DetailFacture> mapListDetailFactureEntityToDetailFactureList (List<DetailFactureEntity> listDetailFactureEntity) {
        List<DetailFacture> detailFactures= new ArrayList<>();
        for (DetailFactureEntity detailFactureEntity : listDetailFactureEntity) {
            detailFactures.add(new DetailFacture(detailFactureEntity.getIdDetailFacture(), detailFactureEntity.getQte(), detailFactureEntity.getPrixTotal(), detailFactureEntity.getPourcentageRemise(), detailFactureEntity.getMontantRemise() ,detailFactureEntity.getProduit() , FactureEntityMapper.mapFactureEntityToFacture(detailFactureEntity.getFacture())));
        }
        return detailFactures;
    }


}
