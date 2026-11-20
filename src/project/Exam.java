package project.src.project;

public class Exam {
    private String theDay;
    private String examName;

    public Exam(String theDay, String examName) {
        this.theDay = theDay;
        this.examName = examName;
    }

    public String getTheDay() {
        return this.theDay;
    }

    public void setTheDay(String theDay) {
        this.theDay = theDay;
    }

    public String getExamName() {
        return this.examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }
}
