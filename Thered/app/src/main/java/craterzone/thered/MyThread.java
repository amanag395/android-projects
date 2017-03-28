package craterzone.thered;

/**
 * Created by aMAN GUPTA on 2/28/2017.
 */

public class MyThread implements Runnable {

    private boolean isStart;
    private OnTimeUpdateListener updateListener;

    public MyThread(OnTimeUpdateListener updateListener) {
        isStart = false;
        this.updateListener = updateListener;
    }

    public interface OnTimeUpdateListener {
        public void onTimeUpdate(int counter);
    }

    @Override
    public void run() {
        int counter = 0;
        while (true) {
            if (isStart) {
                counter++;
                if (updateListener != null)
                    updateListener.onTimeUpdate(counter);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void startStopTimer() {
        isStart = !isStart;
    }


    public boolean isStart() {
        return isStart;
    }
}
