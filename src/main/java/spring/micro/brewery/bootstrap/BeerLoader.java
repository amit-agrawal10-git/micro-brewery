package spring.micro.brewery.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.micro.brewery.domain.Beer;
import spring.micro.brewery.repositories.BeerRepository;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    @Autowired
    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects(){
        if(beerRepository.count()==0){
            beerRepository.save(Beer.builder().beerName("King Fisher")
            .beerStyle("Draught")
            .quantityToBrew(200)
            .minOnHand(12)
            .upc(52352623L)
                    .price(new BigDecimal("34.2")).build());

            beerRepository.save(Beer.builder().beerName("Tuborg")
                    .beerStyle("Hard")
                    .quantityToBrew(300)
                    .minOnHand(121)
                    .upc(523521323L)
                    .price(new BigDecimal("14.2")).build());

        }
    }
}
