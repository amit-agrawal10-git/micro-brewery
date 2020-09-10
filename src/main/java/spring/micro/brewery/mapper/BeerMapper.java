package spring.micro.brewery.mapper;

import org.mapstruct.Mapper;
import spring.micro.brewery.domain.Beer;
import spring.micro.brewery.web.model.BeerDto;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beerDto);
}
