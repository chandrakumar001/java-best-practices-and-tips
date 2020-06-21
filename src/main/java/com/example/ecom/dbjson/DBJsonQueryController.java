package com.example.ecom.dbjson;

import com.example.ecom.dto.UserviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DBJsonQueryController {

    @Autowired
    DBJsonQueryService dbJsonQueryService;

    @GetMapping("/")
    public List<UserviewDTO> getDemos(
            @Valid UserViewSearch userViewSearch,
            @RequestParam("size") int i) {

        return dbJsonQueryService.getDemos(userViewSearch, i);
    }
}
