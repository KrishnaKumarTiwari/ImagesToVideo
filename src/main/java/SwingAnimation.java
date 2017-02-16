import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by deepak.jha on 2/15/17.
 */
public class SwingAnimation extends JPanel implements ActionListener {
    protected JFrame frame;
    protected JLabel lblDisplay;
    protected JButton BtnStart, BtnStop, BtnPause;
    protected JCheckBox chkLoop;
    protected Thread th;

    public static void main(String[] args) {
        SwingAnimation sa = new SwingAnimation();
    }

    public SwingAnimation() {
        frame = new JFrame("Animation");
        Panel panel = new Panel();

        lblDisplay = new JLabel();
        BtnStart = new JButton("Start");
        BtnStop = new JButton("Stop");
        BtnPause = new JButton("Pause");
        chkLoop = new JCheckBox("Loop");

        BtnStop.setEnabled(false);
        BtnPause.setEnabled(false);

        BtnStart.setActionCommand("start");
        BtnStop.setActionCommand("stop");
        BtnPause.setActionCommand("pause");

        panel.add(lblDisplay);
        panel.add(BtnStart);
        panel.add(BtnPause);
        panel.add(BtnStop);
        panel.add(chkLoop);
        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set the frame in the center of the screen
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int screen_x = (screensize.width - frame.getWidth()) / 2;
        int screen_y = (screensize.height - frame.getHeight()) / 2;
        frame.setLocation(screen_x, screen_y);

        BtnStart.addActionListener(this);
        BtnStop.addActionListener(this);
        BtnPause.addActionListener(this);
        chkLoop.addActionListener(this);
        th = new Thread();
        System.out.println("DONE DONE");
        ImageAnimator();
    }

    public void ImageAnimator() {
        try {
            for (int i = 1; i <= 6; i++) {
                ImageIcon images = new ImageIcon("/Users/deepak.jha/images_hack/" + i + ".jpg");
                lblDisplay.setIcon(images);
                System.out.println("Wait");
                th.sleep(5000);
                System.out.println("Done");            }
        } catch (InterruptedException e) {
        }
    }

    public void actionPerformed(ActionEvent e) {
        if ("start".equals(e.getActionCommand())) {
            BtnStart.setEnabled(false);
            BtnStop.setEnabled(true);
            BtnPause.setEnabled(true);
            lblDisplay.setVisible(true);
            ImageAnimator();
        } else if ("stop".equals(e.getActionCommand())) {
            BtnStart.setText("Start");
            BtnStart.setEnabled(true);
            BtnStop.setEnabled(false);
            BtnPause.setEnabled(false);
            lblDisplay.setVisible(false);
            th = null;
        } else if ("pause".equals(e.getActionCommand())) {
            BtnStart.setText("Resume");
            BtnStart.setEnabled(true);
            BtnStop.setEnabled(true);
            BtnPause.setEnabled(false);
        }
    }


}
