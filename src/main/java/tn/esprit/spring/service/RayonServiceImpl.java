package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.DAO.entity.Rayon;
import tn.esprit.spring.repository.RayonRepository;

import java.util.List;

@Service
public class RayonServiceImpl implements RayonService {
    @Autowired
    RayonRepository rayonRepository;

    @Override
    public List<Rayon> retrieveAllRayons() {
        List<Rayon> rayons = (List<Rayon>) rayonRepository.findAll();
        for (Rayon rayon : rayons) {
            System.out.println("Rayon :" + rayon);
        }
        return rayons;    }

    @Override
    public Rayon addRayon(Rayon r) {
        rayonRepository.save(r);
        return r;
    }

    @Override
    @Transactional
    public void deleteRayon(Long id) {
        rayonRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Rayon updateRayon(Rayon r) {
        return rayonRepository.save(r);
    }

    @Override
    public Rayon retrieveRayon(Long idRayon) {
        Rayon rayon = rayonRepository.findById(idRayon).orElse(null);
        System.out.println("Rayon :" + rayon);
        return rayon;
    }
}
