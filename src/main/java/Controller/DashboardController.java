package Controller;

import Model.*;
import io.swagger.models.Path;
import org.json.simple.JSONObject;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@SpringBootApplication
@EnableSwagger2
@RestController
@RequestMapping("/api")
public class DashboardController {
//this class has all request that can be done over the application or browser
//i use ik = identification key instead of id, they serve the same purpose
//this comments will split the class into sections, guiding you which request belongs where

    @GetMapping("/")
    String home() {
        return "welcome to GauBus API";
    }

//Bus Stop section
    @GetMapping("/BusStops/all")
    JSONObject allBusStops() {
        BusStop_interface iBusStop = new BusStop();
        return iBusStop.allBusStops();
    }
//Bus Stop section ends


//Trips Section
    //all trips for user id key
    @GetMapping("/trips/all/{userIk}")
    JSONObject allTrips(@PathVariable int userIK) {
        tripManager_interface iTripManager = new tripManager();
        return iTripManager.viewTripByUser(userIK);
    }

    //get a trip by its id
    @GetMapping("/trips/{ik}")
    JSONObject singleTrip(@PathVariable int ik) {
        tripManager_interface iTripManager = new tripManager();
        return iTripManager.viewTrip(ik);
    }

    //create a new trip
    @PostMapping("/trips/new/{userIK}")
    JSONObject newTrip(@RequestBody JSONObject newTrip, @PathVariable int userIK) {
        tripManager_interface iTripManager = new tripManager();
        return iTripManager.bookTrip(newTrip,userIK);
    }

    //reschedule trip by its id
    @PostMapping("/trips/reschedule/{ik}")
    JSONObject rescheduleTrip(@RequestBody JSONObject trip, @PathVariable int ik) {
        tripManager_interface iTripManager = new tripManager();
        return iTripManager.rescheduleTrip(trip,ik);
    }

    //delete a trip using its id
    @DeleteMapping("/trips/{ik}")
    JSONObject cancelTrip(@PathVariable int ik) {
        tripManager_interface iTripManager = new tripManager();
        return iTripManager.cancelTrip(ik);
    }
//Trip section ends


//swagger ui configurations
    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("GauBus API")
                .description("API Documentation for GauBus app")
                .license("MadeByGiants 0.0.1")
                .licenseUrl("MadeByGiants.com")
                .termsOfServiceUrl("free use")
                .version("1.0.0")
                .contact(new Contact("Nceba Sobikwa", "https://madebygiants.com", "info@madebygiants.com"))
                .build();
    }

    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("Controller"))
                .build()
                .apiInfo(this.apiInfo());
    }
}