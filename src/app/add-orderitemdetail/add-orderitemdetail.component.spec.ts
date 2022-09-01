import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddOrderitemdetailComponent } from './add-orderitemdetail.component';

describe('AddOrderitemdetailComponent', () => {
  let component: AddOrderitemdetailComponent;
  let fixture: ComponentFixture<AddOrderitemdetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddOrderitemdetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddOrderitemdetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
