import { Component, Input, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { GameBoardService } from '../gameboard-service/gameboard.service';
import { LoginModalComponent } from '../login-modal/login-modal.component';

@Component({
  selector: 'app-scoreboard',
  templateUrl: './scoreboard.component.html',
  styleUrls: ['./scoreboard.component.css']
})
export class ScoreboardComponent implements OnInit {
  //I moved the score update to html

  constructor(private modalService: NgbModal, public gameboardService:GameBoardService) {
   }

  ngOnInit(): void {
  }

  openLoginModal(){
    const modalRef = this.modalService.open(LoginModalComponent);
  }
}
