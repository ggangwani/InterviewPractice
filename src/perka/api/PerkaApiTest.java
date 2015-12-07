package perka.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.http.utils.Base64Coder;

public class PerkaApiTest {

	public static void main(String[] args) {

		try {
			File file =  new File("Gunjan_Gangwani_resume.pdf");
			 String response = Unirest.post("https://api.perka.com/1/communication/job/apply")
			         .header("Content-Type","application/json")
			         .header("accept","application/json")
			         .field("first_name", "Gunjan")
			         .field("last_name","Gangwani")
			         .field("email","gunjang@gmail.com")
			         .field("position_id","JAVA")
			         .field("explanation","Java Unirest Rest api")
			         .field("source","Agency - Connections of New York")
			         .field("resume",file)
			         .asJson().getBody().toString();
			 
			System.out.print(response);
		} catch (UnirestException  e) {
			e.printStackTrace();
		} 
         
	}

}
