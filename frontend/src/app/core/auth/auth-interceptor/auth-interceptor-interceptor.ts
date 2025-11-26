import { HttpEvent, HttpInterceptorFn, HttpRequest, HttpResponse } from '@angular/common/http';
import { Observable, catchError, of, throwError } from 'rxjs';

export const authInterceptor: HttpInterceptorFn = (req: HttpRequest<any>, next) => {
  return next(req).pipe(
    catchError(err => {

      if (req.url.endsWith('/auth') || req.url.endsWith('/logout')) {
        return of(new HttpResponse({ body: null }));
      }

      if (err.status === 401) {
        window.location.href = 'http://localhost:8080/oauth2/authorization/google';
      }
      return throwError(() => err);
    })
  );
};