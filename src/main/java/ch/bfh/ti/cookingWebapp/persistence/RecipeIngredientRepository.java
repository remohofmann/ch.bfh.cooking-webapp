package ch.bfh.ti.cookingWebapp.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredientCombination, Long> {
}
