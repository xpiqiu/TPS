package training.adv.team1.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import training.adv.team1.Service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/login_action")
	public String LoginDo(HttpServletRequest request){
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		System.out.println("name:"+name+" password:"+password);
		return "login";
	}
	
	@RequestMapping("/logout.jsp")
	public String LogoutDo(HttpServletRequest request){
		request.getSession().invalidate();
		return "login";
	}
	
	@RequestMapping("/loginCheck")
	public String LoginCheck(){
		return null;
	}
	/*@RequestMapping(value = "/first" , method = RequestMethod.GET)
	public Integer firstRequest(){
	//	System.out.println(TimeUtils.getYearDate(System.currentTimeMillis()));
		Integer i = 1;
		
		return i;
	}
	*/
}
