import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


class ImagemProcesso_frame_keyAdapter
        extends KeyAdapter {
    ImagemProcesso adaptee;

    ImagemProcesso_frame_keyAdapter(ImagemProcesso adaptee) {
        this.adaptee = adaptee;
    }

    public void keyPressed(KeyEvent e) {
        adaptee.frame_keyPressed(e);
    }
}
