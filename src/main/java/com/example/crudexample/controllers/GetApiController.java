package com.example.crudexample.controllers;

import com.example.crudexample.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

//    ex) http://localhost:8080/api/get/name
    @GetMapping("/{name}")
    public String pathVariable(@PathVariable String name) {
        System.out.println("PathVariable: " + name);
        return name;
    }

//    ex) http://localhost:8080/api/get/param?name=name&pass=pass
    @GetMapping("/param1")
    public String queryParam1(@RequestParam Map<String, String> queryParam) {

        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach(entry -> {
            System.out.println("key: " + entry.getKey());
            System.out.println("value: " + entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
        });

        return sb.toString();
    }

    @GetMapping("/param2")
    public String queryParam2(@RequestParam String name, @RequestParam String pass) {

        System.out.println(name);
        System.out.println(pass);

        return name + " " + pass;
    }

    @GetMapping("/param3")
    public String queryParam3(
            UserRequest userRequest
    ) {
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getPass());
        return userRequest.toString();
    }
}
