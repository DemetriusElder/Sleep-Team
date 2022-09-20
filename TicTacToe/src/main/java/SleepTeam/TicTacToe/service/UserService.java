package service;

import repo.UserRepo;

public class UserService {
	private final UserRepo userRepo;
	
	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	

}
