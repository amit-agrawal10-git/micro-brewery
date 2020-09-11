package spring.micro.brewery.jackson;

import spring.micro.brewery.web.model.BeerDto;
import spring.micro.brewery.web.model.BeerStyleEnum;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class BaseTest {

    BeerDto getDto(){
        return BeerDto.builder().beerName("KKK")
                .beerStyle(BeerStyleEnum.PILSNER)
                .upc(322L)
                .price(new BigDecimal("235"))
                .createdDate(OffsetDateTime.now())
                .lastModifiedDate(OffsetDateTime.now())
                .minOnHand(336)
                .quantityToBrew(51)
                .build();
    }
}
