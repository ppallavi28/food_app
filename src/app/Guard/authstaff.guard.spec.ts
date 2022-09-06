import { TestBed } from '@angular/core/testing';

import { AuthstaffGuard } from './authstaff.guard';

describe('AuthstaffGuard', () => {
  let guard: AuthstaffGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(AuthstaffGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
