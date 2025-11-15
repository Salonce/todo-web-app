import { Article } from "./article";
import { Pageable } from "./pageable";
import { Sort } from "./sort";

export interface Page<T> {
  content: Article[];             // array of your DTOs
  pageable: Pageable;
  totalElements: number;
  totalPages: number;
  last: boolean;
  first: boolean;
  numberOfElements: number;
  size: number;
  number: number;
  sort: Sort;
  empty: boolean;
}