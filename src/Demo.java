/**
 * Adapted from Horstmann Big Java 5th ed. 
 */

/*
 * Beth Lester, Dimitrios Vlahos
 */


import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {		
		Scanner in = new Scanner(System.in);
		
		Question stdQues = new Question();
		stdQues.setText("Who is the president of ISA?");
		stdQues.setAnswer("Nathan Young");
		handleQA(stdQues, in);

		ChoiceQuestion choiceQues = new ChoiceQuestion();
		choiceQues.setText("When was Elon Founded?");
		choiceQues.addChoice("1889", true);
		choiceQues.addChoice("1898", true);
		choiceQues.addChoice("1988", true);
		handleQA(choiceQues, in);
		
		FillInQuestion fillQues = new FillInQuestion("Elon is the Hebrew word for _oak_", "_");
		handleQA(fillQues, in);

		fillQues = new FillInQuestion("_Elon_ is the Hebrew word for oak", "_");
		handleQA(fillQues, in);

		fillQues = new FillInQuestion("Elon is the _Hebrew_ word for oak", "_");
		handleQA(fillQues, in);
		
		NumericQuestion numQues = new NumericQuestion("8 / 3 = _____", 8.0 / 3, 0.01);
		handleQA(numQues, in);
	}
	
	public static void handleQA(Question q, Scanner in) {
		System.out.println(q.getQuestionText());
		System.out.print("  Answer: ");
		String ans = in.nextLine();
		
		if (!q.isCorrect(ans)) {
			System.out.print("in");
		}
		System.out.println("correct!");				
	}

}
