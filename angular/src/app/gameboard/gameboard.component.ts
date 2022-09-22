import { Component, OnInit } from '@angular/core';
import { GameSettingsComponent } from '../game-settings/game-settings.component';
import { GameBoardService } from '../gameboard-service/gameboard.service';
import { Gamestate } from '../model/Gamestate';

@Component({
  selector: 'app-gameboard',
  templateUrl: './gameboard.component.html',
  styleUrls: ['./gameboard.component.css']
})
export class GameboardComponent implements OnInit {

  constructor(public gameBoardService: GameBoardService) { }

  ngOnInit(): void {
    this.gameBoardService.nextPlayer = localStorage.getItem('X');
    if(localStorage.getItem('X') == 'undefined') {
      this.gameBoardService.nextPlayer = 'X';
    }
    if(this.gameBoardService.nextPlayer == 'X') {
      this.gameBoardService.prevPlayer == 'O';
    }
    else {
      this.gameBoardService.prevPlayer = 'X';
    }

  }
  reset(){
    console.log('resting...');
    this.gameBoardService.newGame();//add a .subscribe()
  }
}
