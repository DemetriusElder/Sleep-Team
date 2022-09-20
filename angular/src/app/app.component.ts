import { Component } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { LoginModalComponent } from './login-modal/login-modal.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'tictactoe';

  constructor(private modalService: NgbModal){
    
  }

  openLoginModal(){
    const modalRef = this.modalService.open(LoginModalComponent);
  }

}
