import { ComponentFixture, ComponentFixtureAutoDetect, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';

import { GameSettingsComponent } from './game-settings.component';
import { GameBoardService } from '../gameboard-service/gameboard.service';
import { By } from '@angular/platform-browser';
import { compileNgModule } from '@angular/compiler';
import { RouterTestingModule } from '@angular/router/testing';
import { GameboardComponent } from '../gameboard/gameboard.component';

fdescribe('GameSettingsComponent', () => {
  let component: GameSettingsComponent;
  let fixture: ComponentFixture<GameSettingsComponent>;
  let service: GameBoardService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GameSettingsComponent ],
      imports: [HttpClientTestingModule, RouterTestingModule.withRoutes([
        { path: 'game', component: GameboardComponent}
    ])],
      providers: [GameBoardService]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GameSettingsComponent);
    component = fixture.componentInstance;
    service = TestBed.inject(GameBoardService);
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('submitted should be false on initialization', () => {
    expect(component.submitted).toBeFalsy();
  });

  it('form should be invalid when values are not present', () => {
    expect(component.settingsForm.valid).toBeFalsy();
  })

  it('form valid when values present', () => {
    //arrange 
    const dummyData = {
      mode: 'AI',
      first: 'X',
      player1: 'X',
      difficulty: 'easy'
    };

    //act
    component.settingsForm.patchValue(dummyData);
    fixture.detectChanges();

    //assert
    expect(component.settingsForm.valid).toBeTruthy();
  });

  it('onSubmit called on ngSubmit', () => {
    const dummyData = {
      mode: 'AI',
      first: 'X',
      player1: 'X',
      difficulty: 'easy'
    };
    const el = fixture.debugElement.query(By.css('.settingsForm'));
    const func = spyOn(component, 'onSubmit');

    el.triggerEventHandler('ngSubmit', null);

    expect(func).toHaveBeenCalled();
  });

  it('onSubmit calls gameboardService', () => {
    let func = spyOn(service, 'newGame').and.callThrough();
    component.onSubmit();
    
    expect(func).toHaveBeenCalled();

  });

  it('should set player2 to O if player1 is X', () => {
    const dummyData = {
      mode: 'AI',
      first: 'X',
      player1: 'X',
      difficulty: 'easy'
    };
    component.settingsForm.patchValue(dummyData);
    let func = spyOn(service, 'setPlayer2').
    and.callThrough();
    component.onSubmit();
    expect(component.settingsForm.get('player1')?.value).toEqual("X");
  });

  it('should set player 2 to X if player1 is O', () => {
    const dummyData = {
      mode: 'AI',
      first: 'O',
      player1: 'O',
      difficulty: 'easy'
    };
    component.settingsForm.patchValue(dummyData);
    let func = spyOn(service, 'setPlayer2').and.callThrough();
    component.onSubmit;
    expect(component.settingsForm.get('player1')?.value).toEqual("O");
  })

});
