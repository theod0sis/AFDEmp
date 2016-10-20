import java.util.*;

public class Employee {

  private String name;
  private String surname;
  private int birthyear;

  public void setName( String name){
    this.name=name;
  }
  public String getName(){
    return this.name;
  }
  public void setSurname( String surname){
    this.surname=surname ;
  }
  public String getSurname(){
    return (surname);
  }
  public void setBirthyear(int birthyear){
    this.birthyear=birthyear;
  }
  public int getBirthyear(){
    return this.birthyear;
  }
  public int age(){
    return ( 2016 - birthyear) ;
  }
  
  public String toString(){

    return( "Name: " + name + " Surname: " + surname + " birthyear: " + birthyear);
  }
}
