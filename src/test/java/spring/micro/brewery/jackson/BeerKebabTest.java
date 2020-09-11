package spring.micro.brewery.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;
import spring.micro.brewery.web.model.BeerDto;

@ActiveProfiles("kebab")
@JsonTest
public class BeerKebabTest extends BaseTest{

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void testSerialize() throws JsonProcessingException {
        BeerDto beerDto = getDto();
        String s
                = objectMapper.writeValueAsString(beerDto);
        System.out.println(s);
    }

    @Test
    public void testDeserialize() throws JsonProcessingException {
        String s = "{\"id\":null,\"version\":null,\"created-date\":\"2020-09-11T11:45:15+0530\",\"last-modified-date\":\"2020-09-11T11:45:15+0530\",\"beer-name\":\"KKK\",\"beer-style\":\"PILSNER\",\"upc\":322,\"price\":235,\"min-on-hand\":336,\"quantity-to-brew\":51}";
        BeerDto beerDto = objectMapper.readValue(s,BeerDto.class);
        System.out.println(beerDto);
    }
}
