import { Component } from '@angular/core';
import { ArticleService } from '../../core/article-service/article-service';
import { NewArticle } from '../../core/models/new-article';
import { Observable } from 'rxjs/internal/Observable';

@Component({
  selector: 'app-home-page',
  imports: [],
  templateUrl: './home-page.html',
  styleUrl: './home-page.css'
})
export class HomePage {
  
  $articles: Observable<NewArticle[]>; // backend returns [] when there are no articles

  constructor(private articleService : ArticleService){
    this.$articles = articleService.getArticles();
  }

  
}
