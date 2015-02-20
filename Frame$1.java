import java.util.logging.Level;
import java.util.logging.Logger;

class Frame$1 implements Runnable {
    @Override
    public void run() {
        Frame.this.i = 0;
        while (true) {
            Frame.access$000(Frame.this).setText("      " + Frame.this.hour + "  :   " + Frame.this.min + "   :   " + Frame.this.sec + "   :   " + Frame.this.i);
            try {
                Thread.sleep(7L);
            }
            catch (InterruptedException ex) {
                Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (Frame.this.i == 100) {
                Frame.this.i = 0;
                final Frame this$0 = Frame.this;
                ++this$0.sec;
            }
            if (Frame.this.sec == 60) {
                Frame.this.sec = 0;
                final Frame this$ = Frame.this;
                ++this$.min;
            }
            if (Frame.this.min == 60) {
                Frame.this.min = 0;
                final Frame this$2 = Frame.this;
                ++this$2.hour;
            }
            final Frame this$3 = Frame.this;
            ++this$3.i;
        }
    }
}