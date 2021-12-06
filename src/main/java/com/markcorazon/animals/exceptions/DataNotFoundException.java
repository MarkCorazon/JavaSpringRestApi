package com.markcorazon.animals.exceptions;

public class DataNotFoundException extends RuntimeException {
    private String repository;
    private Long index;

    public DataNotFoundException(String repository, Long index) {
        super();
        this.repository = repository;
        this.index = index;
    }

    public DataNotFoundException(String repository) {
        super();
        this.repository = repository;
        //this.index = -1;
    }

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }
}
