import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
 
import { AppComponent } from './app.component';
import { ProfileComponent } from './components/profile/profile.component';
import { LibraryComponent } from './components/library/library.component';

@NgModule({
  declarations: [
    AppComponent,
    ProfileComponent,
    LibraryComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
