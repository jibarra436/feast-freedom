import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { KitchenService } from '../services/kitchen.service';
import { Kitchen } from '../models/kitchen';



@Component({ templateUrl: 'createkitchen.component.html' })
export class CreatekitchenComponent {
  kit: Kitchen
  constructor(
    private kservice: KitchenService
  ){
  this.kit = new Kitchen();
  }
  createkitchen(){
    this.kservice.save(this.kit);
  }
}
