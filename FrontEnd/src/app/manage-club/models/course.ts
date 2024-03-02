import { Specialite } from 'app/manage-university/models/specialite';

export class Club {
  idCourse: number | null;
  courseTitle: String;
  courseDescription: String;
  imgUrl: String;
  groupTime: Date;
  meetTime: Date;
  meetUrl: Date;
  evenements: any[];
  specialite: any;
}
