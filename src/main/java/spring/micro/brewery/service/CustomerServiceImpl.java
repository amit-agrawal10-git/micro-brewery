package spring.micro.brewery.service;

import org.springframework.stereotype.Service;
import spring.micro.brewery.web.model.BeerDto;
import spring.micro.brewery.web.model.CustomerDto;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID beerId) {
        return CustomerDto.builder().id(UUID.randomUUID())
                .name("Amit")
                .build();
    }

    @Override
    public void deleteById(UUID beerId) {

    }

    @Override
    public CustomerDto save(CustomerDto beerDto) {
        return CustomerDto.builder().id(UUID.randomUUID())
                .name("SSSS").build();
    }

    @Override
    public void update(UUID uuid, CustomerDto beerDto) {

    }
}
