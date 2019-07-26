
public class Fourth {

	public static void main(String[] args) {
		/*try {
			doTask();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println(method());
	}

	private static void doTask() throws ClassNotFoundException {
		Class.forName("a.b.Test");
	}
	
	static int method() {
		try {
			int[] elems = {4,6};
			return elems[0];
			
		} finally {
			System.out.println("hhhhhh");
//			return 0;
		}
	}

}
