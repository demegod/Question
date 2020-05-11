
public class NumericQuestion extends Question {

	double answer;
	double tolerance;
	
	public NumericQuestion(String ques, double ans, double tol) {
		setText(ques);
		answer = ans;
		tolerance = Math.abs(tol);
	}
		
	public boolean isCorrect(String response) {
		double r = Double.parseDouble(response);
		double lo = r - tolerance;
		double hi = r + tolerance;
		return (lo <= answer && answer <= hi);
	}
}
