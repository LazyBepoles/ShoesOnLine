package com.ppwq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class ShoesOnLineApplication {

  public static void main(String[] args) {
    SpringApplication.run(ShoesOnLineApplication.class, args);
  }
}
