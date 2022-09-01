import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddBranchmanagerComponent } from './add-branchmanager.component';

describe('AddBranchmanagerComponent', () => {
  let component: AddBranchmanagerComponent;
  let fixture: ComponentFixture<AddBranchmanagerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddBranchmanagerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddBranchmanagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
