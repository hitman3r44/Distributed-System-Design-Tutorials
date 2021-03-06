
public class SynchronizedCounter extends Thread
{
	private int count = 0;
	private int syncCount = 0;
	
	public void increment()
	{
		count ++;
	}
	
	public void decrement()
	{
		count --;
	}
	
	public int getCount()
	{
		return count;
	}
	
	public synchronized void synchIncrement()
	{
		syncCount ++;
	}
	
	public synchronized void synchDecrement()
	{
		syncCount --;
	}
	
	public synchronized int getSyncCount()
	{
		return syncCount;
	}
	
	public static void main(String[] args) 
	{
		// Without synchronized keyword
		
		SynchronizedCounter threadA = new SynchronizedCounter();
		SynchronizedCounter threadB = new SynchronizedCounter();
		
		threadA.increment();
		threadB.decrement();
		
		System.out.println("threadA with id " + threadA.getId() + " has count " + threadA.getCount());
		System.out.println("threadB with id " + threadB.getId() + " has count " + threadB.getCount());
		
		// With synchronized keyword
		
		SynchronizedCounter threadC = new SynchronizedCounter();
		SynchronizedCounter threadD = new SynchronizedCounter();
		
		threadC.synchIncrement();
		threadD.synchDecrement();
		
		System.out.println("threadC with id " + threadC.getId() + " has synched count " + threadC.getSyncCount());
		System.out.println("threadD with id " + threadD.getId() + " has synched count " + threadD.getSyncCount());
	}
	
}
