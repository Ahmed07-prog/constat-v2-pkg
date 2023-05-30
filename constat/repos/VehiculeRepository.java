package pfe.constat.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.constat.models.Vehicule;
@Repository

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
}