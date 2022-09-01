import { TestBed } from '@angular/core/testing';

import { OrderitemdetailService } from './orderitemdetail.service';

describe('OrderitemdetailService', () => {
  let service: OrderitemdetailService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OrderitemdetailService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
