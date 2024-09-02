package bf.ibam.gestion_produits_groupe3.repositories;

import bf.ibam.gestion_produits_groupe3.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
