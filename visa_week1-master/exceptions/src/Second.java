
public class Second {

	public static void main(String[] args) {
		Thread.setDefaultUncaughtExceptionHandler((t,ex)-> System.err.println("Boom -("));
		System.out.println("Hello");
		doTask();
	}

	private static void doTask() {
		int[] elems = {5,5,23,6};
		System.out.println(elems[9]);
	}

}
