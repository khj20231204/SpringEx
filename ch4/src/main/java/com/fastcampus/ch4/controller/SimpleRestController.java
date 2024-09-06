package com.fastcampus.ch4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.fastcampus.ch4.domain.Person;

@Controller
public class SimpleRestController {

	@GetMapping("/ajax")
    public String ajax() {
        return "ajax";
    }

    @PostMapping("/send")
    @ResponseBody
    public Person test(@RequestBody Person p) {
        System.out.println("p = " + p);
        p.setName("ABC");
        p.setAge(p.getAge() + 10);

        return p;
    }
}
