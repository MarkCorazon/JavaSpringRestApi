package com.markcorazon.animals.repositories;

import com.markcorazon.animals.TestApplicationContext;
import com.markcorazon.animals.models.Owner;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestApplicationContext.class)
public class OwnerRepositoryTest {

    @Autowired
    private OwnerRepository ownerRepository;

    @PersistenceContext(unitName="TheUnit")
    private EntityManager entityManager;

    @Test
    public void testGetAllOwners() {
        Collection<Owner> owners = ownerRepository.getOwners();
        assertThat(owners).isNotEmpty();
    }

    @Test
    public void testGetOwner() {
        Owner owner = ownerRepository.getOwner(1L);
        assertThat(owner.getName()).isEqualTo("Greta");
    }

    @Test
    public void testStoreOwner() {
        Owner owner = new Owner("Brigitte", 62);
        ownerRepository.storeOwner(owner);
//        Owner newOwnerCheck = entityManager.find(Owner.class, 2L);
//        assertThat(newOwnerCheck.getName()).isEqualTo(owner.getName());
    }

//    @Test
//    public void testUpdateOwner() {
//
//    }
}
