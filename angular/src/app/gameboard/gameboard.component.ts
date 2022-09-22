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
gameboard!: Gamestate;

  constructor(public gameBoardService: GameBoardService) { }

  ngOnInit(): void {

  }
  reset(){
    console.log('resting...');
    this.gameBoardService.newGame();
  }
}
