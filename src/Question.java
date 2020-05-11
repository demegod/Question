/**
 * Adapted from Horstmann Big Java 5th ed.
 */

public class Question {
	
	private String text;
	private String answer;
	
	public Question() {
		text = "";
		answer = "";
	}
	
	 public void setText(String question) {
		 text = question;
	 }
	 
	 public void setAnswer(String ans) {
		 answer = ans;
	 }
	 
	 public boolean isCorrect(String response) {
		 return response.equalsIgnoreCase(answer);
	 }

	 public String getQuestionText() {
		 return text;
	 }
}
