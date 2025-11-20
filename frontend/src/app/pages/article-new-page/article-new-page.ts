import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ArticleService } from '../../core/article-service/article-service';
import { NewArticle } from '../../core/models/new-article';
import { QuillModule } from 'ngx-quill';

@Component({
  selector: 'app-article-new-page',
  imports: [QuillModule, FormsModule],
  templateUrl: './article-new-page.html',
  styleUrl: './article-new-page.css'
})
export class ArticleNewPage {

  constructor(private articleService : ArticleService){}

  article : NewArticle = {
    title: '',
    content: ''
  };

  editorModules = {
    toolbar: [
      ['bold', 'italic', 'underline', 'strike'],
      ['blockquote', 'code-block'],
      [{ 'header': 1 }, { 'header': 2 }],
      [{ 'list': 'ordered'}, { 'list': 'bullet' }],
      [{ 'header': [1, 2, 3, 4, 5, 6, false] }],
      ['link', 'image'],
      ['clean']
    ],
    imageResize: {
      modules: ['Resize', 'DisplaySize']
    }
  };

  onSubmit() {
    console.log('Article object:', this.article);
    console.log('Content value:', this.article.content);
    this.articleService.postArticle(this.article).subscribe(res => {
      console.log('New Article:', res);
    });
  }

}