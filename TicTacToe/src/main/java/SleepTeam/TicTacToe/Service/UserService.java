package SleepTeam.TicTacToe.Service;

import SleepTeam.TicTacToe.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import SleepTeam.TicTacToe.Repo.UserRepo;

import java.util.Optional;

@Service
public class UserService {
	
	private final UserRepo userRepo;
	
	@Autowired
	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	public User findByUsername(String username){
		return userRepo.findByUsername(username);
	}

	public User findById(long userId) {
		return userRepo.findById(userId);
	}

	public User updateWinPlusOne(String username) {
		int updateSuccess = userRepo.updateWinPlusOne(username);
		if(updateSuccess == 1){
			return userRepo.findByUsername(username);
		}else{
			throw new RuntimeException("No username found");
		}
	}

	public User updateLossPlusOne(String username) {

		int updateSuccess = userRepo.updateLossPlusOne(username);
		if(updateSuccess == 1){
			return userRepo.findByUsername(username);
		}else{
			throw new RuntimeException("No username found");
		}
	}
}
