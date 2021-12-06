package com.markcorazon.animals.repositories;

import com.markcorazon.animals.exceptions.DataNotFoundException;
import com.markcorazon.animals.models.Animal;
import com.markcorazon.animals.models.Owner;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;

@Repository
public class AnimalRepository {
    @PersistenceContext(unitName="TheUnit")
    private EntityManager entityManager;

    public List<Animal> getAnimals() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Animal> query = cb.createQuery(Animal.class);
        return entityManager.createQuery(query.select(query.from(Animal.class))).getResultList();
    }

    public Animal getAnimal(Long id) {
        Animal animal = entityManager.find(Animal.class, id);
        if(animal == null) throw new DataNotFoundException("Animals", id);
        return animal;
    }

    @Transactional
    public Animal storeAnimal(Animal animal) {
        entityManager.persist(animal);
        return animal;
    }

    @Transactional
    public void updateAnimal(Animal animal) {
        Animal entityAnimal = entityManager.find(Animal.class, animal.getId());
        entityAnimal.setOwner(animal.getOwner());
        entityAnimal.setName(animal.getName());
        entityAnimal.setAge(animal.getAge());
        entityAnimal.setType(animal.getType());
    }

    @Transactional
    public void removeAnimal(Long id) {
        entityManager.remove(getAnimal(id));
    }
}
