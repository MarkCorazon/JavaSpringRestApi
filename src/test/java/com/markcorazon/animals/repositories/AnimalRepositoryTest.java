package com.markcorazon.animals.repositories;

import com.markcorazon.animals.TestApplicationContext;
import com.markcorazon.animals.models.Animal;
import com.markcorazon.animals.models.Owner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestApplicationContext.class)
public class AnimalRepositoryTest {

    @Autowired
    private AnimalRepository animalRepository;

    @PersistenceContext(unitName="TheUnit")
    private EntityManager entityManager;

    @Test
    public void testStoreAnimal() {
        Animal animal = new Animal("Donbrand", "alternative", 23);
        Owner owner = entityManager.find(Owner.class, 1L);
        animal.setOwner(owner);

        animalRepository.storeAnimal(animal);

    }
}
