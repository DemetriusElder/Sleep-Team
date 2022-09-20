package SleepTeam.TicTacToe.Controller;

import SleepTeam.TicTacToe.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import SleepTeam.TicTacToe.Service.UserService;


@RestController
@CrossOrigin	
@RequestMapping("/user")
public class UserController {
	private UserService userService;
	@Autowired
	public UserController(UserService userService){
		this.userService = userService;
	}
    @GetMapping("/{userId}")
	public User findById(@PathVariable("userId") long userId) {
		return userService.findById(userId);

	}
}
//	private final UserService userService;
//
//	@Autowired
//	public UserController(UserService userService) {
//		this.userService = userService;
//	}
//	@GetMapping("/hi")
//	public String hi() {
//		return "hi";
//	}
//
//	@GetMapping("/{username}")
//	@ResponseBody
//	public String getUserByUsername(@PathVariable String username){
//		return username;
//	}
//