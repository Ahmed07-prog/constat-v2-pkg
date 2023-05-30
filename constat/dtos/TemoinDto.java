package pfe.constat.dtos;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link pfe.constat.models.Temoin}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TemoinDto implements Serializable {
    String nomComplet;
    String addresse;
    String tel;
}