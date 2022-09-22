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

	private String winner;
	
	private String[][] boardstate = new String[3][3];
	

	public Board() {
		
	}
	
	
	public Board(boolean finished, String winner) {
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

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public String[][] getBoardstate() {
		return boardstate;
	}

	public void setBoardstate(String[][] boardstate) {
		this.boardstate = boardstate;
	}

	

}
