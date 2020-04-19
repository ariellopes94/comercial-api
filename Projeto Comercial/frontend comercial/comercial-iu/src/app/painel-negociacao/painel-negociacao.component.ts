import { Oportunidade } from './../model/Oportunidade';
import { OportunidadesService } from './../service/oportunidades.service';
import { Component, OnInit } from '@angular/core';
import { empty } from 'rxjs';



@Component({
  selector: 'app-painel-negociacao',
  templateUrl: './painel-negociacao.component.html',
  styleUrls: ['./painel-negociacao.component.css']
})
export class PainelNegociacaoComponent implements OnInit {



  oportunidades = [];

  oportunidade = new Oportunidade();
  constructor(private oportunidadesService: OportunidadesService) {


  }



  ngOnInit(): void {
    this.consultar();
  }

  consultar() {
    this.oportunidadesService.listar()
      .subscribe(resposta => this.oportunidades = <any>resposta);
  }

  adicionar(){
    this.oportunidadesService.adicionar(this.oportunidade).
         subscribe(() => {
           this.oportunidade = new Oportunidade();
           this.consultar();
         });
  }
}
