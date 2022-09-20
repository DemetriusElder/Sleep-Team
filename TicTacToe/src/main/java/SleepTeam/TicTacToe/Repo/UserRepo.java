package SleepTeam.TicTacToe.Repo;

import org.springframework.stereotype.Repository;

import SleepTeam.TicTacToe.Model.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	public User findById(int id);

	public User findByUsername(String username);
}
