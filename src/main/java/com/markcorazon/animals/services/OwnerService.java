package com.markcorazon.animals.services;

import com.markcorazon.animals.dto.OwnerDto;
import com.markcorazon.animals.models.Owner;
import com.markcorazon.animals.repositories.OwnerRepository;
import com.markcorazon.animals.transformers.OwnerTransformer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerService {
    private final OwnerRepository data;

    public OwnerService(OwnerRepository data){
        this.data = data;
    }

    public List<OwnerDto> getOwners(){
        final List<Owner> owners = data.getOwners();
        return owners.stream().map(OwnerTransformer::toDto).collect(Collectors.toList());
    }

    public OwnerDto getOwner(Long id) {
        return OwnerTransformer.toDto(data.getOwner(id));
    }

    public Owner storeOwner(OwnerDto owner) {
        return data.storeOwner(OwnerTransformer.toOwner(owner));
    }

    public void updateOwner(OwnerDto owner, Long id) {
        Owner ownerToUpdate = OwnerTransformer.toOwner(owner);
        ownerToUpdate.setId(id);
        data.updateOwner(ownerToUpdate);
    }

    public void removeOwner(Long id) {
        data.removeOwner(id);
    }
}
