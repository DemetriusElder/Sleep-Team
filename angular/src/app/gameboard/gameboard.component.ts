import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GameSettingsComponent } from '../game-settings/game-settings.component';
import { GameBoardService } from '../gameboard-service/gameboard.service';
import { Gamestate } from '../model/Gamestate';

@Component({
  selector: 'app-gameboard',
  templateUrl: './gameboard.component.html',
  styleUrls: ['./gameboard.component.css']
})
export class GameboardComponent implements OnInit {

  constructor(public gameBoardService: GameBoardService,  private router: Router) { }

  ngOnInit(): void {
    console.log("ngOnInit: currentplayer: ", this.gameBoardService.currentPlayer);
    if(this.gameBoardService.mode == "AI")this.aiMode();
  }

  aiMode(){
    //Special case: When AI is the first one to move.(Ai don't know how to press btn to invoke the changestate function)
    console.log("Current player:", this.gameBoardService.currentPlayer);
    if((this.gameBoardService.currentPlayer == this.gameBoardService.player2.mark && this.gameBoardService.player2.user == "AI")){
      console.log("AI moved:", this.gameBoardService.currentPlayer);
      this.gameBoardService.testFunction(this.gameBoardService.currentPlayer).subscribe((result) => {
        this.gameBoardService.board = result.boardstate;
        console.log(result); 
        this.gameBoardService.winner = result.winner; 
        this.gameBoardService.switchPlayer();
      });
    }}

  nextgame(){ 
    this.gameBoardService.newGame();
    this.aiMode();
  }
  reset(){
    this.router.navigate(['settings']);
  }
}
