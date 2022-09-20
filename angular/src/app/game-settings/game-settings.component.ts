import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-game-settings',
  templateUrl: './game-settings.component.html',
  styleUrls: ['./game-settings.component.css']
})
export class GameSettingsComponent implements OnInit {
  
  settingsForm = new FormGroup({
    playerName: new FormControl('', [
      Validators.required,
      Validators.minLength(2),
    ]),
   
  });
  constructor() { }

  ngOnInit(): void {
  }

}
