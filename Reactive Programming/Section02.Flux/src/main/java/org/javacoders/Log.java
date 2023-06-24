package org.javacoders;

import org.javacoders.courseUtil.Util;

import reactor.core.publisher.Flux;

public class Log {

	public static void main(String[] args) {
		
		
		// log() method will show info about
		// what is going on here
		Flux.range(1, 10)
			.log()
			.map(e -> Util.faker().name().fullName())
//			.log()
			.subscribe(Util.onNext());
		
	}
	
}
