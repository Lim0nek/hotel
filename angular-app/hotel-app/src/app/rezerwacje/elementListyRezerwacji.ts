
export class ElementListyRezerwacji {
  id: number;
  dataPrzyjazdu: Date;
  dataOdjazdu: Date;
  numerPokoju: number;

  constructor(id: number, dataPrzyjazdu: Date, dataOdjazdu:Date, numerPokoju: number){
    this.id = id;
    this.dataPrzyjazdu = dataPrzyjazdu;
    this.dataOdjazdu = dataOdjazdu;
    this.numerPokoju = numerPokoju;

  }
}
