package bf.ibam.gestion_produits_groupe3.web;

import bf.ibam.gestion_produits_groupe3.entities.Produit;
import bf.ibam.gestion_produits_groupe3.repositories.ProduitRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/produits")
public class ProduitController {
    private ProduitRepository produitRepository;

    @GetMapping
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produit> getProduitById(@PathVariable Long id) {
        return produitRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Produit createProduit(@RequestBody Produit produit) {
        return produitRepository.save(produit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable Long id, @RequestBody Produit produitDetails) {
        return produitRepository.findById(id)
                .map(produit -> {
                    produit.setLibelle(produitDetails.getLibelle());
                    produit.setMarque(produitDetails.getMarque());
                    produit.setPrix(produitDetails.getPrix());
                    produit.setPoids(produitDetails.getPoids());
                    produit.setCouleur(produitDetails.getCouleur());
                    produit.setQuantite(produitDetails.getQuantite());
                    produit.setDescription(produitDetails.getDescription());
                    return ResponseEntity.ok(produitRepository.save(produit));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduit(@PathVariable Long id) {
        return produitRepository.findById(id)
                .map(produit -> {
                    produitRepository.delete(produit);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
