package hh.fi.server.programming.Bookstore;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class BookController {


		//GET method - URL parameters
		@RequestMapping("/index")
		public String greetingRequest(@RequestParam(name="name",required=false, defaultValue="Stranger")String name){
			return "Greetings " + name;
		}
	
}
