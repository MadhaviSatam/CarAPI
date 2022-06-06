package com.mscar.car;

import com.mscar.car.exception.CarApiException;
import com.mscar.car.data.Car;
import com.mscar.car.repository.CarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CarControllerTests {
    @InjectMocks
    CarController carController;

    @Mock
    CarRepository carRepository;

    @Test
    public void testRetrieveCarDetails() {
        var car = createCarData();

        when(carRepository.findById(1L)).thenReturn(Optional.of(car));

        var result = carController.getCar(1L);

        assertEquals(20000, result.getNettPrice());
        assertEquals("Ford", result.getMake());
    }

    @Test
    public void testCreateCar() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        var car = createCarData();

        when(carRepository.save(any())).thenReturn(car);

        var result = carController.createCar(car);

        assertEquals(1000, result.getMileage());
    }

    @Test
    public void testUpdateCar() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        var car = createCarData();
        car.setMake("Ford1");

        when(carRepository.findById(1L)).thenReturn(Optional.of(car));
        when(carRepository.save(any())).thenReturn(car);

        var result = carController.updateCar(car, 1L);

        assertEquals("Ford1", result.getMake());
    }

    @Test
    public void testDeleteCar() {

        doNothing().when(carRepository).deleteById(1L);

        carController.deleteCar(1L);

        verify(carRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testRetrieveCarDetails_Exception() {

        when(carRepository.findById(2L)).thenThrow(new CarApiException(HttpStatus.NOT_FOUND.value()));

        CarApiException thrown = Assertions
                .assertThrows(CarApiException.class, () -> {
                    var result = carController.getCar(2L);
                }, "CarApiException error was expected");

        assertEquals(HttpStatus.NOT_FOUND.value(), thrown.getStatus());
    }

    @Test
    public void testDeleteCar_Exception() {

        doThrow(new CarApiException(HttpStatus.NOT_FOUND.value())).when(carRepository).deleteById(2L);

        CarApiException thrown = Assertions
                .assertThrows(CarApiException.class, () -> {
                    carController.deleteCar(2L);
                }, "CarApiException error was expected");

        assertEquals(HttpStatus.NOT_FOUND.value(), thrown.getStatus());
    }

    private Car createCarData()
    {
        return Car.builder()
                .make("Ford")
                .model("Ford fiesta")
                .version("1")
                .mileage(1000)
                .nettPrice(20000)
                .grossPrice(24000).build();
    }
}
