package pfe.constat.models;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pfe.Assuré.Assure;

import java.util.Date;
import java.util.List;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "constat")
public class Constat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date createdAt;

     @ManyToOne
    private Assure createdBy;
    @OneToMany
    @JoinTable(name = "constat_vehicule",
            joinColumns = @JoinColumn(name = "constat_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicule_id"))
    private List<Humain> humains;
    @OneToMany
    @JoinTable(name = "constat_humain",
            joinColumns = @JoinColumn(name = "constat_id"),
            inverseJoinColumns = @JoinColumn(name = "humain_id"))
    private List<Vehicule> vehicules;
    @OneToOne
    private Emplacement emplacement;
    @OneToOne
    private Situation situation;
    @OneToOne
    private Historique historique;
    @OneToMany
   @JoinTable(name = "constat_temoins",
            joinColumns = @JoinColumn(name = "constat_id"),
            inverseJoinColumns = @JoinColumn(name = "temoin_id"))
    private List<Temoin> temoins;

}

