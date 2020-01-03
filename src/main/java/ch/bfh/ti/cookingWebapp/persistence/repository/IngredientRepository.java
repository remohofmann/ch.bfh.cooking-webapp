package ch.bfh.ti.cookingWebapp.persistence.repository;

import ch.bfh.ti.cookingWebapp.persistence.model.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
