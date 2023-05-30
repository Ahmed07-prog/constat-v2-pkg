package pfe.constat.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pfe.Assuré.AssureService;
import pfe.constat.dtos.*;
import pfe.constat.models.*;
import pfe.constat.repos.*;
import pfe.constat.requests.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ConstatService {

    private final VehiculeRepository vehiculeRepository;
    private final HumainRepository humainRepository;
    private final ConstatRepository constatRepository;
    private final EmplacementRepository emplacementRepository;
    private final TemoinRepository temoinRepository;
    private final DegatRepository degatRepository;
    private final HistoriqueRepository historiqueRepository;
    private final AssureService assureService;

    public void createConstat(ConstatRequest constatRequest, Integer id) {
        Constat constat = new Constat();
        constat.setCreatedBy(assureService.getById(id));
        constat.setCreatedAt(constatRequest.getCreatedAt());
        if (constatRequest.getHumains() != null) {
            List<Humain> humains = new ArrayList<>();
            for (HumainRequest humainRequest : constatRequest.getHumains()) {
                Humain humain = new Humain();
                humain.setNomComplet(humainRequest.getNomComplet());
                humain.setCin(humainRequest.getCin());
                humain.setSignature(humainRequest.getSignature());
                if (humainRequest.getDegats() != null) {
                    Degat degat = new Degat();
                    if (humainRequest.getDegats().getDegatPhysique() != null) {
                        degat.setDegatPhysique(humainRequest.getDegats().getDegatPhysique());
                    }
                    if (humainRequest.getDegats().getDegatMateriel() != null) {
                        degat.setDegatMateriel(humainRequest.getDegats().getDegatMateriel());
                    }
                    if (humainRequest.getDegats().getDegatPhysique() != null && humainRequest.getDegats().getDegatMateriel() != null) {
                        degat.setDegatPhysique(humainRequest.getDegats().getDegatPhysique());
                        degat.setDegatMateriel(humainRequest.getDegats().getDegatMateriel());
                    }
                    degatRepository.save(degat);
                    humain.setDegats(degat);
                }
                humains.add(humain);
                humainRepository.save(humain);
            }
            constat.setHumains(humains);
        }
        if (constatRequest.getVehicules() != null) {
            List<Vehicule> vehicules = new ArrayList<>();
            for (VehiculeRequest vehiculeRequest : constatRequest.getVehicules()) {
                Vehicule vehicule = new Vehicule();
                vehicule.setMatricule(vehiculeRequest.getMatricule());
                vehicule.setNumVin(vehiculeRequest.getNumVin());
                vehicule.setSignature(vehiculeRequest.getSignature());

                if (vehiculeRequest.getDegats() != null) {
                    Degat degat = new Degat();
                    if (vehiculeRequest.getDegats().getDegatMateriel() != null) {
                        degat.setDegatMateriel(vehiculeRequest.getDegats().getDegatMateriel());
                    }
                    if (vehiculeRequest.getDegats().getDegatPhysique() != null) {
                        degat.setDegatPhysique(vehiculeRequest.getDegats().getDegatPhysique());
                    }
                    if (vehiculeRequest.getDegats().getDegatPhysique() != null && vehiculeRequest.getDegats().getDegatMateriel() != null) {
                        degat.setDegatPhysique(vehiculeRequest.getDegats().getDegatPhysique());
                        degat.setDegatMateriel(vehiculeRequest.getDegats().getDegatMateriel());
                    }
                    degatRepository.save(degat);
                    vehicule.setDegats(degat);
                }
                vehicules.add(vehicule);
                vehiculeRepository.save(vehicule);
            }
            constat.setVehicules(vehicules);
        }
        Emplacement emplacement = new Emplacement();
        emplacement.setVille(constatRequest.getEmplacement().getVille());
        emplacement.setAddress(constatRequest.getEmplacement().getAddress());
        emplacement.setVenantDe(constatRequest.getEmplacement().getVenantDe());
        emplacement.setAllantA(constatRequest.getEmplacement().getAllantA());
        emplacementRepository.save(emplacement);
        Historique historique = new Historique();
        historique.setActeur(assureService.getById(id).getFirstName() + " " + assureService.getById(id).getLastName());
        historique.setDate(constatRequest.getCreatedAt());
        historiqueRepository.save(historique);
        List<Temoin> temoins = new ArrayList<>();
        for (TemoinRequest temoinRequest : constatRequest.getTemoins()) {
            Temoin temoin = new Temoin();
            temoin.setNomComplet(temoinRequest.getNomComplet());
            temoin.setAddresse(temoinRequest.getAddresse());
            temoin.setTel(temoinRequest.getTel());
            temoins.add(temoin);
            temoinRepository.save(temoin);
        }
        constat.setEmplacement(emplacement);
        constat.setTemoins(temoins);
        constat.setHistorique(historique);
        constatRepository.save(constat);
    }


 public List<ConstatDto> getConstatByCreatorId(Integer id) {
        List<Constat> constats = constatRepository.findAllByCreatedById(id);
        return constats.stream().map(constat -> {
            ConstatDto constatDto = new ConstatDto();
            constatDto.setId(constat.getId());
            constatDto.setCreatedBy(constat.getCreatedBy().getFirstName() +" "+ constat.getCreatedBy().getLastName());
            constatDto.setCreatedAt(constat.getCreatedAt());
            constatDto.setEmplacement(new EmplacementDto(constat.getEmplacement().getVille(), constat.getEmplacement().getAddress(), constat.getEmplacement().getVenantDe(), constat.getEmplacement().getAllantA()));
            if(!constat.getVehicules().isEmpty()) {
            constatDto.setVehicule(new ArrayList<>(constat.getVehicules().stream().map(vehicule -> {
                VehiculeDto vehiculeDto = new VehiculeDto();
                vehiculeDto.setMatricule(vehicule.getMatricule());
                vehiculeDto.setNumVin(vehicule.getNumVin());
                vehiculeDto.setDegats(new DegatDto(vehicule.getDegats().getDegatPhysique(), vehicule.getDegats().getDegatMateriel()));
                vehiculeDto.setSignature(vehicule.getSignature());
                return vehiculeDto;
            }).toList()));
            }
            if(!constat.getHumains().isEmpty()) {
            constatDto.setHumain(new ArrayList<>(constat.getHumains().stream().map(humain -> {
                HumainDto humainDto = new HumainDto();
                humainDto.setNomComplet(humain.getNomComplet());
                humainDto.setCin(humain.getCin());
                humainDto.setDegats(new DegatDto(humain.getDegats().getDegatPhysique(), humain.getDegats().getDegatMateriel()));
                humainDto.setSignature(humain.getSignature());
                return humainDto;
            }).toList()));
            }
            constatDto.setTemoins(new ArrayList<>(constat.getTemoins().stream().map(temoin -> {
                TemoinDto temoinDto = new TemoinDto();
                temoinDto.setNomComplet(temoin.getNomComplet());
                temoinDto.setAddresse(temoin.getAddresse());
                temoinDto.setTel(temoin.getTel());
                return temoinDto;
            }).toList()));
            return constatDto;
    }).toList();
    }

/*
    public List<ConstatDto> getAllConstatByAgenceId(Integer id) {

        List<Constat> constats = constatRepository.findAllByCreatedBy(id);
        return constats.stream().map(constat -> {
            ConstatDto constatDto = new ConstatDto();
            constatDto.setId(constat.getId());
            constatDto.setCreatedBy(new AssureDto(constat.getCreatedBy().getFirstName(), constat.getCreatedBy().getLastName()));
            constatDto.setCreatedAt(constat.getCreatedAt());
            constatDto.setEmplacement(new EmplacementDto(constat.getEmplacement().getVille(), constat.getEmplacement().getDirection()));
            constatDto.setIntervenant(new ArrayList<>(constat.getIntervenant().stream().map(intervenant -> {
                IntervenantDto intervenantDto = new IntervenantDto();
                intervenantDto.setSignature(intervenant.getSignature());
                if (intervenant.getVehicule() != null)
                {
                    intervenantDto.setVehicule(new VehiculeDto(intervenant.getVehicule().getMatricule(), intervenant.getVehicule().getNumVin()));
                }
                if (intervenant.getHumain() != null) {
                    intervenantDto.setHumain(new HumainDto(intervenant.getHumain().getNomComplet(), intervenant.getHumain().getCin()));
                }
                intervenantDto.setDegats(new ArrayList<>(intervenant.getDegats().stream().map(degat -> {
                    DegatDto degatDto = new DegatDto();
                    if (degat.getDegatMateriel() != null)
                        degatDto.setDegatMateriel(degat.getDegatMateriel());
                    if (degat.getDegatPhysique() != null)
                        degatDto.setDegatPhysique(degat.getDegatPhysique());
                    return degatDto;
                }).toList()));
                return intervenantDto;
            }).toList()));
            constatDto.setTemoins(new ArrayList<>(constat.getTemoins().stream().map(temoin -> {
                TemoinDto temoinDto = new TemoinDto();
                temoinDto.setNomComplet(temoin.getNomComplet());
                temoinDto.setAddresse(temoin.getAddresse());
                temoinDto.setTel(temoin.getTel());
                return temoinDto;
            }).toList()));
            return constatDto;
        }).toList();
    }*/
}
