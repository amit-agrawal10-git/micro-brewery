package spring.micro.brewery.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import spring.micro.brewery.domain.Beer;
import spring.micro.brewery.mapper.BeerMapper;
import spring.micro.brewery.repositories.BeerRepository;
import spring.micro.brewery.web.model.BeerDto;
import spring.micro.brewery.web.model.BeerStyleEnum;

import java.util.UUID;

@Service
@AllArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public BeerDto getBeerById(UUID beerId) {
        return beerMapper.beerToBeerDto(
                beerRepository.findById(beerId).orElseThrow(NotFoundException::new)
        );
    }

    @Override
    public BeerDto saveBeer(BeerDto beerDto) {
        return
             beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
    }

    @Override
    public void deleteBeerById(UUID beerId) {
        Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);
        beerRepository.delete(beer);
    }

    @Override
    public BeerDto updateBeer(UUID uuid, BeerDto beerDto) {
        Beer beer = beerRepository.findById(uuid).orElseThrow(NotFoundException::new);
        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle().toString());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());

        return beerMapper.beerToBeerDto(beerRepository.save(beer));

    }
}
