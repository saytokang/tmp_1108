package com.example.demogw.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/debug")
public class ConfigController {
    
    @PostMapping("/{flag}")
    public ResponseEntity<?> debug(@PathVariable String flag) {
        String propName = "javax.net.debug";
        log.info("before: {}", System.getProperty(propName));

        boolean isDebugOn = flag != null && "on".equalsIgnoreCase(flag);
        String value = isDebugOn ? "ssl" : "";
        System.setProperty(propName, value);
        log.info("after: {}", System.getProperty(propName));

        return ResponseEntity.ok().body(isDebugOn);
    }

}
