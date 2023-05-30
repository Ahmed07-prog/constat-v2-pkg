package pfe.constat.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.constat.models.Historique;
@Repository

public interface HistoriqueRepository extends JpaRepository<Historique, Long> {
}