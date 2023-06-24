package org.javacoders.sec01;

import reactor.core.publisher.Mono;

public class Lec02MonoJust {
	public static void main(String[] args) {
		
		// This is a publisher
		// Nothing will happen until you subscribe to that
		Mono<Integer> mono = Mono.just(1);
		
		System.out.println(mono);
		
		// here we are subscribing, means,
		// we are consuming from Publisher
		mono.subscribe(i -> System.out.println("Received:" +  i));
		
		
		
	}
}
