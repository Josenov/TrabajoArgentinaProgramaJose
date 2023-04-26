import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NuevoSkillComponent } from './nuevo-skill.component';

describe('NuevoSkillComponent', () => {
  let component: NuevoSkillComponent;
  let fixture: ComponentFixture<NuevoSkillComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NuevoSkillComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NuevoSkillComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
