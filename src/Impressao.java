import javax.swing.*;
import java.awt.*;

public class Impressao {
    private String texto = "";
    private Font fonte = null;

    public Impressao() {
        fonte = new Font("Arial Black", 0, 14);
    }

    public void setFonte(Font f) {
        fonte = f;
    }

    public void setString(String s) {
        JTextArea ta = new JTextArea();
        ta.setSize(400, 500);
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        ta.setFont(fonte);
        ta.setText(s);
        texto = getTextoEnquadrado(ta);
    }

    public String getTextoEnquadrado(javax.swing.text.JTextComponent c) {
        int len = c.getDocument().getLength();
        int offset = 0;
        String textoGeral = "";
        try {
            while (offset < len) {
                int end = javax.swing.text.Utilities.getRowEnd(c, offset);
                if (end < 0) {
                    break;
                }


                end = Math.min(end + 1, len);
                String s = c.getDocument().getText(offset, end - offset);
                textoGeral = textoGeral + s;


                if (!s.endsWith("\n")) {
                    textoGeral = textoGeral + "\n";
                }
                offset = end;
            }
        } catch (javax.swing.text.BadLocationException e) {
        }
        return textoGeral;
    }


    public void imprimiTexto() {
        JFrame parent = new JFrame();
        Print p = new Print(parent);
    }


    class Print {
        java.util.Properties p = new java.util.Properties();


        public Print(JFrame parent) {
            java.awt.Toolkit toolkit = parent.getToolkit();


            PrintJob pjob = toolkit.getPrintJob(parent, "Laudas", p);

            if (pjob != null) {
                Graphics pg = pjob.getGraphics();

                if (pg != null) {
                    printLongString(pjob, pg, texto);
                    pg.dispose();
                }
                pjob.end();
            }
        }


        private void printLongString(PrintJob pjob, Graphics pg, String s) {
            int pageNum = 1;
            int linesForThisPage = 0;
            int linesForThisJob = 0;


            if (!(pg instanceof java.awt.PrintGraphics)) {
                throw new IllegalArgumentException("Graphics context not PrintGraphics");
            }


            java.io.StringReader sr = new java.io.StringReader(s);
            java.io.LineNumberReader lnr = new java.io.LineNumberReader(sr);


            int getPageDimensionheight = 500;
            int pageHeight = getPageDimensionheight;


            pg.setFont(fonte);


            FontMetrics fm = pg.getFontMetrics(fonte);
            int fontHeight = fm.getHeight();
            int fontDescent = fm.getDescent();
            int curHeight = 0;
            int margemEsquerda = 40;
            int margemInferior = 3 * fontHeight;
            try {
                String nextLine;
                do {
                    nextLine = lnr.readLine();
                    if (nextLine != null) {
                        if (curHeight + fontHeight > pageHeight - margemInferior) {
                            pageNum += 1;
                            linesForThisPage = 0;
                            pg.dispose();
                            pg = pjob.getGraphics();
                            if (pg != null) {
                                pg.setFont(fonte);
                            }
                            curHeight = 0;
                        }
                        curHeight += fontHeight;
                        if (pg != null) {
                            pg.setColor(java.awt.Color.black);
                            pg.drawString(nextLine, margemEsquerda, curHeight - fontDescent + 20);
                            linesForThisPage += 1;
                            linesForThisJob += 1;
                        } else {
                            System.out.println("pg null");
                        }
                    }
                } while (nextLine != null);
            } catch (java.io.EOFException eof) {
            } catch (Exception t) {
            }
        }
    }
}
