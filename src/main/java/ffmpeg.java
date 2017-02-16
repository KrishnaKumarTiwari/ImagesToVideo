import java.io.IOException;

/**
 * Created by deepak.jha on 2/7/17.
 */
public class ffmpeg {

    public static void main(String[] args) throws IOException, InterruptedException {
        Process p = Runtime.getRuntime().exec("ffmpeg -r 1/5 -f concat -safe 0 -i /Users/deepak.jha/imagesfile.txt" +
                " -c:v libx264 -vf fps=25,format=yuv420p /Users/deepak.jha/Downloads/IndVsEng/3rdT20/outputjava16thfeb.mp4");
        p.waitFor();
    }
}
