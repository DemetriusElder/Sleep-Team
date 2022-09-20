import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class GameBoardService {
  board!:string[][];
  prevPlayer!: string;
  nextPlayer!:string;

  constructor() {
    this.newGame()
   }
  //start a new game at the begining or reset
   newGame(){
    this.board = this.createBoard();
    //later can change to let user select who(O or x) go first
    this.prevPlayer = "O";
    this.nextPlayer = "X";
  } 

  createBoard(){
    // let board = [...Array(3)].map(e => Array(3));
    let board:string[][]=[ ['','',''],['','',''],['','',''] ]
    return board;
  }

  switchPlayer(){
    this.prevPlayer = this.prevPlayer === "X" ? "O" : "X";
    this.nextPlayer = this.nextPlayer === "X" ? "O" : "X";
    //todo: 1)call update board 2)send the board to backend for evaluation
    return this.prevPlayer;
  }
  updateBoard(row:number,col:number,player:string){
    console.log("Selected:(",row,",",col,")","player: ",player);
    console.log("Board:", this.board);
    this.board[row][col] = player;

  }
 
}
