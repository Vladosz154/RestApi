package spring.restapi.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import spring.restapi.model.Car;
import spring.restapi.repository.CarRepository;

import java.util.List;

@RestController
@Tag(name = "main_methods")
public class MainController {

    private final CarRepository carRepository;

    public MainController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Operation(
            summary = "Кладет новый автомобиль в базу.",
            description = "Собирает и сохраняет сущность в базу."
    )

    @PostMapping("/api/add")
    public void addCar(@RequestBody Car car) {
        carRepository.save(car);
    }

    @Operation(
            summary = "Получает все автомобили из базы данных.",
            description = "Возвращает список всех машин, сохранённых в базе."
    )

    @GetMapping("/api/all")
    public List<Car> allCars() {
        return carRepository.findAll();
    }

    @GetMapping("/api")
    public Car getCar(@RequestParam Long id) {
        return carRepository.findById(id).orElseThrow();
    }

    @DeleteMapping("/api")
    public void deleteCar(@RequestParam Long id) {
        carRepository.deleteById(id);
    }

    @PutMapping("/api/add")
    public String updateCar(@RequestBody Car car) {
        if (!carRepository.existsById(car.getId())) {
            return "No car found";
        }
        return carRepository.save(car).toString();
    }
}
