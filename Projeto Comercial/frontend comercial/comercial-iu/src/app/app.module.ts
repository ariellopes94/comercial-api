import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { PainelNegociacaoComponent } from './painel-negociacao/painel-negociacao.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {PanelModule} from 'primeng/panel';
import {InputTextModule} from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {ToastModule} from 'primeng/toast';



@NgModule({
  declarations: [
    AppComponent,
    PainelNegociacaoComponent,
  ],

  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    BrowserModule,
    HttpClientModule,

    PanelModule,
    InputTextModule,
    ButtonModule,
    ToastModule
   
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
