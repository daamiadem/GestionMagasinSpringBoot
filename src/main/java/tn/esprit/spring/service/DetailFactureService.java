package tn.esprit.spring.service;
import tn.esprit.spring.DAO.model.DetailFacture;

import java.util.Collection;
import java.util.List;

public interface DetailFactureService {
    public void addDetailFacture(DetailFacture detailFacture);

    public void deleteDetailFacture(Long id);

    public void updateDetailFacture(DetailFacture detailFacture);

    public DetailFacture getDetailFacture(Long id);

    public List<DetailFacture> getAllDetailFactures();

    public List<DetailFacture> retrieveAllDetailFactureByFacture(Long id);
}
