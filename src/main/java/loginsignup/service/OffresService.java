package loginsignup.service;


import loginsignup.model.Offre;

import java.util.List;
import java.util.Optional;

public interface OffresService {
    public Offre add_offres(Offre offre);
    public List<Offre> findAll();

    public Optional<Offre> find_offre (long id);


    public void delete_offre(long id);
    public Offre update_offre(Offre e);
}
