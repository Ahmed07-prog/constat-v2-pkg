package pfe.constat.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class VehiculeRequest {
    private String matricule;
    private String numVin;
    private DegatRequest degats;
    private String signature;

}
