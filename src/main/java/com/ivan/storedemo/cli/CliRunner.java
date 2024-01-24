package com.ivan.storedemo.cli;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CliRunner implements CommandLineRunner {

  @Override
  public void run(String... args) throws Exception {
    
    System.out.println("Hello from CLI");

  }

}
