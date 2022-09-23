package SleepTeam.TicTacToe.Service;

import SleepTeam.TicTacToe.Model.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import SleepTeam.TicTacToe.Repo.UserRepo;

import javax.persistence.EntityNotFoundException;


@Service
public class UserService {
	
	private final UserRepo userRepo;
	
	@Autowired
	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	public User findByUsername(String username){
		User result = userRepo.findByUsername(username);
		if(result != null){
			return result;
		}else{
			throw new EntityNotFoundException(username + " was not found in the database");
		}
	}

	public User findById(long userId) {
		User result = userRepo.findById(userId);
		if(result != null){
			return result;
		}else{
			throw new EntityNotFoundException(userId + " was not found in the database");
		}
	}

	public User updateWinPlusOne(String username) {
		int updateSuccess = userRepo.updateWinPlusOne(username);
		if(updateSuccess == 1){
			return userRepo.findByUsername(username);
		}else{
			//custom exception thrown. handled by RestExceptionHandler in error handle folder
			throw new EntityNotFoundException(username + " was not found in the database");
		}
	}

	public User updateLossPlusOne(String username) {

		int updateSuccess = userRepo.updateLossPlusOne(username);
		if(updateSuccess == 1){
			return userRepo.findByUsername(username);
		}else{
			throw new EntityNotFoundException(username + " was not found in the database");

		}
	}


}
