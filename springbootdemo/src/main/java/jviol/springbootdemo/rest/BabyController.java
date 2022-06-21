package jviol.springbootdemo.rest;

import jviol.springbootdemo.repositories.BabyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/babies")
public class BabyController {
    @Autowired
    private BabyRepository babyRepository;

}
