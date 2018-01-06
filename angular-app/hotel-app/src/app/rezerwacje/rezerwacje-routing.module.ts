import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {WybierzPokojComponent} from "./wybierz-pokoj/wybierz-pokoj.component";

const routes: Routes = [
  {path: 'wybierz-pokoj', component: WybierzPokojComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RezerwacjeRoutingModule { }
