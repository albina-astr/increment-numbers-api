package api.controller;

import api.model.IncrementNumberResponse;
import api.model.IncrementNumberDto;
import api.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class Controller {

    @Autowired
    private NumberService service;

    @RequestMapping("/")
    public String hello() {
        return "hello there";
    }

    @PostMapping("/numbers")
    @ResponseBody
    public IncrementNumberResponse incrementNumbers(@RequestBody IncrementNumberDto dto) {
        return IncrementNumberResponse.builder()
                .response(service.incrementNumbersInString(dto.getRequest()))
                .build();
    }

}
