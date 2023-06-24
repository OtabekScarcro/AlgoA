package org.javacoders;

import org.javacoders.courseUtil.Util;

import reactor.core.publisher.Flux;

public class Lec07FluxGenerateCounter {
	
	public static void main(String[] args) {
		
		Flux.generate(
			() -> 1,
			(counter, sink) -> {
				String country = Util.faker().country().name();
				sink.next(country);
				if(counter >= 10 || country.toLowerCase().equals("canada")) {
					sink.complete();
				}
				return counter+1;
			}
		)
//		.take(N) // if you want to get first N item
		.subscribe(Util.subscriber());
		
	}

}
