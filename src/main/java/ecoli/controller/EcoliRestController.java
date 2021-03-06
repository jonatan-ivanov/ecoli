package ecoli.controller;

import ecoli.exception.ThrowableDetails;
import ecoli.model.EchoResponse;
import ecoli.model.LocationResponse;
import ecoli.service.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author Jonatan Ivanov
 */
@Slf4j
@RestController
@RequestMapping("/rs/v1")
public class EcoliRestController {
    @Autowired private LocationService locationService;

    @RequestMapping(path = "/echo/{message}", method = GET)
    public EchoResponse echo(@PathVariable String message) {
        return new EchoResponse(message);
    }

    @RequestMapping(path = "/location", method = GET)
    public LocationResponse location(HttpServletRequest request) {
        return locationService.getLocation(request.getRemoteAddr());
    }

    @ExceptionHandler(Throwable.class)
    public ThrowableDetails error(Throwable throwable) {
        ThrowableDetails throwableDetails = new ThrowableDetails(throwable);
        log.error(throwableDetails.toString(), throwable);

        return throwableDetails;
    }
}
