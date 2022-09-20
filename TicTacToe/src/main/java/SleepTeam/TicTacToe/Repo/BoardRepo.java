package SleepTeam.TicTacToe.Repo;

import org.springframework.stereotype.Repository;

import SleepTeam.TicTacToe.Model.Board;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface BoardRepo extends JpaRepository<Board, Long>{
	
	public Board findById(int id);

}
