
import { TestBed } from '@angular/core/testing';

import { GameBoardService } from './gameboard.service';
import {HttpClientTestingModule, HttpTestingController} from '@angular/common/http/testing'
describe('GameBoardService', () => {
  let service: GameBoardService;
  let httpTestingController: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports:[HttpClientTestingModule],
      providers:[
        GameBoardService,
      ]
    });
    service = TestBed.inject(GameBoardService);
    httpTestingController = TestBed.get(HttpTestingController)
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });


});
