package pfe.constat.dtos;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link pfe.constat.models.Vehicule}
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiculeDto implements Serializable {
    String matricule;
    String numVin;
    DegatDto degats;
    String signature;
}