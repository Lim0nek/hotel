import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WybierzPokojComponent } from './wybierz-pokoj.component';

describe('WybierzPokojComponent', () => {
  let component: WybierzPokojComponent;
  let fixture: ComponentFixture<WybierzPokojComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WybierzPokojComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WybierzPokojComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
