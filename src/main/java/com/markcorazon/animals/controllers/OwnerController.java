package com.markcorazon.animals.controllers;

import com.markcorazon.animals.dto.OwnerDto;
import com.markcorazon.animals.models.Owner;
import com.markcorazon.animals.services.OwnerService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OwnerDto>> getOwners() {
        return ResponseEntity.ok(ownerService.getOwners());
    }

    @GetMapping("/{owner}")
    public @ResponseBody
    ResponseEntity<OwnerDto> get(@PathVariable(value = "owner") final Long ownerId) {
        return ResponseEntity.ok(ownerService.getOwner(ownerId));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> post(@Valid @RequestBody OwnerDto ownerDto) {
        Owner createdOwner = ownerService.storeOwner(ownerDto);
        return ResponseEntity.created(URI.create(String.format("/owners/%d", createdOwner.getId()))).build();
    }

    @PutMapping("/{owner}")
    @ResponseBody
    public ResponseEntity<Void> put(@PathVariable("owner") final Long ownerId, @Valid @RequestBody OwnerDto ownerDto) {
        ownerService.updateOwner(ownerDto, ownerId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{owner}")
    @ResponseBody
    public ResponseEntity<String> delete(@PathVariable("owner") final Long ownerId) {
        ownerService.removeOwner(ownerId);
        return ResponseEntity.noContent().build();
    }
}
