/**
 * Adapted from Horstmann Big Java 5th ed.
 */

import java.util.ArrayList;

public class ChoiceQuestion extends Question {
	/*
	 * Code relies on the teacher/user stating whether they want multiple answers 
	 * selected/entered or just one answer entered. 
	 * If they want multiple correct answers, then they have to say "Select all" (case sensitive). 
	 */
	
	
	private ArrayList<String> choices;
	private ArrayList<Boolean> correctAnsws;
	private String answer;
	
	public ChoiceQuestion() {
		choices = new ArrayList<String>();
		correctAnsws = new ArrayList<Boolean>();
	}
	
	public void addChoice(String choice, boolean correct) {
		choices.add(choice);
		if (correct){
			correctAnsws.add(true);
		}
		else {
			correctAnsws.add(false);
		}
	}
	
	@Override
	public void setAnswer(String answ){
		answer = answ;
	}
	
	@Override
	public boolean isCorrect(String response){
		int counter = 0;
		for (int i = 0; i < correctAnsws.size(); i++){
			if (correctAnsws.get(i)){
				counter++;
			}
		}
		
		//all answers are correct
		if (choices.size() == counter){
			setAnswer("all");
		}
		
		//only one answer is correct
		else if (counter == 1){
			setAnswer("" + (correctAnsws.indexOf(true) + 1));
		}
		
		//multiple answers, but not all correct
		else if ((counter > 1) && (counter != choices.size())){
			ArrayList<String> corrects = new ArrayList<String>();
			for (int i = 0; i < correctAnsws.size(); i++){
				if (correctAnsws.get(i)){
					corrects.add(""+ (i+1));
				}
			}
			
			//when want multiple answers separated by commas
			boolean selectAll = super.getQuestionText().contains("Select all");
			if (selectAll){
				String theAnswers = String.join(", ", corrects);
				setAnswer(theAnswers);
			}
			
			//when want one of multiple possible answers
			if (!selectAll){
				if (corrects.contains(response)){
					setAnswer(response);
				};
			}
			
		}
		
		//nothing is correct 
		else {
			setAnswer("none");
		}
		return response.equalsIgnoreCase(answer);
	}
	

	public String getQuestionText() {
		String q = super.getQuestionText() + "\n";
		int choice = 1;
		for (String c : choices) {
			q += choice + ": " + c + "\n";
			choice++;
		}
		return q;
	}
}
