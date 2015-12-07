package nestedclasses;

public class OuterClass {

	static String firstName = "Tarzan";
    String lastName = "Donkey";
	
	protected class InnerClass{
		// static int first=1;            NOT ALLOWED
		int second=2;
		InnerClass(){
			System.out.println("OuterClass.InnerClass.InnerClass(): " + lastName.toUpperCase());
		}
	}
	
	private static class StaticNestedClass{
		static int first=1;
		int second=2;
		StaticNestedClass(){
			System.out.println("OuterClass.StaticNestedClass.StaticNestedClass(): " + firstName.toUpperCase());
		}
		
		 void printValues(){
			System.out.println("OuterClass.StaticNestedClass.printValues():" + firstName + "," + new OuterClass().lastName);
			System.out.println("OuterClass.StaticNestedClass.printValues():" + first + "," + new StaticNestedClass().second);
		}
	}
	
	public static void main(String[] args) {
		OuterClass clazz = new OuterClass();
		clazz.new InnerClass();
		OuterClass.StaticNestedClass staticClazz = new OuterClass.StaticNestedClass();
		staticClazz.printValues();
	}
}
