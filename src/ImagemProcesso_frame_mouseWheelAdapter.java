import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;


class ImagemProcesso_frame_mouseWheelAdapter
        implements MouseWheelListener {
    ImagemProcesso adaptee;

    ImagemProcesso_frame_mouseWheelAdapter(ImagemProcesso adaptee) {
        this.adaptee = adaptee;
    }

    public void mouseWheelMoved(MouseWheelEvent e) {
        adaptee.frame_mouseWheelMoved(e);
    }
}
