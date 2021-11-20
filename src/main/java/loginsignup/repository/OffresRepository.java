package loginsignup.repository;


import loginsignup.model.Offre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffresRepository extends CrudRepository<Offre,Long> {

}
