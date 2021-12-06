package com.markcorazon.animals.controllers;

import com.markcorazon.animals.dto.AnimalDto;
import com.markcorazon.animals.models.Animal;
import com.markcorazon.animals.services.AnimalService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {
    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AnimalDto>> getAnimals() {
        return ResponseEntity.ok(animalService.getAnimals());
    }

    @GetMapping("/{animal}")
    @ResponseBody
    public ResponseEntity<AnimalDto> get(@PathVariable("animal") final Long animalId) {
        return ResponseEntity.ok(animalService.getAnimal(animalId));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> post(@Valid @RequestBody AnimalDto animalDto) {
        Animal animal = animalService.createAnimal(animalDto);
        return ResponseEntity.created(URI.create(String.format("/animals/%d", animal.getId()))).build();
    }

    @PutMapping("/{animalId}")
    @ResponseBody
    public ResponseEntity<Void> put(@PathVariable("animalId") final Long animalId, @Valid @RequestBody AnimalDto animalDto) {
        animalService.updateAnimal(animalDto, animalId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{animalId}")
    @ResponseBody
    public ResponseEntity<Void> delete(@PathVariable("animalId") final Long animalId) {
        animalService.removeAnimal(animalId);
        return ResponseEntity.noContent().build();
    }
}
