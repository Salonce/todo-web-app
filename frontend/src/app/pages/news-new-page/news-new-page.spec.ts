import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewsNewPage } from './news-new-page';

describe('NewsNewPage', () => {
  let component: NewsNewPage;
  let fixture: ComponentFixture<NewsNewPage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NewsNewPage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewsNewPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
