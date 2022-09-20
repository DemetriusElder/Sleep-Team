package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Board;
import service.BoardService;

@RestController()
@RequestMapping("board")
public class BoardController {
	
	private final BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping("/ai")
	public Board getBoardVsAI(@RequestParam char XorO) {
		return boardService.changeBoardStateAI(XorO);	
	}
	
	@GetMapping("/human")
	public Board getBoardVsHuman(@RequestParam int row,@RequestParam int column,@RequestParam char XorO) {
		return boardService.changeBoardStateHuman(XorO, row, column);
	}
	

}
