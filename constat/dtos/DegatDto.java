package pfe.constat.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link pfe.constat.models.Degat}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DegatDto implements Serializable {
    @NotNull
    List<String> degatPhysique;
    @NotNull
    List<String> degatMateriel;
}