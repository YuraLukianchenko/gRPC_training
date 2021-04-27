package com.lukianchenko;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

public class ServerApp {

  public static void main(String[] args) throws InterruptedException, IOException {

    Server streamingServer = ServerBuilder
        .forPort(8082)
        .addService(new GreetingStreamingService())
        .build();

    streamingServer.start();

    System.out.println("streaming server has started");

    streamingServer.awaitTermination();
  }
}
