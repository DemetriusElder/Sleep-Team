import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GameSettingsComponent } from './game-settings/game-settings.component';
import { ScoreboardComponent } from './scoreboard/scoreboard.component';
import { GameboardComponent } from './gameboard/gameboard.component';
import { SquareComponent } from './square/square.component';
import { LoginModalComponent } from './login-modal/login-modal.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    GameSettingsComponent,
    ScoreboardComponent,
    GameboardComponent,
    SquareComponent,
    LoginModalComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    MatToolbarModule,
    NgbModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [GameSettingsComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
