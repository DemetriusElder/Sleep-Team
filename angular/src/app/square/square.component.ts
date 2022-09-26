import { Component, Input, OnInit } from '@angular/core';
import { GameBoardService } from '../gameboard-service/gameboard.service';
import { Gamestate } from '../model/Gamestate';

@Component({
  selector: 'app-square',
  templateUrl: './square.component.html',
  styleUrls: ['./square.component.css']
})
export class SquareComponent implements OnInit {
  @Input() square: any; 
  @Input() row: any; 
  @Input() col: any; 
  res!:Gamestate;
  
  // player!: string;
  // api!: string;
  constructor(public gameboardService:GameBoardService) { }

  ngOnInit(): void {
  }
  changeState()
  {
    if(this.gameboardService.mode == "HUMAN") {
    //HUMAN:
    if((this.gameboardService.currentPlayer == this.gameboardService.player1.mark && this.gameboardService.player1.user == "HUMAN")
    ||(this.gameboardService.currentPlayer == this.gameboardService.player2.mark && this.gameboardService.player2.user == "HUMAN") ){
     console.log("HUMAN moved:", this.gameboardService.currentPlayer);
     this.gameboardService.testHumanFunction(this.row, this.col, this.gameboardService.currentPlayer).subscribe((result) => {  
      this.res = result;
       console.log(this.res); 
       this.gameboardService.winner = result.winner;
       if(this.gameboardService.winner == "O" ||this.gameboardService.winner == "X") {
        if(this.gameboardService.player1.mark == this.gameboardService.winner ) this.gameboardService.player1.score +=1;
        if(this.gameboardService.player2.mark == this.gameboardService.winner ) this.gameboardService.player2.score +=1;
      }    
      console.log("S  this.player1score :", this.gameboardService.player1.score);
      console.log("S  this.player2score :",  this.gameboardService.player2.score );    
       this.gameboardService.switchPlayer();
       this.gameboardService.board = result.boardstate;
 
  });
    }}

if(this.gameboardService.mode == "AI"){
  if(this.gameboardService.currentPlayer == this.gameboardService.player1.mark && this.gameboardService.player1.user == "HUMAN" ){
    console.log("HUMAN moved:", this.gameboardService.currentPlayer);
    this.gameboardService.testHumanFunction(this.row, this.col, this.gameboardService.currentPlayer).subscribe((result) => {  
      console.log(result); 
      this.gameboardService.winner = result.winner;  
      this.gameboardService.switchPlayer();    
    //AI :
      if(this.gameboardService.currentPlayer == this.gameboardService.player2.mark && this.gameboardService.player2.user == "AI"){
      console.log("AI move:", this.gameboardService.currentPlayer);
      this.gameboardService.testFunction(this.gameboardService.currentPlayer).subscribe((result) => {
        this.gameboardService.board = result.boardstate;
        console.log(result); 
        this.gameboardService.winner = result.winner;
        if(this.gameboardService.winner == "O" ||this.gameboardService.winner == "X") {
          if(this.gameboardService.player1.mark == this.gameboardService.winner ) this.gameboardService.player1.score +=1;
          if(this.gameboardService.player2.mark == this.gameboardService.winner ) this.gameboardService.player2.score +=1;
        }  

        console.log("S  this.player1score :", this.gameboardService.player1.score);
        console.log("S  this.player2score :",  this.gameboardService.player2.score );  
        this.gameboardService.switchPlayer();
      });
  
    }
    });   
  
  }

  }
 

  }

}
