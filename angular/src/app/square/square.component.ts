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
  constructor(public gameboardService:GameBoardService) { }

  ngOnInit(): void {
  }

  changeState(){
    //call switch player
    let player = this.gameboardService.switchPlayer();
    //call update board
    this.gameboardService.updateBoard(this.row,this.col,player);
    //ai auto move(right now just ramdom move)
    if(player == 'X' && !this.gameboardService.endgame){
      this.gameboardService.updateBoard(0,0,'O');
      let player = this.gameboardService.switchPlayer();
    }
  }

}
