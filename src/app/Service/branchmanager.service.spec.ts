import { TestBed } from '@angular/core/testing';

import { BranchmanagerService } from './branchmanager.service';

describe('BranchmanagerService', () => {
  let service: BranchmanagerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BranchmanagerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
