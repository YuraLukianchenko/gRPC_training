package com.lukianchenko;

import com.lukianchenko.grpc.Greating;
import com.lukianchenko.grpc.Greating.HelloRequest;
import com.lukianchenko.grpc.Greating.HelloResponse;
import com.lukianchenko.grpc.GreetingServiceGrpc.GreetingServiceImplBase;
import com.lukianchenko.grpc.GreetingStreamServiceGrpc.GreetingStreamServiceImplBase;
import io.grpc.stub.StreamObserver;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GreetingStreamingService extends GreetingStreamServiceImplBase {

  @Override
  public void greetingStream(Greating.HelloRequest request,
      StreamObserver<HelloResponse> responseObserver) {

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");

    System.out.println(request);

    for (int i = 0; i < 1000; i++) {

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        System.out.println("thread was interrupted");
      }
      HelloResponse response = HelloResponse.newBuilder()
          .setGreeting("hello from server, " + request.getName()
              + formatter.format(new Date(System.currentTimeMillis()))).build();

      responseObserver.onNext(response);

    }

    responseObserver.onCompleted();
  }

}
