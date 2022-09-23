import { Injectable, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { GameSettingsComponent } from '../game-settings/game-settings.component';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Gamestate } from '../model/Gamestate';
 
@Injectable({
  providedIn: 'root'
})
export class GameBoardService {
  prevPlayer: string | null = 'O';
  nextPlayer: string | null = 'X';
  endgame!:boolean;
  apiBaseUrl = 'http://localhost:8080/board';
  test: any;
  gametest: Gamestate = {
    id: 1,
    finished : false,
    winner : 'test',
    boardstate : [ ['','',''],['','',''],['','',''] ]

  };
 

  constructor(private router: Router, private http: HttpClient) {
    this.newGame()
   }
 
   newGame(){
    this.gametest.boardstate = this.createBoard();
    this.endgame = false;
    this.router.navigate(['settings']);
    return this.http.get('http://localhost:8080/board/reset');
  } 

  createBoard(){
    // let board = [...Array(3)].map(e => Array(3));
    this.gametest.boardstate =[ ['','',''],['','',''],['','',''] ]
    return this.gametest.boardstate;
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
    console.log(row);
    console.log(col);
    if(player == 'O'){
    row = this.mockMove().row;
    col = this.mockMove().col;
    }
    this.gametest.boardstate[row][col] = player;
    this.endgame = this.checkFull();
    return this.http.get<Gamestate>(`http://localhost:8080/board/human?row=${row}&column=${col}&XorO=${player}`)
  }
  
  //todo: get win status -> endgame
 public getwinner() : any{
    return this.http.post('http://localhost:8080/board/checkWinner',JSON.stringify(this.gametest.boardstate))
  }
  //todo:get Ai move
  public getAiMove(apiChar: string) : any{
    return this.http.get<Gamestate>(`http://localhost:8080/board/ai?XorO=${apiChar}`)
  }
  public mockMove() : any{
    for(let i =0;i<3;i++){
      for(let j = 0;j<3;j++){
        if(this.gametest.boardstate[i][j] == '')
        return {row:i,col:j};
      }
    }
  }
  public checkFull():boolean{
    for(let i =0;i<3;i++){
      for(let j = 0;j<3;j++){
        if(this.gametest.boardstate[i][j] == '')
        return false;
      }
    }
    alert("winner!");
    return true;
  }
 
}
