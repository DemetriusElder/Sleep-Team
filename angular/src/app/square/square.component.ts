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
    let player = this.gameboardService.switchPlayer();
    this.gameboardService.updateBoard(this.row,this.col,player);
  }
}
