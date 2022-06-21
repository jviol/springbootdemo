package jviol.springbootdemo.rest;

import jviol.springbootdemo.entities.Baby;
import jviol.springbootdemo.entities.Meal;
import jviol.springbootdemo.entities.Supplement;
import jviol.springbootdemo.exception.BabyNotFoundException;
import jviol.springbootdemo.repositories.BabyRepository;
import jviol.springbootdemo.repositories.MealRepository;
import jviol.springbootdemo.repositories.SupplementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meals")
public class MealController {

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private SupplementRepository supplementRepository;

    @Autowired
    private BabyRepository babyRepository;

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
    public Meal create(@RequestBody Meal.Dto mealDto) {
        Baby baby = babyRepository.findByName(mealDto.babyName())
                .orElseThrow(() -> new BabyNotFoundException("No baby with name=\"" + mealDto.babyName() + "\""));
        List<Supplement> supplements = mealDto.supplements().stream()
                .map(supplementDto -> {
                    Supplement supplement = new Supplement();
                    supplement.setName(supplementDto.name());
                    supplement.setAmount(supplementDto.amount());
                    supplement.setUnit(supplementDto.unit());
                    return supplementRepository.save(supplement);
                })
                .toList();
        Meal meal = new Meal();
        meal.setBaby(baby);
        meal.setFeedingTime(mealDto.feedingTime());
        meal.setType(mealDto.type());
        meal.setMilliliters(meal.getMilliliters());
        meal.setSupplements(supplements);
        return mealRepository.save(meal);
    }



}
