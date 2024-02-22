import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-c2',
  templateUrl: './c2.component.html',
  styleUrls: ['./c2.component.css'],
})
export class C2Component implements OnInit {
  constructor() {}

  ngOnInit(): void {}

  c2 = [
    {
      id: 1,
      name: 'Angular',
      description:
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
      image: '../../assets/angular.png',
    },
    {
      id: 2,
      name: 'Javascript',
      description:
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
      image: '../../assets/javascript.png',
    },
    {
      id: 3,
      name: 'TypeScript',
      description:
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
      image: '../../assets/typescript.png',
    },
  ];
}
