package com.example.ecom;

import com.example.ecom.dto.UserviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DBJsonQueryController {

    @Autowired
    DBJsonQueryService dbJsonQueryService;

    @GetMapping("/")
    public List<UserviewDTO> getDemos(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "bookName", required = false) String bookName,
            @RequestParam("size") int i) {

        return dbJsonQueryService.getDemos(name, email, bookName, i);
    }
}
