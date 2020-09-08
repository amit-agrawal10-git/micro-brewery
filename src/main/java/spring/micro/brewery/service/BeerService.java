package spring.micro.brewery.service;

import spring.micro.brewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    public BeerDto getBeerById(UUID beerId);
    public void deleteBeerById(UUID beerId);
    public BeerDto saveBeer(BeerDto beerDto);
    public void updateBeer(UUID uuid,BeerDto beerDto);
}
