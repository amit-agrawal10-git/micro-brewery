package spring.micro.brewery.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import spring.micro.brewery.domain.Beer;

import java.util.UUID;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
