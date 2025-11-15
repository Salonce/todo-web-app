import { Component } from '@angular/core';
import { ArticleService } from '../../core/article-service/article-service';
import { Observable } from 'rxjs/internal/Observable';
import { Page } from '../../core/models/page';
import { Article } from '../../core/models/article';

@Component({
  selector: 'app-home-page',
  imports: [],
  templateUrl: './home-page.html',
  styleUrl: './home-page.css'
})
export class HomePage {
  
  $articlesPage: Observable<Page<Article>>;

  constructor(private articleService : ArticleService){
    this.$articlesPage = articleService.getArticles();
  }
}
