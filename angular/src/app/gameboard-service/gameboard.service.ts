import { Injectable, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { GameSettingsComponent } from '../game-settings/game-settings.component';
 
@Injectable({
  providedIn: 'root'
})
export class GameBoardService {
  board!:string[][];
  prevPlayer!: string;
  nextPlayer!: string | null;
  apiBaseUrl!: 'http://localhost:8080';
  endgame!:boolean;
 

  constructor(private router: Router, private http: HttpClient) {
    this.newGame()
   }
 
  //start a new game at the begining or reset
   newGame(){
    this.board = this.createBoard();
    //later can change to let user select who(O or x) go first
    this.prevPlayer = "O";
    this.nextPlayer = localStorage.getItem('X');
    this.endgame = false;
    this.router.navigate(['settings']);
  } 

  createBoard(){
    // let board = [...Array(3)].map(e => Array(3));
    let board:string[][]=[ ['','',''],['','',''],['','',''] ]
    return board;
  }

  switchPlayer(){
    this.prevPlayer = this.prevPlayer === "X" ? "O" : "X";
    this.nextPlayer = this.nextPlayer === "X" ? "O" : "X";
    //send the board to backend for evaluation
    //update if wins
    this.endgame = this.getwinner();
    return this.prevPlayer;
  }
  updateBoard(row:number,col:number,player:string){
    if(player == 'O'){
    row = this.mockMove().row;
    col = this.mockMove().col;
    }
    this.board[row][col] = player;
    this.endgame = this.checkFull();
  }
  //todo: get win status -> endgame
 public getwinner() : any{
    return this.http.post('http://localhost:8080/board/checkWinner',JSON.stringify(this.board))
  }
  //todo:get Ai move
  public getAiMove() : any{
    return this.http.get(`${this.apiBaseUrl}/board?board=${this.board}`)
  }
  public mockMove() : any{
    for(let i =0;i<3;i++){
      for(let j = 0;j<3;j++){
        if(this.board[i][j] == '')
        return {row:i,col:j};
      }
    }
  }
  public checkFull():boolean{
    for(let i =0;i<3;i++){
      for(let j = 0;j<3;j++){
        if(this.board[i][j] == '')
        return false;
      }
    }
    return true;
  }
}
