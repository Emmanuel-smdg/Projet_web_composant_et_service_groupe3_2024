package bf.ibam.gestion_produits_groupe3.web;

import bf.ibam.gestion_produits_groupe3.entities.Vente;
import bf.ibam.gestion_produits_groupe3.entities.VenteId;
import bf.ibam.gestion_produits_groupe3.repositories.VenteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/ventes")
public class VenteController {

    private VenteRepository venteRepository;

    @GetMapping
    public List<Vente> getAllVentes() {
        return venteRepository.findAll();
    }

    @GetMapping("/{idProduit}/{idClient}")
    public ResponseEntity<Vente> getVenteById(@PathVariable Long idProduit, @PathVariable Long idClient) {
        VenteId venteId = new VenteId(idProduit, idClient);
        return venteRepository.findById(venteId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Vente createVente(@RequestBody Vente vente) {
        return venteRepository.save(vente);
    }

    @PutMapping("/{idProduit}/{idClient}")
    public ResponseEntity<Vente> updateVente(@PathVariable Long idProduit, @PathVariable Long idClient, @RequestBody Vente venteDetails) {
        VenteId venteId = new VenteId(idProduit, idClient);
        return venteRepository.findById(venteId)
                .map(vente -> {
                    vente.setDateAchat(venteDetails.getDateAchat());
                    vente.setHeureAchat(venteDetails.getHeureAchat());
                    return ResponseEntity.ok(venteRepository.save(vente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{idProduit}/{idClient}")
    public ResponseEntity<?> deleteVente(@PathVariable Long idProduit, @PathVariable Long idClient) {
        VenteId venteId = new VenteId(idProduit, idClient);
        return venteRepository.findById(venteId)
                .map(vente -> {
                    venteRepository.delete(vente);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
