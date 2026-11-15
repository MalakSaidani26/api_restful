package catalogue.example.demo.repository;

import  catalogue.example.demo.model.Produit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProduitRepository
    extends MongoRepository<Produit, String> {
}