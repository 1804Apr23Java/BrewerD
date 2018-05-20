import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bear',
  templateUrl: './bear.component.html',
  styleUrls: ['./bear.component.css']
})
export class BearComponent {

  bear = [ {name : 'InterpolatedBear', type : 'Grizzly' }, {name: '', type: ''}, {} ];

  // for interpolation
  interpolatedBear = this.bear[0].name;

  // for property binding
  public bearStyle = {
    
    color: 'red',
    border: '1px solid black',
    margin: '2px'

  };
  public changeStyles(): void {
    if(this.bearStyle.color === 'red') {
      this.bearStyle.color = 'green';
    } else if(this.bearStyle.color === 'green') {
      this.bearStyle.color = 'red';
    }
  }

  // for two-way binding
  // we'll set properties of this.bears[1] dynamically

}
