package SleepTeam.TicTacToe.Service;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SleepTeam.TicTacToe.Model.Board;
import SleepTeam.TicTacToe.Repo.BoardRepo;



@Service
public class BoardService {	
	
private final BoardRepo boardRepo;
private String[][] board = {{" ", " ", " "}, {" ", " "," "}, {" ", " "," "}};

	
	@Autowired
	public BoardService(BoardRepo boardRepo) {
		this.boardRepo = boardRepo;
	}
	
	public Board findBoard(int id) {
		return boardRepo.findById(id);
	}
	public void resetBoard() {
		String[][] newboard = {{" ", " ", " "}, {" ", " "," "}, {" ", " "," "}};
		this.board = newboard;
	}
	public Board changeBoardStateAI(String XorO) {
		Board testBoard = new Board(false, "");
		String[][] proxyArray = this.board;
		testBoard.setBoardstate(proxyArray);
//		System.out.println(proxyArray[1][1]);
//		System.out.println(testBoard.getBoardstate()[1][1]);
		testBoard = this.checkWinner(testBoard);
		Random rand = new Random();
		if (testBoard.isFinished() == false) {
		      int randomRow = rand.nextInt(3);
		      int randomColumn = rand.nextInt(3);
		      for(int i = 0; i < 1; i--) {
		    	  if(proxyArray[randomRow][randomColumn] == " ") {
		    		  proxyArray[randomRow][randomColumn] = XorO;
		    		  this.board[randomRow][randomColumn] = XorO;
		    		  testBoard.setBoardstate(proxyArray);
		    		  i = 1;
		    		  testBoard = this.checkWinner(testBoard);
		    		  return testBoard;
		    	  }
		    	  else
		    	  {
		    		   randomRow = rand.nextInt(3);
				       randomColumn = rand.nextInt(3);
		    	  }
		    	  
		      }
		}
		testBoard = this.checkWinner(testBoard);
		return testBoard;
	}
	
	public Board changeBoardStateHuman(String XorO, int row, int column) {
		Board testBoard = new Board(false, "");
		testBoard.setBoardstate(board);
		String[][] proxyArray = board;
		testBoard = this.checkWinner(testBoard);
		proxyArray[row][column] = XorO;
		testBoard.setBoardstate(proxyArray);
		return testBoard;
	}
	
	public Board checkWinner(Board boardboard) {
		String[][] proxyArray = boardboard.getBoardstate();
		System.out.println("Inside checkWinnerFunction");
		for (int i = 0; i<3; i++) {
		    for (int j = 0; j<3; j++) {
		        System.out.print(proxyArray[i][j]);
		    }
		    System.out.println();
		}
		//checks left to right
		for(int i = 0; i <= 2; i++){
			if (proxyArray[i][0].compareTo(proxyArray[i][1]) == 0 && proxyArray[i][2].compareTo(proxyArray[i][1]) == 0 && proxyArray[i][1] != " ") {
				boardboard.setFinished(true);
				boardboard.setWinner(proxyArray[i][0]);
			}
		}
		//checks up and down
		for(int i = 0; i <= 2; i++){
			System.out.println("Inside for loop Column: up and down");
			if (proxyArray[0][i].compareTo(proxyArray[1][i]) == 0 && proxyArray[1][i].compareTo(proxyArray[2][i]) == 0 && proxyArray[1][i] != " ") {
				boardboard.setFinished(true);
				boardboard.setWinner(proxyArray[0][i]);
			}
		}
		//checks diagonal 
		if (proxyArray[0][0].compareTo(proxyArray[1][1]) == 0 && proxyArray[1][1].compareTo(proxyArray[2][2]) == 0 && proxyArray[1][1] != " ") {
			boardboard.setFinished(true);
			boardboard.setWinner(proxyArray[0][0]);
		}
		if (proxyArray[1][1].compareTo(proxyArray[2][0]) == 0 && proxyArray[1][1].compareTo(proxyArray[0][2]) == 0 && proxyArray[1][1] != " ") {
			boardboard.setFinished(true);
			boardboard.setWinner(proxyArray[0][2]);

		}

		return boardboard;
		
	}


}