package project.src.project;

public class Stopwatch {

    private long startTime;
    private long stockedTime;
    private boolean isRunning;

    public boolean start() {
        if (isRunning) {
            return false;
        }
        if (stockedTime == 0) {
            startTime = System.nanoTime();
            isRunning = true;
            return true;
        }
        return false;
    }

    public void stop() {
        if (isRunning) {
            stockedTime = System.nanoTime() - startTime;
            isRunning = false;
        }
    }

    public void restart() {
        if (!isRunning && stockedTime > 0) {
            startTime = System.nanoTime();
            isRunning = true;
        }
    }

    public void reset() {
        startTime = 0;
        stockedTime = 0;
        isRunning = false;
    }

    public long getStockedTime() {
        long totalTime = stockedTime;
        if (isRunning) {
            totalTime += System.nanoTime() - startTime;
        }
        return totalTime / 1000000000;
    }

    public String getFormattedTime() {
        long seconds = getStockedTime();
        long hour = seconds / 3600;
        long minute = (seconds % 3600) / 60;
        long second = seconds % 60;
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

}