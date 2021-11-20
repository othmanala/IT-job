package loginsignup.service;


import loginsignup.model.Entreprise;

import java.util.List;
import java.util.Optional;

public interface EntrepriseService {

    public Entreprise add_entreprise(Entreprise e);
    public List<Entreprise> findAll();
    public Optional<Entreprise> find_entreprise (long id);


    public void delete_entreprise(long id);
    public Entreprise update_entreprise(Entreprise e);
    /*
    public List<Entreprise> recherche_region(String reg);
    public List<Entreprise> recherche_advanced(String reg,String pseudo);*/

}
