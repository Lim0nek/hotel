import { Injectable } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Http, Response} from "@angular/http";
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import {Pokoj} from "./pokoj";
import {Wyszukiwanie} from "./wyszukiwanie";
import {Rezerwacja} from "./rezerwacja";
import {ElementListyRezerwacji} from "./elementListyRezerwacji";

@Injectable()
export class RezerwacjeService {

  private apiUrlWyszukiwanie = 'http://localhost:8080/pokojeWolne';
  private apiUrlRezerwacja = 'http://localhost:8080/dokonajRezerwacji';
  private apiUrlListaRezerwacji = 'http://localhost:8080//pobierzRezerwacje';
  private apiUrlUsunRezerwacja = 'http://localhost:8080/usunRezerwacje/';

  constructor(private http: Http) { }

  findWolnePokoje(wyszukiwanie: Wyszukiwanie): Observable<Pokoj[]> {
    return this.http.post(this.apiUrlWyszukiwanie, wyszukiwanie)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }

  makeReservation(rezerwacja: Rezerwacja): Observable<Rezerwacja>{
    return this.http.post(this.apiUrlRezerwacja, rezerwacja)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }

  getRezerwacje(): Observable<ElementListyRezerwacji[]>{
    return this.http.get(this.apiUrlListaRezerwacji)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }

  deleteRezerwacja(id: number): Observable<boolean>{
    return this.http.delete(this.apiUrlUsunRezerwacja+id)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }



}
