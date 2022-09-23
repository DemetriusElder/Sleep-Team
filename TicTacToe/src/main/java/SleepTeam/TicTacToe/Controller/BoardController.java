package SleepTeam.TicTacToe.Controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import SleepTeam.TicTacToe.Model.Board;
import SleepTeam.TicTacToe.Service.BoardService;


@RestController()
@CrossOrigin
@RequestMapping("board")
public class BoardController {
	
	private final BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping("/ai")
	public Board getBoardVsAI(@RequestParam String XorO) {
		return boardService.changeBoardStateAI(XorO);
	}
	@GetMapping("/reset")
	public void getResetBoard() {
		boardService.resetBoard();
	}
	@GetMapping("/human")
	public Board getBoardVsHuman(@RequestParam int row,@RequestParam int column,@RequestParam String XorO) {
		return boardService.changeBoardStateHuman(XorO, row, column);
	}
	@GetMapping()
	public String test() {
		System.out.println("Hello");
		return "Hello";
	}
	

}
