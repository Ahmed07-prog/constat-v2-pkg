package pfe.constat.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TemoinRequest {
    private String nomComplet;
    private String addresse;
    private String tel;
}
