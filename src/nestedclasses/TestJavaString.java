package nestedclasses;

public class TestJavaString {

	public static void main(String[] args) {

		String s1 = "Test";
		String s2 = new String("Test");
		String s3="Test";
		
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		
		// to run gc
		System.gc();
		Runtime.getRuntime().gc();
	}

}
