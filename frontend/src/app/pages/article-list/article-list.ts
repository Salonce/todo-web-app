import { Component, Input } from '@angular/core';
import { Article } from '../../core/models/article';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-article-list',
  imports: [CommonModule],
  templateUrl: './article-list.html',
  styleUrl: './article-list.css'
})
export class ArticleList {

  @Input() articles : Article[] = [];

  getPreview = (content: string): string => {
    if (!content) return '';
    const sentences = content.split(/(?<=[.!?])\s+/);
    return sentences.slice(0, 3).join(' ');
  };
}
