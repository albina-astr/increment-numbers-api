package api.controller;

import api.model.IncrementNumbersResponse;
import api.model.IncrementNumbersDto;
import api.service.NumbersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/numbers")
public class Controller {

    @Autowired
    private NumbersService service;

    @RequestMapping("/")
    public String hello() {
        return "hello there";
    }

    @PostMapping("/increment")
    @ResponseBody
    public IncrementNumbersResponse incrementNumbers(@RequestBody IncrementNumbersDto dto) {
        return IncrementNumbersResponse.builder()
                .response(service.incrementNumbersInString(dto.getRequest()))
                .build();
    }

}
