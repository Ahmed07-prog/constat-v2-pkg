package pfe.constat.dtos;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link pfe.constat.models.Humain}
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HumainDto implements Serializable {
    String nomComplet;
    String cin;
    DegatDto degats;
    String signature;
}