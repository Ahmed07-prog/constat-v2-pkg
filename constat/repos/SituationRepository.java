package pfe.constat.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import pfe.constat.models.Situation;

public interface SituationRepository extends JpaRepository<Situation, Long> {
}