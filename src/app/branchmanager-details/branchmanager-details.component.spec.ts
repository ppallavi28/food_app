import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BranchmanagerDetailsComponent } from './branchmanager-details.component';

describe('BranchmanagerDetailsComponent', () => {
  let component: BranchmanagerDetailsComponent;
  let fixture: ComponentFixture<BranchmanagerDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BranchmanagerDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BranchmanagerDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
