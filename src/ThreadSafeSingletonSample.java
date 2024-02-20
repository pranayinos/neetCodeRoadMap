public class ThreadSafeSingletonSample {

    private static volatile ThreadSafeSingletonSample instance;

    private ThreadSafeSingletonSample() {
    }

    public static ThreadSafeSingletonSample getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingletonSample.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingletonSample();
                }
            }
        }
        return instance;
    }
}
