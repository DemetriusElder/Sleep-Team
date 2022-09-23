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
  player!: string;
  api!: string;
  constructor(public gameboardService:GameBoardService) { }

  ngOnInit(): void {
  }

  changeState(){
    
    let playerStorage = Object.assign({}, localStorage.getItem('X'));
    
    this.player = playerStorage[1];
    if(this.player == 'X') { this.api = 'O';}
    if(this.player == 'O') { this.api = 'X';}

    this.gameboardService.updateBoard(this.row,this.col,this.api).subscribe(res => console.log("this is the update board response" + res));
    this.gameboardService.switchPlayer();
    this.gameboardService.getAiMove(this.player).subscribe((res: Gamestate) => this.gameboardService.gametest.boardstate = res.boardstate);
  }

}
