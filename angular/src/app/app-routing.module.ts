import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { GameSettingsComponent } from './game-settings/game-settings.component';
import { GameboardComponent } from './gameboard/gameboard.component';
import { LoginModalComponent } from './login-modal/login-modal.component';
import { ScoreboardComponent } from './scoreboard/scoreboard.component';

const routes: Routes = [
  {path: 'settings', component: GameSettingsComponent},
  {path: 'login', component: LoginModalComponent},
  {path: 'game', component: GameboardComponent},
  //for routing of the setting btn in scoreboard
  {path: 'game/settings', component: GameSettingsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
