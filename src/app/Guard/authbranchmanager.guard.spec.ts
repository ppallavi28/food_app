import { TestBed } from '@angular/core/testing';

import { AuthbranchmanagerGuard } from './authbranchmanager.guard';

describe('AuthbranchmanagerGuard', () => {
  let guard: AuthbranchmanagerGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(AuthbranchmanagerGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
