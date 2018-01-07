import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RezerwacjeRoutingModule } from './rezerwacje-routing.module';
import { WybierzPokojComponent } from './wybierz-pokoj/wybierz-pokoj.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { UsunRezerwacjeComponent } from './usun-rezerwacje/usun-rezerwacje.component';

@NgModule({
  imports: [
    CommonModule,
    RezerwacjeRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  declarations: [WybierzPokojComponent, UsunRezerwacjeComponent]
})
export class RezerwacjeModule { }
