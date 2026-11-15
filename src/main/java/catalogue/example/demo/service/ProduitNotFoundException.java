package catalogue.example.demo.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProduitNotFoundException extends RuntimeException {

  public ProduitNotFoundException(String id) {
    super("Produit introuvable : " + id);
  }
}