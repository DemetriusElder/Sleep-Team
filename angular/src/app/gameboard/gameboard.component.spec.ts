<<<<<<< HEAD
=======

>>>>>>> 2beec1e0ebcbec8f5d84b15908ecc22aca78d058
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { GameBoardService } from '../gameboard-service/gameboard.service';

import { GameboardComponent } from './gameboard.component';

describe('GameboardComponent', () => {
  let component: GameboardComponent;
  let fixture: ComponentFixture<GameboardComponent>;
  let service: GameBoardService;
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports:[HttpClientTestingModule],
      declarations: [ GameboardComponent ],
      providers:[
        GameBoardService,
      ]
    })
    .compileComponents();


    fixture = TestBed.createComponent(GameboardComponent);
    component = fixture.componentInstance;
    service = TestBed.inject(GameBoardService);
<<<<<<< HEAD
=======

>>>>>>> 2beec1e0ebcbec8f5d84b15908ecc22aca78d058
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('reset should be called when reset', () =>{
    // const spy = spyOn(component,'aiMode').and.callThrough();
    const spyOnService = spyOn(service,'newGame').and.callThrough();
    component.reset();
    expect(spyOnService).toHaveBeenCalled();
    // expect(spy).toHaveBeenCalled();
  });
});
