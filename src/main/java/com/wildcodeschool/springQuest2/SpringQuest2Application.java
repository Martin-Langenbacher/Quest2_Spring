package com.wildcodeschool.springQuest2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.RequestParam;



// In Spring it needs to be a controller!
@Controller
@SpringBootApplication
public class SpringQuest2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringQuest2Application.class, args);
	}

	
	@RequestMapping("/doctor/{incarnationNumber}")
	@ResponseBody
	String getQuestion(@PathVariable int incarnationNumber) {
		String outputString = "";
		
	    // between 1 and 8 ...
	    if(incarnationNumber >= 1 && incarnationNumber <= 8) {
			throw new ResponseStatusException(HttpStatus.SEE_OTHER, "No information available about that incarnation " +incarnationNumber + ".");
		} else if(incarnationNumber < 1 || incarnationNumber > 13){
	    	
			// return not valid: 404
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible to retrieve the incarnation " +incarnationNumber + ".");
			
			// return 9 to 13...
		} else {
			switch (incarnationNumber) {
			case 9:
				outputString = "{\"number\": " + incarnationNumber + ", \"name\": \"Christopher Eccleston\"}";
				break;
			case 10:
				outputString = "{\"number\": " + incarnationNumber + ", \"name\": \"David Tennant\"}";
				break;
			case 11:
				outputString = "{\"number\": " + incarnationNumber + ", \"name\": \"Matt Smith\"}";
				break;
			case 12:
				outputString = "{\"number\": " + incarnationNumber + ", \"name\": \"Peter Capaldi\"}";
				break;
			case 13:
				outputString = "{\"number\": " + incarnationNumber + ", \"name\": \"Jodie Whittaker\"}";
				break;
			}
		}
		return outputString;
	}

	
}
	    




