import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticleManagementPage } from './article-management-page';

describe('ArticleManagementPage', () => {
  let component: ArticleManagementPage;
  let fixture: ComponentFixture<ArticleManagementPage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ArticleManagementPage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ArticleManagementPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
