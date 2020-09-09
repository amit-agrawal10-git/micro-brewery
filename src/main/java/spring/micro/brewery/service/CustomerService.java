package spring.micro.brewery.service;

import spring.micro.brewery.web.model.BeerDto;
import spring.micro.brewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    public CustomerDto getCustomerById(UUID customerId);
    public void deleteById(UUID beerId);
    public CustomerDto save(CustomerDto beerDto);
    public void update(UUID uuid,CustomerDto beerDto);
}
