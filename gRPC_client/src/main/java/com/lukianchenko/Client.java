package com.lukianchenko;

import com.lukianchenko.grpc.Greating.HelloRequest;
import com.lukianchenko.grpc.Greating.HelloResponse;
import com.lukianchenko.grpc.GreetingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Client {

  public static void main(String[] args) {
    ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8081")
        .usePlaintext().build();

    GreetingServiceGrpc.GreetingServiceBlockingStub stub =
        GreetingServiceGrpc.newBlockingStub(channel);

    HelloRequest request = HelloRequest.newBuilder()
        .setName("Yura")
        .build();

    HelloResponse response = stub.greeting(request);

    System.out.println(response);

    channel.shutdownNow();
  }

}
