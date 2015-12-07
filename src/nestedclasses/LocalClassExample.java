package nestedclasses;

/**
 * Simple example of local class - a class defined inside a method
 * Local class can access all the class level members. It can access all the method level
 * members also as long as they are final or effectively final.
 * Java 7 - we need to explicity declare variables as final in the method to be able 
 * to use them in local or anonymous nested classes while in java 8 we dont need to as long
 * as they are effectively final.
 * 
 * Whey do we have to declare the method variables as final to be used in anonymous or local inner classes ?
 * The scope of method is very short, once a method finishes execution all the variables in the stack are deallocated.
 * But if we have defined a class inside a method and lets say are creating an object of such a class and passing this
 * object as a reference to a different object, this remains live even after the method is executed. So it can no longer
 * reference the method variables if they were not final. Hence they need to be defined final. 
 * @author gunjan
 *
 */
public class LocalClassExample {

	public static void main(String[] args) {
		PhoneNumberValidator validator = new PhoneNumberValidator();
		validator.validatePhoneNumber("123-456-7890", "456-7890");
	}

}

class PhoneNumberValidator{
	
	private String regex = "[^0-9]";
	public void validatePhoneNumber(String no1, String no2){
	
		int length = 10;
		
		class PhoneNumber{
			String formattedNo = null;
			
			PhoneNumber(String number){
				// length = 20;   NOT ALLOWED, it wont be effectively final otherwise
				number = number.replaceAll(regex, "");
				if(number.length() == length){
					formattedNo = number;
				}else{
					formattedNo = null;
				}
			}
			
			boolean isValid() {
				return formattedNo != null && !formattedNo.isEmpty();
			}
			
			void printNumbers(){
				System.out.println(no1 + "," + no2);
			}
		}
		
		PhoneNumber phoneNumber1 = new PhoneNumber(no1);
		PhoneNumber phoneNumber2 = new PhoneNumber(no2);
		
		if(phoneNumber1.isValid()){
			System.out.println("Phone number is valid: " + no1);
		}else{
			System.out.println("Phone number is invalid: " + no1);
		}
		
		if(phoneNumber2.isValid()){
			System.out.println("Phone number is valid: " + no2);
		}else{
			System.out.println("Phone number is invalid: " + no2);
		}
		
		// THIS IS NOT ALLOWED
		
		/*interface HelloThere {
	      public void greet();
	    }
		
		class TestingStaticMethod{
			static void printTest(){
				
			}
		}
	      
		class TestingStaticVariable{
			static int count = 0;
		}*/
	}
	
}
