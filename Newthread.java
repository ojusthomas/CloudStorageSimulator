package thread1;

// Create multiple threads.
class NewThread implements Runnable {
  String name; // name of thread
  Thread t;
  long res;
  NewThread(String threadname,long result) {
    name = threadname;
    t = new Thread(this, name);
    res=result;
    System.out.println("New thread: " + t+ "value" + result);
    t.start(); // Start the thread
}
  // This is the entry point for thread.
  public void run() {
   try {
   
        System.out.println(name);
        Thread.sleep(res);
      
    } catch (InterruptedException e) {
      System.out.println(name + "Interrupted");
}
    System.out.println(name + " operation finish");
  }
}