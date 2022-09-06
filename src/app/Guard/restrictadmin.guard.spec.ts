import { TestBed } from '@angular/core/testing';

import { RestrictadminGuard } from './restrictadmin.guard';

describe('RestrictadminGuard', () => {
  let guard: RestrictadminGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(RestrictadminGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
