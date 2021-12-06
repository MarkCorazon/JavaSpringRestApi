package com.markcorazon.animals.repositories;

import com.markcorazon.animals.exceptions.DataNotFoundException;
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
@Transactional
public class OwnerRepository {
    @PersistenceContext(unitName="TheUnit")
    private EntityManager entityManager;

    public List<Owner> getOwners() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Owner> query = cb.createQuery(Owner.class);
        return entityManager.createQuery(query.select(query.from(Owner.class))).getResultList();
    }

    public Owner getOwner(Long id) {
        Owner owner = entityManager.find(Owner.class, id);
        if(owner == null) throw new DataNotFoundException("Owners", id);
        return owner;
    }

    public Owner storeOwner(Owner owner) {
        entityManager.persist(owner);
        return owner;
    }

    public void updateOwner(Owner owner) {
        Owner entityOwner = entityManager.find(Owner.class, owner.getId());
        entityOwner.setName(owner.getName());
        entityOwner.setAge(owner.getAge());
    }

    public void removeOwner(Long id) {
        entityManager.remove(getOwner(id));
    }
}
