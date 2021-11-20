package loginsignup.service;


import loginsignup.model.Offre;
import loginsignup.repository.OffresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OffresServiceImplement implements OffresService {
    @Autowired
    private OffresRepository agent;

    @Override
    public Offre add_offres(Offre offre) {
        return agent.save(offre);
    }

    @Override
    public List<Offre> findAll() {
        return (List<Offre>) agent.findAll();
    }

    @Override
    public Offre update_offre(Offre e) {
        return agent.save(e);
    }

    @Override
    public void delete_offre(long id) {
        agent.deleteById(id);
    }
    @Override
    public Optional<Offre> find_offre(long id) {
        return agent.findById(id);
    }
}
