package com.lukianchenko;

import com.lukianchenko.grpc.Greating;
import com.lukianchenko.grpc.Greating.HelloResponse;
import com.lukianchenko.grpc.GreetingServiceGrpc;
import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void greeting(Greating.HelloRequest request,
                         StreamObserver<Greating.HelloResponse> responseObserver) {
        System.out.println(request);
        HelloResponse response = HelloResponse.newBuilder()
            .setGreeting("hello from server, " + request.getName()).build();

        responseObserver.onNext(response);

        responseObserver.onCompleted();
    }
}
