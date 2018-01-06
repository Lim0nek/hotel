import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RezerwacjeRoutingModule } from './rezerwacje-routing.module';
import { WybierzPokojComponent } from './wybierz-pokoj/wybierz-pokoj.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

@NgModule({
  imports: [
    CommonModule,
    RezerwacjeRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  declarations: [WybierzPokojComponent]
})
export class RezerwacjeModule { }
