package pfe.constat.dtos;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * DTO for {@link pfe.constat.models.Constat}
 */

@Getter
@Setter
@AllArgsConstructor
public class ConstatDto implements Serializable {
    private Long id;
    private Date createdAt;
    private String createdBy;
    private List<VehiculeDto> vehicule;
    private List<HumainDto> humain;
    private EmplacementDto emplacement;
    private List<TemoinDto> temoins;

    public ConstatDto() {

    }
}