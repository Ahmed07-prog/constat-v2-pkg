package pfe.constat.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link pfe.constat.models.Emplacement}
 */
@Getter
@Setter
@AllArgsConstructor
public class EmplacementDto implements Serializable {
    String ville;
    String address;
    private String venantDe;
    private String allantA;
}