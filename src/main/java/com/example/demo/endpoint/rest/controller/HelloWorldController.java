package com.example.demo.endpoint.rest.controller;

import com.example.demo.mail.Email;
import com.example.demo.mail.Mailer;
import com.example.demo.service.HelloWorldService;
import jakarta.mail.internet.InternetAddress;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HelloWorldController {
  private final HelloWorldService service;
  private final Mailer mailer;

  @GetMapping("/helloo")
  public String hellooWorld(@RequestParam String name) {
    return service.uploadHelloWorldMessage(name);
  }

  @GetMapping("/hello")
  @SneakyThrows
  public String helloWorld(@RequestParam String to) {
    var email =
        new Email(
            new InternetAddress(to), List.of(), List.of(), "Hello world", "... world!", List.of());

    mailer.accept(email);
    return "... world!";
  }
}
