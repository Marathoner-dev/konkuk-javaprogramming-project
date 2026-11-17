package project;

public class Todo {
    private String deadLine;
    private String todoName;
    private Boolean state;

    public Todo(String deadLine, String todoName) {
        this.deadLine = deadLine;
        this.todoName = todoName;
    }

    public String getDeadLine() {
        return this.deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    public String getTodoName() {
        return this.todoName;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }

    public Boolean getState() {
        return this.state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}

