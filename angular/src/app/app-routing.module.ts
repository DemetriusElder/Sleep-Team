import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { GameSettingsComponent } from './game-settings/game-settings.component';
import { ScoreboardComponent } from './scoreboard/scoreboard.component';

const routes: Routes = [
  {path: 'settings', component: GameSettingsComponent},
  //{path: '', component: AppComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
