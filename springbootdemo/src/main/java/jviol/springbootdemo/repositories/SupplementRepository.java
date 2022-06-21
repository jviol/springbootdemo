package jviol.springbootdemo.repositories;

import jviol.springbootdemo.entities.Supplement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface SupplementRepository extends JpaRepository<Supplement, Long> {
    Collection<Supplement> findByMeal_Id(@Param("meal_id") Long mealId);
}
