import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplaybillComponent } from './displaybill.component';

describe('DisplaybillComponent', () => {
  let component: DisplaybillComponent;
  let fixture: ComponentFixture<DisplaybillComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisplaybillComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplaybillComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
