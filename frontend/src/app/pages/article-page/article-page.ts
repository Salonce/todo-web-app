import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NewArticle } from '../../core/models/new-article';
import { ArticleService } from '../../core/article-service/article-service';

@Component({
  selector: 'app-article-page',
  imports: [],
  templateUrl: './article-page.html',
  styleUrl: './article-page.css'
})


export class ArticlePage implements OnInit {

  slug!: string;
  article!: NewArticle;

  constructor(private articleService: ArticleService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.slug = params['slug'];
      console.log('Current slug:', this.slug);
      this.loadArticle(this.slug);
    });
  }

  loadArticle(slug: string) {
    this.articleService.getArticleBySlug(slug).subscribe({
      next: (article: NewArticle) => {
        this.article = article;
      },
      error: (err) => {
        console.error('Failed to load article:', err);
      }
    });
  }

}