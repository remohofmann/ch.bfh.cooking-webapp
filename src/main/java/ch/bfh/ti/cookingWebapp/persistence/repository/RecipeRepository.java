package ch.bfh.ti.cookingWebapp.persistence.repository;

import ch.bfh.ti.cookingWebapp.persistence.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
