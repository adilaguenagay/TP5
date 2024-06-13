import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CommandeViewComponent } from './view/commande/commande-view/commande-view.component';
import { CommandeEditComponent } from './view/commande/commande-edit/commande-edit.component';
import { CommandeListComponent } from './view/commande/commande-list/commande-list.component';
import { CommandeCreateComponent } from './view/commande/commande-create/commande-create.component';
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    CommandeViewComponent,
    CommandeEditComponent
  ],
  imports: [
    HttpClientModule,
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    CommandeListComponent,
    CommandeCreateComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
