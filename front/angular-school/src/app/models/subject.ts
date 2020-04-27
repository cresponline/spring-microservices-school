export class Subject {
  id: number;
  name: string;
  superSubject: Subject;
  subSubjects: Subject[] = [];
}
