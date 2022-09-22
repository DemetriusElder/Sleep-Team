import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-game-settings',
  templateUrl: './game-settings.component.html',
  styleUrls: ['./game-settings.component.css']
})
export class GameSettingsComponent implements OnInit {
  player!: string;
  submitChar: any;
  char!: string;
  submitDiff: any;
  
  settingsForm = new FormGroup({
    char: new FormControl('', [Validators.required]),
    difficulty: new FormControl('', [Validators.required])
  });
  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.submitChar = Object.assign({},this.settingsForm.value.char);
    this.char = this.submitChar[0];
    console.log(this.char);
    localStorage.setItem('X', JSON.stringify(this.char));
    //this.submitDiff = Object.assign({},this. settingsForm.value.difficulty);
    this.router.navigate(['game']);
    //also need this method to send to the back end which character the api is using 
  }

}
