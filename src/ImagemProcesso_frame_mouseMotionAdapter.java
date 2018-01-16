import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;


class ImagemProcesso_frame_mouseMotionAdapter
        extends MouseMotionAdapter {
    ImagemProcesso adaptee;

    ImagemProcesso_frame_mouseMotionAdapter(ImagemProcesso adaptee) {
        this.adaptee = adaptee;
    }

    public void mouseDragged(MouseEvent e) {
        adaptee.frame_mouseDragged(e);
    }
}
