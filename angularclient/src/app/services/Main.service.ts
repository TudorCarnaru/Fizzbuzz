import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

import {map} from "rxjs/operators";
import {FizzBuzzRequestDto} from "../entities/FizzBuzzRequestDto";
import {FizzBuzzResponseDto} from "../entities/FizzBuzzResponseDto";

@Injectable()
export class MainService {

  constructor(private _http: HttpClient) { }

  getFizzBuzzResult(lowerBound: string, upperBound: string) {
    let requestData = new FizzBuzzRequestDto();
    requestData.lowerBound = lowerBound;
    requestData.upperBound = upperBound;



    const url = "http://localhost:8181/fizzBuzz";

    return this._http.post(url, requestData).pipe(map((response: FizzBuzzResponseDto) => response));
  }

}
