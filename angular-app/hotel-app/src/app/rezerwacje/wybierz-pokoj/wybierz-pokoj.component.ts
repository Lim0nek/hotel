import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {RezerwacjeService} from "../rezerwacje.service";
import {Wyszukiwanie} from "../wyszukiwanie";
import {Pokoj} from "../pokoj";
import {Rezerwacja} from "../rezerwacja";

@Component({
  selector: 'app-wybierz-pokoj',
  templateUrl: './wybierz-pokoj.component.html',
  styleUrls: ['./wybierz-pokoj.component.css'],
  providers: [RezerwacjeService]
})
export class WybierzPokojComponent implements OnInit {

  wyszukiwanieForm: FormGroup;
  rezerwacjaForm: FormGroup;
  pokoje: Pokoj[];
  nastepnyEtap: boolean;

  constructor(private router: Router,
              private rezerwacjeService: RezerwacjeService) { }

  ngOnInit() {
    this.nastepnyEtap = false;
    this.wyszukiwanieForm = new FormGroup({
      wielkosc: new FormControl('', Validators.required),
      dataPoczatku: new FormControl('', Validators.required),
      dataKonca: new FormControl('', Validators.required)
    });
  }

  onSubmit(){
    if (this.wyszukiwanieForm.valid) {
      let dateP = new Date(this.wyszukiwanieForm.controls['dataPoczatku'].value);
      let dateK = new Date(this.wyszukiwanieForm.controls['dataKonca'].value);
      let wyszukiwanie: Wyszukiwanie = new Wyszukiwanie(
        this.wyszukiwanieForm.controls['wielkosc'].value,
        dateP,
        dateK);

      this.rezerwacjeService.findWolnePokoje(wyszukiwanie).subscribe(
        pokoj => {
          this.pokoje = pokoj;
        },
        err=>{
          console.log(err);
        }
      );
    }
  }
  makeReservation(pokoj: Pokoj){
    this.nastepnyEtap = true;
    let dateP = new Date(this.wyszukiwanieForm.controls['dataPoczatku'].value);
    let dateK = new Date(this.wyszukiwanieForm.controls['dataKonca'].value);
    this.rezerwacjaForm = new FormGroup({
      pokojRezerwowany: new FormControl(pokoj, Validators.required),
      dataPoczatku: new FormControl(dateP, Validators.required),
      dataKonca: new FormControl(dateK, Validators.required),
      imie:  new FormControl('', Validators.required),
      nazwisko:  new FormControl('', Validators.required)
    });
  }

  onSubmit2(){
    let rezerwacja: Rezerwacja = new Rezerwacja(
      this.rezerwacjaForm.controls['pokojRezerwowany'].value,
      this.rezerwacjaForm.controls['imie'].value,
      this.rezerwacjaForm.controls['nazwisko'].value,
      this.rezerwacjaForm.controls['dataPoczatku'].value,
      this.rezerwacjaForm.controls['dataKonca'].value,
    );
    this.rezerwacjeService.makeReservation(rezerwacja).subscribe();
    this.rezerwacjaForm.reset();
    this.wyszukiwanieForm.reset();
    this.router.navigate(['/'])
  }

}
