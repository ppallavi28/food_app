import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderitemdetailsComponent } from './orderitemdetails.component';

describe('OrderitemdetailsComponent', () => {
  let component: OrderitemdetailsComponent;
  let fixture: ComponentFixture<OrderitemdetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrderitemdetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderitemdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
