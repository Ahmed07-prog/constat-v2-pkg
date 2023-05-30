package pfe.constat.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ConstatRequest {
        private Date createdAt;
        private List<VehiculeRequest> vehicules;
        private List<HumainRequest> humains;
        private EmplacementRequest emplacement;
        private List<TemoinRequest> temoins;

}
