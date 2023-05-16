package br.com.cardapio.controller;

import br.com.cardapio.food.Food;
import br.com.cardapio.food.FoodRequestDTO;
import br.com.cardapio.food.FoodResponseDTO;
import br.com.cardapio.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @GetMapping
    public List<FoodResponseDTO> getAll() {
        List<FoodResponseDTO> foodList = repository.findAll().stream()
                .map(FoodResponseDTO::new).toList();
        return foodList;
    }

    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data) {
        Food response = new Food(data);
        repository.save(response);
    }
}
