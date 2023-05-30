package pfe.constat.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DegatRequest {
    private List<String> degatPhysique;
    private List<String> degatMateriel;


}
