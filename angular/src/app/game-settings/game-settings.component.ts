import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ScoreboardComponent } from '../scoreboard/scoreboard.component';

@Component({
  selector: 'app-game-settings',
  templateUrl: './game-settings.component.html',
  styleUrls: ['./game-settings.component.css']
})
export class GameSettingsComponent implements OnInit {
  player!: string;
  
  settingsForm = new FormGroup({
    char: new FormControl('', [Validators.required]),
    difficulty: new FormControl('', [Validators.required])
  });
  constructor() { }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log(this.settingsForm.value.char);
    console.log(this.settingsForm.value.difficulty);
  }

}
