package loginsignup.service;


import loginsignup.model.Entreprise;
import loginsignup.repository.EntrepriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrepriseServiceImp implements EntrepriseService {
    @Autowired
    private EntrepriseRepository agent;


    @Override
    public Entreprise add_entreprise(Entreprise e) {
        return agent.save(e);
    }

    @Override
    public List<Entreprise> findAll() {
        return (List<Entreprise>) agent.findAll();
    }



    @Override
    public Entreprise update_entreprise(Entreprise e) {
        return agent.save(e);
    }

    @Override
    public void delete_entreprise(long id) {
        agent.deleteById(id);
    }
    @Override
    public Optional<Entreprise> find_entreprise(long id) {
        return agent.findById(id);
    }

}
