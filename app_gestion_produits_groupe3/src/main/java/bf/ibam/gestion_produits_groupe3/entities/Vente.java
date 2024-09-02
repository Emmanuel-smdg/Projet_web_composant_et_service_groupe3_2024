package bf.ibam.gestion_produits_groupe3.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Entity
@Table(name = "vente")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@IdClass(VenteId.class)
public class Vente {
    @Id
    @Column(name = "id_produit")
    private Long idProduit;

    @Id
    @Column(name = "id_client")
    private Long idClient;

    @Column(name = "date_achat", nullable = false, length = 50)
    private String dateAchat;

    @Column(name = "heure_achat", nullable = false, length = 50)
    private String heureAchat;

    @ManyToOne
    @JoinColumn(name = "id_produit", insertable = false, updatable = false)
    private Produit produit;

    @ManyToOne
    @JoinColumn(name = "id_client", insertable = false, updatable = false)
    private Client client;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Vente vente = (Vente) o;
        return getIdProduit() != null && Objects.equals(getIdProduit(), vente.getIdProduit())
                && getIdClient() != null && Objects.equals(getIdClient(), vente.getIdClient());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(idProduit, idClient);
    }
}
