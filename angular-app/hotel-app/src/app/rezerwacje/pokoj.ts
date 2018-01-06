export class Pokoj {
  id: number;
  wielkosc: number;
  numerPokoju: string;
  constructor(id: number, wielkosc: number, numerPokoju: string){
    this.id = id;
    this.numerPokoju = numerPokoju;
    this.wielkosc = wielkosc;
  }
}
