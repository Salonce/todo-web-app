import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-article-new-page',
  imports: [FormsModule],
  templateUrl: './article-new-page.html',
  styleUrl: './article-new-page.css'
})
export class ArticleNewPage {

    article = {
    title: '',
    text: ''
  };

  onSubmit() {
    console.log('New Article:', this.article);
  }

}
