import {Pokoj} from "./pokoj";

export class Rezerwacja {
  pokoj: Pokoj;
  imie: string;
  nazwisko: string;
  dataPoczatku: Date;
  dataKonca: Date;
  constructor(pokoj: Pokoj, imie: string, nazwisko: string, dataPoczatek: Date, dataKonca: Date){
    this.pokoj = pokoj;
    this.imie = imie;
    this.nazwisko = nazwisko;
    this.dataPoczatku = dataPoczatek;
    this.dataKonca = dataKonca;
  }
}
