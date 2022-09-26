import { Component } from '@angular/core';
import { ScoreboardComponent } from './scoreboard/scoreboard.component';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { LoginModalComponent } from './login-modal/login-modal.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'tictactoe';

  constructor(private modalService: NgbModal, private router: Router){
    this.router.navigate(['settings']);

  }

  openLoginModal(){
    const modalRef = this.modalService.open(LoginModalComponent);
  }

}
