

import java.util.ArrayList;

public class BootCampAdministration {

	//Create a private ArrayList with object of BootCampCandidates with name anArrayListOfBootCamps
	private ArrayList<BootCampCandidates> anArrayListOfBootCamps;
	
	//Create a constructor which receives an array with BootCampCandidate objects and 
	//initializes the anArrayListOfBootCamps ArrayList by adding all BootCampCandidates array's
	//elements in the the anArrayListOfBootCamps
	BootCampAdministration(BootCampCandidates[] theo){
		anArrayListOfBootCamps= new ArrayList<>();
		for (int i=0;i<theo.length;i++){
			anArrayListOfBootCamps.add(theo[i]);
		}
	}

	
	//Create setters and getters for BootCampAdministration
	public void setAnArrayListOfBootCamps(BootCampCandidates[] theo){
		for (int i=0;i<theo.length;i++){
			anArrayListOfBootCamps.add(theo[i]);
		}
	}
	
	public ArrayList<BootCampCandidates> getanArrayListOfBootCamps(){
		return this.anArrayListOfBootCamps;
	}
	
	//create an int method that returns the size of anArrayListOfBootCamps
	
	public int size(){
		
		return this.anArrayListOfBootCamps.size();
	}
	
	//Create a method that adds a new BootCampCandidate inside the ArrayList
	public void add(BootCampCandidates bootcampcandidate){
		anArrayListOfBootCamps.add(bootcampcandidate);
	}
	
	//Create a method that removes a candidate by name and returns true if found or false if not
	//HINT: you have to use get() to get the object and equals to compare it
	public boolean remove(String name){
		for(int i=0;i<anArrayListOfBootCamps.size();i++){
			if (anArrayListOfBootCamps.get(i).getName().equals(name)){
				anArrayListOfBootCamps.remove(i);
				return true;
			}
			}
		return false;
		}
	
	
	//Create a method to search for a boot camp member by surname and returns a string with its information
	// if it's found and null if it's not found
	 public String search(String surname){
		 for (int i=0;i<anArrayListOfBootCamps.size();i++){
			 if (anArrayListOfBootCamps.get(i).getSurname().equals(surname)){
				 return anArrayListOfBootCamps.get(i).toString();
			 }
		 }
		 return null;
	 }
	
	
	//Create a method that can change a bootcampers age by having as input its name and surname
	 public void change(String name, String surname,int age){
		 for (int i=0;i<anArrayListOfBootCamps.size();i++){
			 if (anArrayListOfBootCamps.get(i).getSurname().equals(surname)){
				 if (anArrayListOfBootCamps.get(i).getName().equals(name)){
					 anArrayListOfBootCamps.get(i).setAge(age);
				 }
			 }
		 }
		 
		 
	 }
	 
	
}
