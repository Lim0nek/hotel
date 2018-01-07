import { Component, OnInit } from '@angular/core';
import {ElementListyRezerwacji} from "../elementListyRezerwacji";
import {RezerwacjeService} from "../rezerwacje.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-usun-rezerwacje',
  templateUrl: './usun-rezerwacje.component.html',
  styleUrls: ['./usun-rezerwacje.component.css'],
  providers: [RezerwacjeService]
})
export class UsunRezerwacjeComponent implements OnInit {
  rezerwacje: ElementListyRezerwacji[];

  constructor(private rezerwacjeService: RezerwacjeService,
              private router: Router) { }

  ngOnInit() {
    this.getAllRezerwacje();
  }


  getAllRezerwacje() {
    this.rezerwacjeService.getRezerwacje().subscribe(
      r => {
        this.rezerwacje = r;
      },
      err => {
        console.log(err);
      }
    );
  }

  deleteRezerwacja(id: number){
    this.rezerwacjeService.deleteRezerwacja(id).subscribe();
    location.reload();
  }


}
