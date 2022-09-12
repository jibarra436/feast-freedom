import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Kitchen } from '../models/kitchen';


@Injectable()
export class KitchenService {

  private kUrl: string;

  constructor(private http: HttpClient) {
    this.kUrl = 'http://localhost:8080/api/createkitchen';
  }

 

  public save(kit: Kitchen) {
    return this.http.post<Kitchen>(this.kUrl, kit);
  }
}
