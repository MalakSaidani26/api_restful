package catalogue.example.demo.controller;


import catalogue.example.demo.model.Produit;
import catalogue.example.demo.service.ProduitService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

  private final ProduitService service;

  public ProduitController(ProduitService service) {
    this.service = service;
  }

  @GetMapping
  public List<Produit> lister() {
    return service.lister();
  }

  @GetMapping("/{id}")
  public Produit obtenir(@PathVariable String id) {
    return service.obtenir(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Produit creer(@Valid @RequestBody Produit p) {
    return service.creer(p);
  }

  @PutMapping("/{id}")
  public Produit modifier(@PathVariable String id,
      @Valid @RequestBody Produit p) {
    return service.modifier(id, p);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void supprimer(@PathVariable String id) {
    service.supprimer(id);
  }
}