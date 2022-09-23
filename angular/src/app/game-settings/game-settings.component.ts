import { Component, OnInit, Output } from '@angular/core';
import { GameBoardService } from '../gameboard-service/gameboard.service';

@Component({
  selector: 'app-game-settings',
  templateUrl: './game-settings.component.html',
  styleUrls: ['./game-settings.component.css']
})
export class GameSettingsComponent implements OnInit {
  
  constructor(private gameboardService:GameBoardService) { }

  ngOnInit(): void {
    //switch here for different mode: AI vs human or human vs human
   this.settingAi();
   //this.settingHuman();
  }

  settingHuman(){
        //edit here for differnt player, who go first
        console.log("HUMAN setting");
        this.gameboardService.newGame();
        this.gameboardService.setCurrent("X");
        this.gameboardService.setPlayer1("HUMAN","X");
        this.gameboardService.setPlayer2("HUMAN","O");
        this.gameboardService.setMode("HUMAN");
        
  }
  settingAi(){
    //edit here for differnt player, who go first
    console.log("AI setting");
    this.gameboardService.newGame();
    this.gameboardService.setCurrent("X");
    this.gameboardService.setPlayer1("AI","X");
    this.gameboardService.setPlayer2("HUMAN","O");
    this.gameboardService.setMode("AI");
    //
}

}
