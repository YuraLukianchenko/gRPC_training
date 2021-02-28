package com.lukianchenko;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

public class ServerApp {

  public static void main(String[] args) throws InterruptedException, IOException {

//   //< This code for simple request>
//    Server server = ServerBuilder
//        .forPort(8081)
//        .addService(new GreetingServiceImpl())
//        .build();
//    server.start();
//
//    System.out.println("server started");
//
//    server.awaitTermination();

//    //<This code for streaming>
    Server streamingServer = ServerBuilder
        .forPort(8082)
        .addService(new GreetingStreamingService())
        .build();

    streamingServer.start();

    System.out.println("streaming server has started");

    streamingServer.awaitTermination();
  }
}
