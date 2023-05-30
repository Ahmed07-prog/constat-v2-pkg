package pfe.constat.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.constat.models.Degat;

@Repository
public interface DegatRepository extends JpaRepository<Degat, Long> {
}