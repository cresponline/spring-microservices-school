import { Student } from './student';
import { Exam } from './exam';

export class Course {
  id: number;
  name: string;
  createAt: string;
  students: Student[] = [];
  exams: Exam[] = [];
}
