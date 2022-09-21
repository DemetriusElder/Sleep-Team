import { Component, Input, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { LoginModalComponent } from '../login-modal/login-modal.component';

@Component({
  selector: 'app-scoreboard',
  templateUrl: './scoreboard.component.html',
  styleUrls: ['./scoreboard.component.css']
})
export class ScoreboardComponent implements OnInit {
  player1score: number = 0;
  player2score: number = 0;
   
  

  constructor(private modalService: NgbModal) { }

  ngOnInit(): void {
  }

  openLoginModal(){
    const modalRef = this.modalService.open(LoginModalComponent);
  }
}
