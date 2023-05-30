package pfe.constat.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmplacementRequest {
    private String ville;
    private String address;
    private String venantDe;
    private String allantA;
}
