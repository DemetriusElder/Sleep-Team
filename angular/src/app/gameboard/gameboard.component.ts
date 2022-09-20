import { Component, OnInit } from '@angular/core';
import { GameBoardService } from '../gameboard-service/gameboard.service';

@Component({
  selector: 'app-gameboard',
  templateUrl: './gameboard.component.html',
  styleUrls: ['./gameboard.component.css']
})
export class GameboardComponent implements OnInit {

  constructor(public gameBoardService: GameBoardService) { }

  ngOnInit(): void {

  }
  reset(){
    console.log('resting...');
    this.gameBoardService.newGame();
  }
}
