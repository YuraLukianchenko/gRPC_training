package com.lukianchenko;

import com.lukianchenko.grpc.Greating.HelloRequest;
import com.lukianchenko.grpc.Greating.HelloResponse;
import com.lukianchenko.grpc.GreetingServiceGrpc;
import com.lukianchenko.grpc.GreetingStreamServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.Iterator;

public class Client {

  public static void main(String[] args) {

//    ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8081")
//        .usePlaintext().build();
//
//    GreetingServiceGrpc.GreetingServiceBlockingStub stub =
//        GreetingServiceGrpc.newBlockingStub(channel);
//
//    HelloRequest request = HelloRequest.newBuilder()
//        .setName("Yura")
//        .build();
//
//    HelloResponse response = stub.greeting(request);
//
//    System.out.println(response);
//
//    channel.shutdownNow();


//    //<This code for streaming>
    ManagedChannel streamChannel = ManagedChannelBuilder.forTarget("localhost:8082")
        .usePlaintext().build();

    GreetingStreamServiceGrpc.GreetingStreamServiceBlockingStub streamStub =
        GreetingStreamServiceGrpc.newBlockingStub(streamChannel);

    HelloRequest streamRequest = HelloRequest.newBuilder()
        .setName("Yura")
        .build();

    Iterator<HelloResponse> streamResponse = streamStub.greetingStream(streamRequest);

    while (streamResponse.hasNext())
      System.out.println(streamResponse.next());


    streamChannel.shutdownNow();
  }

}
