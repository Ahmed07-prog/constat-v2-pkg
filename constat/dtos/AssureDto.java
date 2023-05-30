package pfe.constat.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link pfe.Assuré.Assure}
 */
@Getter
@Setter
@AllArgsConstructor
public class AssureDto implements Serializable {
    String nomComplet;
}