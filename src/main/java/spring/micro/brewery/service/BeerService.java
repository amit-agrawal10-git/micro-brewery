package spring.micro.brewery.service;

import spring.micro.brewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    public BeerDto getBeerById(UUID beerId);
}
