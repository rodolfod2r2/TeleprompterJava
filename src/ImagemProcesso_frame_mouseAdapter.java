import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


class ImagemProcesso_frame_mouseAdapter
        extends MouseAdapter {
    ImagemProcesso adaptee;

    ImagemProcesso_frame_mouseAdapter(ImagemProcesso adaptee) {
        this.adaptee = adaptee;
    }

    public void mousePressed(MouseEvent e) {
        adaptee.frame_mousePressed(e);
    }
}
