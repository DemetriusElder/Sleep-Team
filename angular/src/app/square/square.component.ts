import { Component, Input, OnInit } from '@angular/core';
import { GameBoardService } from '../gameboard-service/gameboard.service';

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
  constructor(public gameboardService:GameBoardService) { }

  ngOnInit(): void {
  }
  changeState()
  {
    if(this.gameboardService.mode == "HUMAN") {
    //For human only:
    if((this.gameboardService.currentPlayer == this.gameboardService.player1.mark && this.gameboardService.player1.user == "HUMAN")
    ||(this.gameboardService.currentPlayer == this.gameboardService.player2.mark && this.gameboardService.player2.user == "HUMAN") ){
     console.log("HUMAN moved:", this.gameboardService.currentPlayer);
     this.gameboardService.testHumanFunction(this.row, this.col, this.gameboardService.currentPlayer).subscribe((result) => {  
      this.res = result;
       console.log(this.res); 
       this.gameboardService.winner = result.winner;  
       this.gameboardService.switchPlayer();
       this.gameboardService.board = result.boardstate;
 
  });
    }}

if(this.gameboardService.mode == "AI"){
  if((this.gameboardService.currentPlayer == this.gameboardService.player1.mark && this.gameboardService.player1.user == "HUMAN")
   ||(this.gameboardService.currentPlayer == this.gameboardService.player2.mark && this.gameboardService.player2.user == "HUMAN") ){
    console.log("HUMAN moved:", this.gameboardService.currentPlayer);
    this.gameboardService.testHumanFunction(this.row, this.col, this.gameboardService.currentPlayer).subscribe((result) => {  
      console.log(result); 
      this.gameboardService.winner = result.winner;  
      this.gameboardService.switchPlayer();    
    //AI :
      if((this.gameboardService.currentPlayer== this.gameboardService.player1.mark && this.gameboardService.player1.user == "AI" )
    || (this.gameboardService.currentPlayer == this.gameboardService.player2.mark && this.gameboardService.player2.user == "AI")){
      console.log("AI move:", this.gameboardService.currentPlayer);
      this.gameboardService.testFunction(this.gameboardService.currentPlayer).subscribe((result) => {
        this.gameboardService.board = result.boardstate;
        console.log(result); 
        this.gameboardService.winner = result.winner;    
        this.gameboardService.switchPlayer();
      });
  
    }
    });   
  
  }

  }
 

  }

}
