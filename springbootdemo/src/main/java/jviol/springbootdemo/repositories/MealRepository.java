package jviol.springbootdemo.repositories;

import jviol.springbootdemo.entities.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Long> {
    List<Meal> findByType(@Param("type") String type);
}
