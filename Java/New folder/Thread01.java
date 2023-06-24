class Thread01
{
	public static void main(String[] args) 
	{
		Runnable runnable = () -> {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " running");
		};

		Thread thread1 = new Thread( runnable, "The Thread 1" );
		thread1.start();
		
		try{
		Thread.sleep(2000);

		}
		catch(InterruptedException e){
			
		}

		Thread thread2 = new Thread( runnable, "The Thread 2" );
		thread2.start();
        
		try{
		Thread.sleep(2000);

		}
		catch(InterruptedException e){
			
		}

		Thread thread3 = new Thread( runnable, "The Thread 3" );
		thread3.start();
	}
}
