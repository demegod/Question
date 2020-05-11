
public class FillInQuestion extends Question {
	
	public FillInQuestion(String ques, String marker) {
		int u1 = ques.indexOf(marker);
		int u2 = ques.indexOf(marker, u1+1);

		if (u1 < 0 || u2 < 0) return;
		
		String a = ques.substring(u1+1, u2);
		String q = ques.substring(0, u1) + "_____" + ques.substring(u2+1); 
		
		setText(q);
		setAnswer(a);
	}
}
