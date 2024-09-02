package bf.ibam.gestion_produits_groupe3.repositories;

import bf.ibam.gestion_produits_groupe3.entities.Vente;
import bf.ibam.gestion_produits_groupe3.entities.VenteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenteRepository extends JpaRepository<Vente, VenteId> {
}
