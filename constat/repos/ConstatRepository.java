package pfe.constat.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.Assuré.Assure;
import pfe.constat.models.Constat;

import java.util.List;

@Repository
public interface ConstatRepository extends JpaRepository<Constat, Long> {
    List<Constat> findAllByCreatedById(Integer id);


}