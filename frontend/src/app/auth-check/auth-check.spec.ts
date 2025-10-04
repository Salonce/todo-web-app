import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthCheckComponent } from './auth-check';

describe('AuthCheck', () => {
  let component: AuthCheckComponent;
  let fixture: ComponentFixture<AuthCheckComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AuthCheckComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AuthCheckComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
