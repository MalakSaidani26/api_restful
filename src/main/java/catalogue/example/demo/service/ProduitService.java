package catalogue.example.demo.service;

import catalogue.example.demo.model.Produit;
import catalogue.example.demo.repository.ProduitRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProduitService {

  private final ProduitRepository repo;

  public ProduitService(ProduitRepository repo) {
    this.repo = repo;
  }

  public List<Produit> lister() {
    return repo.findAll();
  }

  public Produit obtenir(String id) {
    return repo.findById(id)
        .orElseThrow(() -> new ProduitNotFoundException(id));
  }

  public Produit creer(Produit p) {
    p.setId(null);              // l'id est généré par MongoDB
    return repo.save(p);
  }

  public Produit modifier(String id, Produit p) {
    Produit existant = obtenir(id);   // 404 si absent
    existant.setNom(p.getNom());
    existant.setPrix(p.getPrix());
    existant.setEnStock(p.isEnStock());
    return repo.save(existant);
  }

  public void supprimer(String id) {
    repo.delete(obtenir(id));         // 404 si absent
  }
}