
public class Third {
	static {
		System.loadLibrary("pubg.dll");
	}
	public static void main(String[] args) {
		doTask();
	}

	private static void doTask() {
		System.out.println("Hi!!!");
//		doTask(); // recursive
	}

}
