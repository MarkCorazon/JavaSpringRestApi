package com.markcorazon.animals.transformers;

import com.markcorazon.animals.dto.OwnerDto;
import com.markcorazon.animals.models.Owner;

public class OwnerTransformer {

    public static OwnerDto toDto(Owner owner) {
        OwnerDto ownerDto = new OwnerDto();
        ownerDto.setId(owner.getId());
        ownerDto.setName(owner.getName());
        ownerDto.setAge(owner.getAge());
        return ownerDto;
    }

    public static Owner toOwner(OwnerDto owner) {
        return new Owner(owner.getName(), owner.getAge());
    }
}
