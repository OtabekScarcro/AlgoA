package org.javacoders;

import org.javacoders.assignment.SlackMember;
import org.javacoders.assignment.SlackRoom;
import org.javacoders.courseUtil.Util;

public class Lec07SlackDemo {
	
	public static void main(String[] args) {
		
		SlackRoom slackRoom = new SlackRoom("reactor");
		
		SlackMember sam = new SlackMember("Sam");
		SlackMember jake = new SlackMember("Jake");
		SlackMember john = new SlackMember("John");
		
		slackRoom.joinRoom(sam);
		slackRoom.joinRoom(jake);
		
		sam.says("hello");
		Util.sleepSeconds(4);
		
		jake.says("hey!!!");
		jake.says("I simply want to say hi...");
		Util.sleepSeconds(4);
		
		
		slackRoom.joinRoom(john);
		john.says("Hey guys ...Glad to be here.... ");
		
		
		
		
		
		
	}
	
	
	

}
