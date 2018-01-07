import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {WybierzPokojComponent} from "./wybierz-pokoj/wybierz-pokoj.component";
import {UsunRezerwacjeComponent} from "./usun-rezerwacje/usun-rezerwacje.component";

const routes: Routes = [
  {path: 'wybierz-pokoj', component: WybierzPokojComponent},
  {path: 'usun-rezerwacje', component:UsunRezerwacjeComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RezerwacjeRoutingModule { }
