package catalogue.example.demo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "produits")
public class Produit {

  @Id
  private String id;

  @NotBlank
  private String nom;

  @NotNull
  @Positive
  private Double prix;

  private boolean enStock;

  public String getId() { return id; }
  public void setId(String id) { this.id = id; }

  public String getNom() { return nom; }
  public void setNom(String nom) { this.nom = nom; }

  public Double getPrix() { return prix; }
  public void setPrix(Double prix) { this.prix = prix; }

  public boolean isEnStock() { return enStock; }
  public void setEnStock(boolean enStock) { this.enStock = enStock; }
}