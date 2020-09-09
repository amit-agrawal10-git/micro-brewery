package spring.micro.brewery.web.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.micro.brewery.service.BeerService;
import spring.micro.brewery.service.CustomerService;
import spring.micro.brewery.web.model.BeerDto;
import spring.micro.brewery.web.model.CustomerDto;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto> getBeer(@PathVariable("customerId") UUID customerId){

        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CustomerDto beerDto){
        CustomerDto newBeer = customerService.save(beerDto);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location","/api/v1/customer"+newBeer.getId());
        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handlePut(@PathVariable("beerId") UUID beerId,@RequestBody CustomerDto beerDto){
        customerService.update(beerId, beerDto);
    }

    @DeleteMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable("beerId") UUID beerId){
        customerService.deleteById(beerId);
    }


}
