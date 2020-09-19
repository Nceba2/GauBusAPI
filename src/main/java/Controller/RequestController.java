package Controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.*;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class RequestController {

    @GetMapping("/trips")
    String allTrips() {
        return "";
    }

    @PostMapping("/trips")
    <Employee>
    String newTrip(@RequestBody Employee trip) {
        return "";
    }

    @GetMapping("/trips/{id}")
    String singleTrip(@PathVariable Long id) {
        return "";
    }

//    @PutMapping("/employees/{id}")
//    String newTicket(@RequestBody Employee newEmployee, @PathVariable Long id) {
//        return "";
//    }

    @DeleteMapping("/employees/{id}")
    void cancelTrip(@PathVariable Long id) {
//        repository.deleteById(id);
    }
}