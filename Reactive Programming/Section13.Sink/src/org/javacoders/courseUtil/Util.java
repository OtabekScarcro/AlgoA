package org.javacoders.courseUtil;

import java.util.function.Consumer;

import org.reactivestreams.Subscriber;

import com.github.javafaker.Faker;

public class Util {
	
	public static final Faker FAKER = Faker.instance();
	
	public static Consumer<Object> onNext(){
		return o -> System.out.println("Received: " + o);
	}
	
	public static Consumer<Throwable> onError(){
		return err -> System.out.println("ERROR: " + err.getMessage());
	}
	
	public static Runnable onComplete(){
		return () -> System.out.println("Completed!");
	}
	
	public static Faker faker() {
		return FAKER;
	}
	
	public static void sleepSeconds(int seconds) {
		sleepMillis(seconds * 1000);
	}
	
	public static void sleepMillis(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static Subscriber<Object> subscriber(){
		return new DefaultSubscriber();
	}
	
	public static Subscriber<Object> subscriber(String name){
		return new DefaultSubscriber(name);
	}
	
}





















