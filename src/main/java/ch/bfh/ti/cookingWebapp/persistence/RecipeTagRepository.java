package ch.bfh.ti.cookingWebapp.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeTagRepository extends CrudRepository<RecipeTagCombination, Long> {
}
