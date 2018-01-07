import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UsunRezerwacjeComponent } from './usun-rezerwacje.component';

describe('UsunRezerwacjeComponent', () => {
  let component: UsunRezerwacjeComponent;
  let fixture: ComponentFixture<UsunRezerwacjeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UsunRezerwacjeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UsunRezerwacjeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
