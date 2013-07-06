package holaivy.web.context.session;

import java.util.concurrent.atomic.AtomicInteger;

public class SessionCounter {
	
	public AtomicInteger counter = new AtomicInteger(0);

	protected static SessionCounter instance = new SessionCounter();

	public static SessionCounter getInstance() {
		return instance;
	}

	public static int increment() {
		instance.counter.addAndGet(1);
		return instance.counter.intValue();
	}

	public static int decrement() {
		return instance.counter.addAndGet(-1);
	}

	public static int intValue() {
		return instance.counter.intValue();
	}

}
