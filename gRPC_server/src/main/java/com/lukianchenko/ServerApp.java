package com.lukianchenko;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

public class ServerApp {

  public static void main(String[] args) throws InterruptedException, IOException {

    Server server = ServerBuilder
        .forPort(8081)
        .addService(new GreetingServiceImpl())
        .build();
    server.start();

    System.out.println("server started");

    server.awaitTermination();


  }
}
