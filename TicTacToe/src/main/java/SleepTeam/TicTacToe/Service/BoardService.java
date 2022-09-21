package SleepTeam.TicTacToe.Service;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SleepTeam.TicTacToe.Model.Board;
import SleepTeam.TicTacToe.Repo.BoardRepo;



@Service
public class BoardService {	
	
private final BoardRepo boardRepo;
	
	@Autowired
	public BoardService(BoardRepo boardRepo) {
		this.boardRepo = boardRepo;
	}
	
	public Board findBoard(int id) {
		return boardRepo.findById(id);
	}
	
	public Board changeBoardStateAI(String XorO, String[][] board) {
		Board testBoard = new Board(false, "");
		testBoard.setBoardstate(board);
		String[][] proxyArray = board;
		testBoard = this.checkWinner(testBoard);
		Random rand = new Random();
		if (testBoard.isFinished() == false) {
		      int randomRow = rand.nextInt(3);
		      int randomColumn = rand.nextInt(3);
		      while(proxyArray[randomRow][randomColumn] != "X" && proxyArray[randomRow][randomColumn] != "O") {
		    	  if(proxyArray[randomRow][randomColumn] == "X" && proxyArray[randomRow][randomColumn] == "O")
		    		  proxyArray[randomRow][randomColumn] = XorO;
		    	  else
		    	  {
		    		   randomRow = rand.nextInt(3);
				       randomColumn = rand.nextInt(3);
		    	  }
		    		  
		    	  
		      }
		}
		System.out.println(testBoard);
		return testBoard;
	}
	
	public Board changeBoardStateHuman(String XorO, int row, int column, String[][] board) {
		Board testBoard = new Board(false, "");
		testBoard.setBoardstate(board);
		String[][] proxyArray = board;
		testBoard = this.checkWinner(testBoard);
		proxyArray[row][column] = XorO;
		testBoard.setBoardstate(proxyArray);
		return testBoard;
	}
	
	public Board checkWinner(Board board) {
		Board testBoard = this.findBoard(1);
		String[][] proxyArray = testBoard.getBoardstate();
		//checks left to right
		for(int i = 0; i <= 2; i++){
			if (proxyArray[i][0] == proxyArray[i][1] && proxyArray[i][1] == proxyArray[i][2]) {
				testBoard.setFinished(true);
				testBoard.setWinner(proxyArray[i][0]);
			}
		}
		//checks up and down
		for(int i = 0; i <= 2; i++){
			if (proxyArray[0][i] == proxyArray[1][i] && proxyArray[1][i] == proxyArray[2][i]) {
				testBoard.setFinished(true);
				testBoard.setWinner(proxyArray[0][i]);
			}
		}
		//checks diagonal 
		if (proxyArray[0][0] == proxyArray[1][1] && proxyArray[1][1] == proxyArray[2][2]) {
				testBoard.setFinished(true);
				testBoard.setWinner(proxyArray[0][0]);
		}
		if (proxyArray[0][2] == proxyArray[1][1] && proxyArray[1][1] == proxyArray[2][0]) {
			testBoard.setFinished(true);
			testBoard.setWinner(proxyArray[0][2]);
		}
		System.out.println(testBoard);
		return testBoard;
		
	}


}