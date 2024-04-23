package com.workintech.s17d2.rest;

import com.workintech.s17d2.model.Developer;
import com.workintech.s17d2.model.DeveloperFactory;
import com.workintech.s17d2.model.Experience;
import com.workintech.s17d2.tax.Taxable;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/developers")
public class DeveloperController {
    public Map<Integer, Developer> developers ;
    private Taxable taxable;

    @Autowired
    public DeveloperController(Taxable taxable) {
        this.taxable = taxable;
    }

    @PostConstruct
    public void init() {
        this.developers = new HashMap<>();

        Developer developer = DeveloperFactory.create(1, "John Doe", 1000.0, Experience.JUNIOR);
        developers.put(developer.getId(), developer);

    }

    //Bir component baska bir componentin icine enjekte edilebilir

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Developer create(@RequestBody Developer developer) {
        DeveloperFactory.create(developer.getId(), developer.getName(), developer.getSalary(), developer.getExperience());
        return developer;
    }

    @GetMapping
    public List<Developer> getAll() {

        return developers.values().stream().toList();

    }

    @GetMapping("/{id}")
    public Developer getById(@PathVariable int id) {
        return developers.get(id);
    }

    @PutMapping("/{id}")
    public Developer update(@PathVariable int id, @RequestBody Developer developer) {
        developers.put(id, developer);
        return developers.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        developers.remove(id);
    }

}
