package jviol.springbootdemo.rest;

import jviol.springbootdemo.entities.Meal;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MealRepository extends PagingAndSortingRepository<Meal, Long> {
    List<Meal> findByType(@Param("type") String type);
}
