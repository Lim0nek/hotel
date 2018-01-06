import { TestBed, inject } from '@angular/core/testing';

import { RezerwacjeService } from './rezerwacje.service';

describe('RezerwacjeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RezerwacjeService]
    });
  });

  it('should be created', inject([RezerwacjeService], (service: RezerwacjeService) => {
    expect(service).toBeTruthy();
  }));
});
