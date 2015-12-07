package multipleInheritance;

public class TestMultipleInheritance {

	public static void main(String[] args) {
		interface1 one = new MultiInheritance();
		one.test();
	}

}

interface interface1{
	public void test();
}

interface interface2{
	public void test(int vasl);
}

class MultiInheritance implements interface1, interface2{

	@Override
	public void test() {
		System.out.println("MultiInheritance.test()");
	}

	@Override
	public void test(int vasl) {
		
	}
	
}

class Base{
	void test(){
		
	}
}

class Sub extends Base{
	boolean test(int i){
		return true;
	}
}