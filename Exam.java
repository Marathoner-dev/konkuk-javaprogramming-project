package project;

public class Exam {
    String theDay;
    String examName;

    public Exam(String theDay, String examName) {
        this.theDay = theDay;
        this.examName = examName;
    }

    public String getTheDay() {
        return theDay;
    }

    public void setTheDay(String theDay) {
        this.theDay = theDay;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }
}
