package spring.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.restapi.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
