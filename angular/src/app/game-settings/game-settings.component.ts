import { GameBoardService } from '../gameboard-service/gameboard.service';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-game-settings',
  templateUrl: './game-settings.component.html',
  styleUrls: ['./game-settings.component.css']
})
export class GameSettingsComponent implements OnInit {
  
  constructor(private gameboardService:GameBoardService, private router: Router) { }
  settingsForm = new FormGroup({
    mode: new FormControl('', [Validators.required]),
    first: new FormControl('', [Validators.required]),
    player1: new FormControl('', [Validators.required]),
    difficulty: new FormControl('', [Validators.required])
  });
  
  ngOnInit(): void {

  }
  
  //todo: check make sure user can only press submit when the form is filled 
  onSubmit() {
      let mode = this.settingsForm.get('mode')!.value;
      let player1char = this.settingsForm.get('player1')!.value;
      let first = this.settingsForm.get('first')!.value;
      this.gameboardService.newGame();
      this.gameboardService.setCurrent(first!);
      //init both player with (user,mark,score) from formdata
      this.gameboardService.setPlayer1("HUMAN",player1char!,0);
      if(mode == "AI"){
      this.gameboardService.setPlayer2("AI",player1char==="X"?"O":"X",0);}
      else{
        this.gameboardService.setPlayer2("HUMAN",player1char==="X"?"O":"X",0);
      }
      //set gamemode(AI/HUMAN)
      this.gameboardService.setMode(mode!);
      this.router.navigate(['game']);

  }

}
