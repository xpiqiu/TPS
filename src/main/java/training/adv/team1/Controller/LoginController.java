package training.adv.team1.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import training.adv.team1.Service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/login.html")
	public String LoginDo(HttpServletRequest request){
		request.getSession().invalidate();
		return "login";
	}
	
	@RequestMapping("/logout.html")
	public String LogoutDo(HttpServletRequest request){
		request.getSession().invalidate();
		return "login";
	}
	
	@RequestMapping("/loginCheck")
	public String LoginCheck(){
		return null;
	}
}
