package spring.micro.brewery.service;

import org.springframework.stereotype.Service;
import spring.micro.brewery.web.model.BeerDto;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                //.beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDto saveBeer(BeerDto beerDto) {
        return BeerDto.builder().id(UUID.randomUUID())
                .build();
    }

    @Override
    public void deleteBeerById(UUID beerId) {

    }

    @Override
    public void updateBeer(UUID uuid, BeerDto beerDto) {

    }
}
