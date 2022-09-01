import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditBranchmanagerComponent } from './edit-branchmanager.component';

describe('EditBranchmanagerComponent', () => {
  let component: EditBranchmanagerComponent;
  let fixture: ComponentFixture<EditBranchmanagerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditBranchmanagerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditBranchmanagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
