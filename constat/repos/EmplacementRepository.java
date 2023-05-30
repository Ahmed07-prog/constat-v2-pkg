package pfe.constat.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.constat.models.Emplacement;

@Repository
public interface EmplacementRepository extends JpaRepository<Emplacement, Long> {
}