import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';


import { CreatekitchenComponent } from './createkitchen.component'; 

const routes: Routes = [
  { path: 'createkitchen', component: CreatekitchenComponent},
  { path: '**', redirectTo: ''}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {}
