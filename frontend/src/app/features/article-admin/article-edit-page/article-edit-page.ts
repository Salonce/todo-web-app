import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../../../core/article-service/article-service';
import { NewArticle } from '../../../core/models/new-article';
import Quill from 'quill';
import { QuillModule } from 'ngx-quill';
import { FormsModule } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';
import { Article } from '../../../core/models/article';
import { ArticleEdit } from '../../../core/models/article-edit';

@Component({
  selector: 'app-article-edit-page',
  imports: [QuillModule, FormsModule],
  templateUrl: './article-edit-page.html',
  styleUrl: './article-edit-page.css'
})
export class ArticleEditPage implements OnInit{

    constructor(private articleService : ArticleService, private route: ActivatedRoute){}
  
    id! : number;

    article  : ArticleEdit | null = null;;

    ngOnInit(): void {
      this.route.params.subscribe(params => {
        this.id = params['id'];
        this.loadArticle(this.id);
      });
    }
  
    loadArticle(id: number) {
      this.articleService.getArticleById(id).subscribe({
        next: (article: ArticleEdit) => {
          this.article = article;
        },
        error: (err) => {
          console.error('Failed to load article:', err);
        }
      });
    }
    
    onSubmit() {
      if (!this.article) return;

      this.articleService.editArticle(this.article).subscribe({
        next: res => console.log('Updated:', res),
        error: err => console.error('Failed to update:', err)
      });
    }
}
