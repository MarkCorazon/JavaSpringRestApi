package com.markcorazon.animals.services;

import com.markcorazon.animals.dto.AnimalDto;
import com.markcorazon.animals.models.Animal;
import com.markcorazon.animals.models.Owner;
import com.markcorazon.animals.repositories.AnimalRepository;
import com.markcorazon.animals.repositories.OwnerRepository;
import com.markcorazon.animals.transformers.AnimalTransformer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalService {
    private final AnimalRepository data;
    private final ModelMapper modelMapper;
    private final OwnerRepository ownerRepository;

    public AnimalService(AnimalRepository data, OwnerRepository ownerRepository){
        this.data = data;
        this.modelMapper = new ModelMapper();
        this.ownerRepository = ownerRepository;
    }

    public List<AnimalDto> getAnimals(){
        final List<Animal> animals = data.getAnimals();
        return animals.stream().map(AnimalTransformer::toDto).collect(Collectors.toList());
    }

    public AnimalDto getAnimal(Long index) {
        return modelMapper.map(data.getAnimal(index), AnimalDto.class);
    }

    public Animal createAnimal(AnimalDto animal) {
        Owner owner = ownerRepository.getOwner(animal.getOwnerId());
        //Animal newAnimal = modelMapper.map(animal, Animal.class);
        Animal newAnimal = AnimalTransformer.toAnimal(animal);
        newAnimal.setOwner(owner);
        return data.storeAnimal(newAnimal);
    }

    public void updateAnimal(AnimalDto animal, Long id) {
        Owner owner = ownerRepository.getOwner(animal.getOwnerId());
        Animal editAnimal = AnimalTransformer.toAnimal(animal);
        editAnimal.setId(id);
        editAnimal.setOwner(owner);
        data.updateAnimal(editAnimal);
    }

    public void removeAnimal(Long id) {
        data.removeAnimal(id);
    }
}
