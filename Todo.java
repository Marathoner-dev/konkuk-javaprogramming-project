package project;

public class Todo {
    String deadLine;
    String todoName;
    Boolean state;

    public Todo(String deadLine, String todoName) {
        this.deadLine = deadLine;
        this.todoName = todoName;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    public String getTodoName() {
        return todoName;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }
}
