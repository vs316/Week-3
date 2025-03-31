package DSA.LinkedLists;

import java.util.Objects;

class StudentNode {
    String rollNumber;
    String name;
    Integer age;
    Character grade;
    StudentNode next;

    public StudentNode(String rollNumber, String name, Integer age, Character grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }

}

class StudentLinkedList {
    private StudentNode head;

    public void addStudentAtBeginning(String rollNumber, String name, Integer age, Character grade) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    public void addStudentAtEnd(String rollNumber, String name, Integer age, Character grade) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        if (head == null) {//if SLL empty
            head = newNode;
        } else {
            StudentNode temp = head;
            while (temp.next != null) {//traverse till the end of the list
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void addStudentAtSpecificPosition(String rollNumber, String name, Integer age, Character grade, int position) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        if (position == 1) {
            addStudentAtBeginning(rollNumber, name, age, grade);
            return;
        }
        StudentNode temp = head;
        for (int i = 1; i < position - 1; i++) {
            if (temp.next == null) throw new IndexOutOfBoundsException("Invalid position");
            temp = temp.next;
        }//once loop ends , the temp var points to the node just before the insertion position
        newNode.next = temp.next;
        temp.next = newNode;

    }

    public void deleteStudentRecordByRollNumber(String rollNumber) {
        if (head == null) {//empty list
            System.out.println("List is empty.");
            return;
        }
        if (head.rollNumber.equals(rollNumber)) {//if rollno points to first element
            head = head.next;
            return;
        }
        StudentNode temp = head;
        while (temp.next != null && !temp.next.rollNumber.equals(rollNumber)) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Student record not found.");
        } else {
            temp.next = temp.next.next;
        }
    }
    public StudentNode searchStudentByRollNumber(String rollNumber){
        StudentNode temp=head;
        while (temp!=null){
            if(Objects.equals(temp.rollNumber, rollNumber)){
                return temp;
            }
            temp=temp.next;
        }
        return null;
    }
    public void displayAllStudentRecords(){
        if(head==null){
            System.out.println("No records to display.");
            return;
        }
        StudentNode temp=head;
        while(temp!=null){
            System.out.println("Roll Number: "+temp.rollNumber+ ", Name: "+temp.name+", Age: "+temp.age+", Grade: "+temp.grade);
            temp=temp.next;
        }
    }
    public void updateStudentGradeBasedOnRollNumber(String rollNumber, Character grade){
        StudentNode studentDetails=searchStudentByRollNumber(rollNumber);
        if(studentDetails==null){
            System.out.println("Student not found with roll number: "+rollNumber);
            return;
        }
        studentDetails.grade=grade;
        System.out.println("New Grade for student with rollNumber: "+rollNumber+" is: "+ studentDetails.grade);
    }
}

public class StudentRecordManagement {
    public static void main(String[] args) {

        StudentLinkedList studentLinkedList=new StudentLinkedList();
        studentLinkedList.addStudentAtEnd("RA2111028010148","Abhishek",23,'A');
        studentLinkedList.addStudentAtBeginning("RA2111028010157","Aj",23,'O');
        studentLinkedList.addStudentAtSpecificPosition("RA2111028010020","Ava",22,'A',2);
        studentLinkedList.searchStudentByRollNumber("RA2111028010157");
        studentLinkedList.displayAllStudentRecords();
        studentLinkedList.updateStudentGradeBasedOnRollNumber("RA2111028010148",'O');
        studentLinkedList.displayAllStudentRecords();
    }
}