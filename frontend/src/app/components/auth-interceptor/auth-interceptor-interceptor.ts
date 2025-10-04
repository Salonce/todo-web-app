import { HttpEvent, HttpInterceptorFn, HttpRequest } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';

export const authInterceptor: HttpInterceptorFn = (req: HttpRequest<any>, next) => {
  return next(req).pipe(
    catchError(err => {
      if (err.status === 401 || err.status === 403) {
        window.location.href = 'http://localhost:8080/oauth2/authorization/google';
      }
      return throwError(() => err);
    })
  );
};