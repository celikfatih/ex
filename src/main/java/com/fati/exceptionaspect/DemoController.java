package com.fati.exceptionaspect;

import com.fati.exceptionaspect.annotation.CustomizedException;
import com.fati.exceptionaspect.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * author @ fati
 * created @ 25.03.2021
 */

@RestController
@RequestMapping("demo")
@RequiredArgsConstructor
@CustomizedException
public class DemoController {

    private final DemoService demoService;

    @GetMapping("/test/{i}")
    public Object get(@PathVariable("i") Integer i) {
        return demoService.test(i);
    }

    @GetMapping("without-custom")
    public ResponseEntity<String> withoutCustomError() {
        return ResponseEntity.ok().body("Without Custom Error");
    }
}
