import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GameSettingsComponent } from './game-settings/game-settings.component';
import { ScoreboardComponent } from './scoreboard/scoreboard.component';

@NgModule({
  declarations: [
    AppComponent,
    GameSettingsComponent,
    ScoreboardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
