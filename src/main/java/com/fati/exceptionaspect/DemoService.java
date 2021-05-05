package com.fati.exceptionaspect;

import org.springframework.stereotype.Service;

/**
 * author @ fati
 * created @ 25.03.2021
 */

@Service
public class DemoService {

    public String test(Integer i) {
        if (i == 3) {
            return "Done";
        } else {
            throw new RuntimeException("1");
        }
    }
}
