package spring.micro.brewery.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.micro.brewery.domain.Beer;
import spring.micro.brewery.repositories.BeerRepository;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    public final static String BEER1_UPC = "032332";
    public final static String BEER2_UPC = "032333";
    public final static String BEER3_UPC = "032334";

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
                    .upc(BEER1_UPC)
                    .price(new BigDecimal("34.2")).build());

            beerRepository.save(Beer.builder().beerName("Tuborg")
                    .beerStyle("Hard")
                    .quantityToBrew(300)
                    .minOnHand(121)
                    .upc(BEER2_UPC)
                    .price(new BigDecimal("14.2")).build());

            beerRepository.save(Beer.builder().beerName("BIRA")
                    .beerStyle("Hard S")
                    .quantityToBrew(300)
                    .minOnHand(122)
                    .upc(BEER3_UPC)
                    .price(new BigDecimal("14.2")).build());

        }
    }
}
