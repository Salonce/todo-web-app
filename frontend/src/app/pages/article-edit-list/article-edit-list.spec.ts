import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticleEditList } from './article-edit-list';

describe('ArticleEditList', () => {
  let component: ArticleEditList;
  let fixture: ComponentFixture<ArticleEditList>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ArticleEditList]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ArticleEditList);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
