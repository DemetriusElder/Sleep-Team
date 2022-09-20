package SleepTeam.TicTacToe.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SleepTeam.TicTacToe.Service.UserService;


@RestController
@CrossOrigin	
@RequestMapping("/user")
public class UserController {
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	@GetMapping("/hi")
	public String hi() {
		return "hi";
	}
	
}
