package pfe.constat.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.constat.models.Humain;
@Repository

public interface HumainRepository extends JpaRepository<Humain, Long> {
}