import { Component, OnInit } from '@angular/core';
import { GameSettingsComponent } from '../game-settings/game-settings.component';
import { GameBoardService } from '../gameboard-service/gameboard.service';
import { gameboard } from '../model/gameboard';

@Component({
  selector: 'app-gameboard',
  templateUrl: './gameboard.component.html',
  styleUrls: ['./gameboard.component.css']
})
export class GameboardComponent implements OnInit {
gameboard!: gameboard;

  constructor(public gameBoardService: GameBoardService) { }

  ngOnInit(): void {

  }
  reset(){
    console.log('resting...');
    this.gameBoardService.newGame();
  }
}
