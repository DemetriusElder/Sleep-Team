package SleepTeam.TicTacToe.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SleepTeam.TicTacToe.Repo.UserRepo;

@Service
public class UserService {
	
	private final UserRepo userRepo;
	
	@Autowired
	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	

}
