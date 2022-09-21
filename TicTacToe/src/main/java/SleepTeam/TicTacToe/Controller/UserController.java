package SleepTeam.TicTacToe.Controller;

import SleepTeam.TicTacToe.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import SleepTeam.TicTacToe.Service.UserService;

import java.util.Optional;


@RestController
@CrossOrigin	
@RequestMapping("/users")
public class UserController {
	private UserService userService;
	@Autowired
	public UserController(UserService userService){
		this.userService = userService;
	}
    @GetMapping("/id/{userId}")
	public User findById(@PathVariable("userId") long userId) {
		return userService.findById(userId);
	}
	@GetMapping("/username/{username}")
	public User findByUsername(@PathVariable("username") String username){
		return userService.findByUsername(username);
	}
	@PostMapping("/updateWinPlusOne/{username}")
	public User updateWinPlusOne(@PathVariable("username") String username) {
		return userService.updateWinPlusOne(username);
	}
	@PostMapping("/updateLossPlusOne/{username}")
	public User updateLossPlusOne(@PathVariable("username") String username) {
		return userService.updateLossPlusOne(username);
	}

}
