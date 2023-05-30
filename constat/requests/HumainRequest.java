package pfe.constat.requests;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HumainRequest {
    private String nomComplet;
    private String cin;
    private DegatRequest degats;
    private String signature;
}
