import { Injectable, Input } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { GameSettingsComponent } from '../game-settings/game-settings.component';
import { Gamestate } from '../model/Gamestate';
import { Observable, of } from 'rxjs';
 
@Injectable({
  providedIn: 'root'
})
export class GameBoardService {
  board!:string[][];
  currentPlayer!: string;
  nextPlayer!:string;
  winner!:string;
  player1!:any;
  player2!:any;
  start!:string;
  mode!:string;

  constructor(private http: HttpClient ) {
   }

  //Start a new game at the begining or reset
  newGame(){ 
  this.board = this.createBoard();
  this.winner = '';
  this.currentPlayer = this.start;
  } 
  //todo: we can add property like score,username...or create a player model when we add more stuff to it
  setPlayer1(user:string,mark:string){
    this.player1 = {user:user,
                    mark:mark};
  }
  //todo: we can add property like score,username...or create a player model when we add more stuff to it
  setPlayer2(user:string,mark:string){
    this.player2 = {user:user,
                    mark:mark};
  }

  setCurrent(player:string){
    this.currentPlayer = player;
    //who is the first one to move, for reset
    this.start = player;
    this.nextPlayer = player === "X" ? "O" : "X";
  }
  setMode(mode:string){
    this.mode = mode;
  }

  createBoard(): string[][]{     
    console.log("Backend reset");
    let board:string[][]=[ [' ',' ',' '],[' ',' ',' '],[' ',' ',' '] ]
    this.testResetFunction().subscribe((result) => {
    });
    return board;
  }

  switchPlayer(): string{
    this.currentPlayer = this.currentPlayer === "X" ? "O" : "X";
    console.log('Current player',this.currentPlayer)
    //for display next player
    this.nextPlayer = this.nextPlayer === "X" ? "O" : "X";
    return this.currentPlayer;
  }

  // updateBoard(row:number,col:number,player:string){ 
  //   // this.board[row][col] = player;
  //   //update human move with backend
  //   this.testHumanFunction(row, col, player).subscribe((result) => {  
  //   console.log(result); 
  //   this.winner = result.winner;
  //   this.board = result.boardstate;
  // });   
  // }

  // updateBoardAI(player:string): void{
  //     this.testFunction(player).subscribe((result) => {
  //       this.board = result.boardstate;
  //       console.log(result); 
  //       this.winner = result.winner;
  //     });
     
  // }

  //Send Ai's X or O to backend it will return the ai move to us,  backend always has the latest board
  public testFunction(XorO: string): Observable<Gamestate>{
    return this.http.get<Gamestate>(`http://localhost:8080/board/ai?XorO=${XorO}`)
  }

  //Send human move to backend, so backend has the most updated board
  public testHumanFunction(row: number, column: number,XorO: string): Observable<Gamestate>{
    return this.http.get<Gamestate>(`http://localhost:8080/board/human?row=${row}&column=${column}&XorO=${XorO}`)
  }

  //Reset the board in the backend
  public testResetFunction(){
    return this.http.get<void>(`http://localhost:8080/board/reset`)
  }
    
  }



