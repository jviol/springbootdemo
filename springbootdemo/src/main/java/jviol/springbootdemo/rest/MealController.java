package jviol.springbootdemo.rest;

import jviol.springbootdemo.entities.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/meals")
public class MealController {

    @Autowired
    private MealRepository mealRepository;

    @GetMapping
    public Iterable<Meal> findAll() {
        return mealRepository.findAll();
    }

    @GetMapping("/{id}")
    public Meal findOne(@PathVariable Long id) {
        return mealRepository.findById(id)
                .orElseThrow();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Meal create(@RequestBody Meal meal) {
        return mealRepository.save(meal);
    }

}
