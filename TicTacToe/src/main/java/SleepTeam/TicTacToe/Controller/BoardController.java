package SleepTeam.TicTacToe.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import SleepTeam.TicTacToe.Model.Board;
import SleepTeam.TicTacToe.Service.BoardService;


@RestController()
@RequestMapping("board")
public class BoardController {
	
	private final BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping("/ai")
	public Board getBoardVsAI(@RequestParam String XorO, @RequestParam String[][] board) {
		return boardService.changeBoardStateAI(XorO, board);	
	}
	
	@GetMapping("/human")
	public Board getBoardVsHuman(@RequestParam int row,@RequestParam int column,@RequestParam String XorO, @RequestParam String[][] board) {
		return boardService.changeBoardStateHuman(XorO, row, column, board);
	}
	@GetMapping()
	public String test() {
		System.out.println("Hello");
		return "Hello";
	}
	

}
