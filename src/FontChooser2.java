import javax.swing.*;
import java.awt.*;


public class FontChooser2
        extends JDialog {
    protected static final int DEFAULT_SIZE = 4;
    protected Font resultFont;
    protected String resultName;
    protected int resultSize;
    protected boolean isBold;
    protected boolean isItalic;
    protected String displayText = "N@ Moral Produções Audio Visuais";
    protected String[] fontList;
    protected List fontNameChoice;
    protected List fontSizeChoice;
    protected String[] fontSizes = {"25", "30", "35", "40", "45", "50", "55", "60", "65", "70", "75", "80", "85", "90", "95", "100"};
    protected JLabel previewArea;
    Checkbox bold;
    Checkbox italic;


    public FontChooser2(Frame f) {
        super(f, "Selecao de Fonte", true);

        Container cp = getContentPane();

        Panel top = new Panel();
        top.setLayout(new FlowLayout());

        fontNameChoice = new List(8);
        top.add(fontNameChoice);

        Toolkit toolkit = Toolkit.getDefaultToolkit();

        fontList = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();


        for (int i = 0; i < fontList.length; i++)
            fontNameChoice.add(fontList[i]);
        fontNameChoice.select(0);

        fontSizeChoice = new List(8);
        top.add(fontSizeChoice);

        for (int i = 0; i < fontSizes.length; i++)
            fontSizeChoice.add(fontSizes[i]);
        fontSizeChoice.select(4);

        cp.add(top, "North");

        Panel attrs = new Panel();
        top.add(attrs);
        attrs.setLayout(new GridLayout(0, 1));
        attrs.add(this.bold = new Checkbox("Bold", false));
        attrs.add(this.italic = new Checkbox("Italic", false));

        previewArea = new JLabel(displayText, 0);
        previewArea.setSize(200, 50);
        cp.add(previewArea, "Center");

        Panel bot = new Panel();

        JButton okButton = new JButton("Aplicar");
        bot.add(okButton);
        okButton.addActionListener(e -> {
            previewFont();
            dispose();
            setVisible(false);
        });
        JButton pvButton = new JButton("Preview");
        bot.add(pvButton);
        pvButton.addActionListener(e -> previewFont());
        JButton canButton = new JButton("Cancelar");
        bot.add(canButton);
        canButton.addActionListener(e -> {
            resultFont = null;
            resultName = null;
            resultSize = 0;
            isBold = false;
            isItalic = false;

            dispose();
            setVisible(false);
        });
        cp.add(bot, "South");

        previewFont();

        pack();
        setLocation(100, 100);
    }


    protected void previewFont() {
        resultName = fontNameChoice.getSelectedItem();
        String resultSizeName = fontSizeChoice.getSelectedItem();
        int resultSize = Integer.parseInt(resultSizeName);
        isBold = bold.getState();
        isItalic = italic.getState();
        int attrs = 0;
        if (isBold)
            attrs = 1;
        if (isItalic)
            attrs |= 0x2;
        resultFont = new Font(resultName, attrs, resultSize);
        previewArea.setFont(resultFont);
        pack();
    }

    public String getSelectedName() {
        return resultName;
    }

    public int getSelectedSize() {
        return resultSize;
    }

    public Font getSelectedFont() {
        return resultFont;
    }
}
