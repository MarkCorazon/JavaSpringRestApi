package com.markcorazon.animals.transformers;

import com.markcorazon.animals.dto.AnimalDto;
import com.markcorazon.animals.models.Animal;

public class AnimalTransformer {

    public static AnimalDto toDto(Animal animal) {
        AnimalDto animalDto = new AnimalDto();
        animalDto.setId(animal.getId());
        animalDto.setOwnerId(animal.getOwner().getId());
        animalDto.setName(animal.getName());
        animalDto.setType(animal.getType());
        animalDto.setAge(animal.getAge());
        return animalDto;
    }

    public static Animal toAnimal(AnimalDto animalDto) {
        return new Animal(animalDto.getName(), animalDto.getType(), animalDto.getAge());
    }
}
