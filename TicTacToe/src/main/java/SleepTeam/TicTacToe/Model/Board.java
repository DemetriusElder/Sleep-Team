package SleepTeam.TicTacToe.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private boolean finished;

	private char winner;
	
	private char[][] boardstate = new char[3][3];
	

	public Board() {
		
	}
	
	
	public Board(boolean finished, char winner) {
		this.finished = finished;
		this.winner = winner;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public char getWinner() {
		return winner;
	}

	public void setWinner(char winner) {
		this.winner = winner;
	}

	public char[][] getBoardstate() {
		return boardstate;
	}

	public void setBoardstate(char[][] booardstate) {
		this.boardstate = boardstate;
	}

	

}
