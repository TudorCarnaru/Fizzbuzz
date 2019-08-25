import { Component } from '@angular/core';
import {MainService} from "./services/Main.service";
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'FizzBuzz!';
  fizzBuzzForm: FormGroup;

  currentString: Array<string>;
  currentStatistics: Map<string, number>;


  constructor(private mainService: MainService) {
    this.fizzBuzzForm = new FormBuilder().group({
      lowerInput: [],
      upperInput: [],
      outputString: [],
      outputFizz: [],
      outputBuzz: [],
      outputFizzBuzz: [],
      outputAlfresco: [],
      outputInteger: [],
    })
  }

  ngOnInit(){
  }

  public getFizzBuzz() {
    this.mainService.getFizzBuzzResult(this.fizzBuzzForm.controls.lowerInput.value, this.fizzBuzzForm.controls.upperInput.value).subscribe(response =>{
      console.log(response);
      this.fizzBuzzForm.controls.outputString.setValue(response.outputString.toString());
      this.fizzBuzzForm.controls.outputFizz.setValue(response.outputStatistics["fizz"]);
      this.fizzBuzzForm.controls.outputBuzz.setValue(response.outputStatistics["buzz"]);
      this.fizzBuzzForm.controls.outputFizzBuzz.setValue(response.outputStatistics["fizzbuzz"]);
      this.fizzBuzzForm.controls.outputAlfresco.setValue(response.outputStatistics["alfresco"]);
      this.fizzBuzzForm.controls.outputInteger.setValue(response.outputStatistics["integer"]);
    }, error => {
      if(error.status==400) {
        console.log(error);
        this.fizzBuzzForm.controls.outputString.setValue(error.error);
      }
    })
  }

}
