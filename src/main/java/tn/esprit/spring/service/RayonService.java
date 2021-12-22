package tn.esprit.spring.service;

import tn.esprit.spring.DAO.entity.Rayon;

import java.util.List;

public interface RayonService {
    List<Rayon> retrieveAllRayons();

    Rayon addRayon(Rayon r);

    void deleteRayon(Long id);

    Rayon updateRayon(Rayon r);

    Rayon retrieveRayon(Long idRayon);
}
