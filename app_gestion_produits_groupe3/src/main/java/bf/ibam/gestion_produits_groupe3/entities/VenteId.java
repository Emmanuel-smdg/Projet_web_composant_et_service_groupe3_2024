package bf.ibam.gestion_produits_groupe3.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VenteId implements Serializable {
    private Long idProduit;
    private Long idClient;
}
