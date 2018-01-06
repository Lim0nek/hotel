export class Wyszukiwanie{
  wielkosc: number;
  dataPoczatku: Date;
  dataKonca: Date;
  constructor(wielkosc: number, dataPoczatku: Date, dataKonca: Date){
    this.dataKonca = dataKonca;
    this.dataPoczatku = dataPoczatku;
    this.wielkosc = wielkosc;

  }
}
