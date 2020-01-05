package ch.bfh.ti.cookingWebapp.persistence.repository;

import ch.bfh.ti.cookingWebapp.persistence.model.RecipeIngredientCombination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredientCombination, Long> {
}
