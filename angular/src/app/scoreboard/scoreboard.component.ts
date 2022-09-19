import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-scoreboard',
  templateUrl: './scoreboard.component.html',
  styleUrls: ['./scoreboard.component.css']
})
export class ScoreboardComponent implements OnInit {
  player1score: number = 0;
  player2score: number = 0;

  constructor() { }

  ngOnInit(): void {
  }

}
