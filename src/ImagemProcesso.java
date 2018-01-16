import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;
import java.util.StringTokenizer;

public class ImagemProcesso extends Thread {
    private Principal visual;
    private String titulo;
    private String textoRolagem = "Abrir uma Lauda para Rolagem";
    private String textoCronometro = "";
    private String seg = "";
    private String min = "";
    private Font fonteTexto;
    private Font fonteReferencia;
    private Font fonteCronometro;
    private Color corFundo;
    private Color corLetra;
    private Color corReferencia;
    private Color corCronometro;
    private Color corDestaque;
    private boolean inverte = false;
    private boolean margemCentro = true;
    private boolean exibeCronometro = true;
    private boolean startCronometro = false;
    private int tempo;
    private int larguraFrame;
    private int alturaFrame;
    private int alturaLetra = 0;
    private int alturaTexto = 0;
    private int numeroFrases = 0;
    private int limiteInferior = 0;
    private int limiteSuperior = 0;
    private int MousePos;
    private int segundo = 0;
    private int minuto = 0;
    private int[] tamanhoFrases;
    private GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    private GraphicsDevice gd = ge.getDefaultScreenDevice();
    private java.awt.GraphicsConfiguration gc = gd.getDefaultConfiguration();
    private BufferStrategy bf;
    private JFrame frame = new JFrame(gd.getDefaultConfiguration());
    private String[] vetorFrases;
    private java.awt.font.GlyphVector[] vetorDeGlyphs;
    private java.awt.Graphics g = null;
    private Graphics2D g2 = null;
    private Timer timer;

    public ImagemProcesso(Principal visual, String titulo) {
        this.visual = visual;
        this.titulo = titulo;
        setConfig();
        go();

        frame.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent e) {
                setMedidasFrame();
            }

        });
        Thread t = new Thread(this);
        t.start();
    }

    public void setMedidasFrame() {
        larguraFrame = frame.getWidth();
        alturaFrame = frame.getHeight();
    }

    public void setConfig() {
        fonteTexto = new Font("Dialog", 1, 60);
        fonteReferencia = new Font("Dialog", 1, 60);
        fonteCronometro = new Font("Dialog", 1, 80);
        corFundo = Color.black;
        corLetra = Color.white;
        corReferencia = Color.red;
        corCronometro = Color.yellow;
        corDestaque = Color.green;
        tempo = 10;
        margemCentro = true;
        exibeCronometro = true;
        startCronometro = false;
        segundo = 0;
        minuto = 0;
        textoCronometro = "00:00:00";
        frame.setSize(400, 800);
        frame.setTitle(titulo);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);
        frame.addMouseMotionListener(new ImagemProcesso_frame_mouseMotionAdapter(this));
        frame.addMouseListener(new ImagemProcesso_frame_mouseAdapter(this));
        frame.addMouseWheelListener(new ImagemProcesso_frame_mouseWheelAdapter(this));
        frame.addKeyListener(new ImagemProcesso_frame_keyAdapter(this));
        frame.setIgnoreRepaint(true);
        frame.createBufferStrategy(2);
        bf = frame.getBufferStrategy();
        larguraFrame = frame.getWidth();
        alturaFrame = frame.getHeight();
    }


    public void go() {
        java.awt.event.ActionListener action = new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (startCronometro == true) {
                    segundo = (segundo + 1);
                }
                if (segundo >= 60) {
                    segundo = 0;
                    minuto = (minuto + 1);
                    if (minuto >= 60) {
                        minuto = 0;
                    }
                }
                if (segundo < 10) {
                    seg = ("0" + segundo);
                }
                if (segundo >= 10) {
                    seg = ("" + segundo);
                }
                if (minuto < 10) {
                    min = ("0" + minuto);
                }
                if (minuto >= 10) {
                    min = ("" + minuto);
                }
                textoCronometro = (min + ":" + seg);
            }
        };
        timer = new Timer(1000, action);
        timer.start();
    }

    public void iniciaCronometro() {
        startCronometro = true;
    }

    public void paraCronometro() {
        startCronometro = false;
    }

    public void resetCronometro() {
        startCronometro = false;
        minuto = 0;
        segundo = 0;
    }

    public void mostraCronometro(boolean cr) {
        exibeCronometro = cr;
    }

    public void setCorFundo(Color c) {
        corFundo = c;
    }

    public void setCorFonte(Color c) {
        corLetra = c;
    }

    public void setCorReferencia(Color c) {
        corReferencia = c;
    }

    public void setCorCronometro(Color c) {
        corCronometro = c;
    }

    public void setCorDestaque(Color c) {
        corDestaque = c;
    }

    public void inverteTexto(boolean inverte) {
        this.inverte = inverte;
    }

    public void justificaTexto(boolean margem) {
        margemCentro = margem;
    }

    public void setTempo(int t) {
        tempo = t;
    }

    public void getTempo() {
        try {
            Thread.sleep(tempo);
        } catch (Exception e) {
        }
    }

    public void setFonte(Font f) {
        fonteTexto = f;
        geraGlyphs();
    }

    public void setTexto(String s, String nomeArquivoRolagemSelecionado) {
        frame.setTitle(titulo + "                      ========>" + nomeArquivoRolagemSelecionado + "<========");
        textoRolagem = s;
        geraGlyphs();
    }


    public void geraGlyphs() {
        frame.setFont(fonteTexto);
        FontMetrics fm = frame.getFontMetrics(fonteTexto);

        numeroFrases = 0;
        int numeroTokens = 0;
        int indiceVetorPalavra = 0;

        if ((textoRolagem.length() == 0) || (textoRolagem == null)) {
            textoRolagem = "Arquivo esta sem Texto";
        }
        StringTokenizer st = new StringTokenizer(textoRolagem, "\n");
        numeroTokens = st.countTokens();

        vetorFrases = new String[numeroTokens];
        tamanhoFrases = new int[numeroTokens];

        while (st.hasMoreTokens()) {
            vetorFrases[indiceVetorPalavra] = st.nextToken();
            tamanhoFrases[indiceVetorPalavra] = fm.stringWidth(vetorFrases[indiceVetorPalavra]);
            indiceVetorPalavra += 1;
        }

        numeroFrases = indiceVetorPalavra;

        alturaLetra = fm.getHeight();
        alturaTexto = (numeroFrases * alturaLetra);

        vetorDeGlyphs = new java.awt.font.GlyphVector[numeroFrases];
        java.awt.font.FontRenderContext frc = g2.getFontRenderContext();

        for (int i = 0; i < numeroFrases; i++) {
            vetorDeGlyphs[i] = fonteTexto.createGlyphVector(frc, vetorFrases[i]);
        }
    }

    public void pintar(int posicao) {
        int margens = 0;
        int limiteSuperiorPintura = limiteSuperior + alturaTexto - 100;
        int limiteInferiorPintura = limiteInferior + 150;

        try {
            g = bf.getDrawGraphics();
            g2 = ((Graphics2D) g);

            g2.setColor(corFundo);
            g2.fillRect(0, 0, larguraFrame, alturaFrame);

            if (inverte == true) {
                AffineTransform at = new AffineTransform(new double[]{-1.0D, 0.0D, 0.0D, 1.0D});
                at.translate(-larguraFrame, 0.0D);
                g2.transform(at);
            }

            g2.setFont(fonteReferencia);
            g2.setColor(corReferencia);


            g2.drawRect(10, alturaFrame / 2 - alturaLetra / 2, larguraFrame - 20, alturaLetra);

            g2.setColor(corLetra);

            for (int i = 0; i < numeroFrases; i++) {
                String frase = vetorFrases[i];

                margens = (larguraFrame - tamanhoFrases[i]) / 2;
                if (!margemCentro) {
                    margens = 30;
                }
                if (frase.startsWith("<<")) {
                    g2.setColor(corDestaque);
                }
                if (frase.startsWith(">>")) {
                    g2.setColor(corLetra);
                }
                if ((posicao > limiteSuperiorPintura) && (posicao < limiteInferiorPintura)) {
                    g2.drawGlyphVector(vetorDeGlyphs[i], margens, posicao);
                }
                posicao += alturaLetra;
            }

            if (exibeCronometro == true) {
                g2.setColor(corFundo);
                g2.fillRect(0, alturaFrame - 80, larguraFrame, 80);
                g2.setColor(corCronometro);
                g2.setFont(fonteCronometro);
                g2.drawString(textoCronometro, larguraFrame / 2 - 100, alturaFrame - 10);
            }
        } catch (Throwable e) {
        } finally {
            g.dispose();
        }
        java.awt.Toolkit.getDefaultToolkit().sync();
        bf.show();
    }

    public void run() {
        int posicao = 0;
        limiteInferior = (alturaFrame - 50);
        for (; ; ) {
            limiteSuperior = (100 - alturaTexto);
            posicao = visual.getPosicao();

            if (posicao >= limiteInferior) {
                posicao = limiteInferior;
                visual.setPosicao(posicao);
                resetCronometro();
            }
            if (posicao + alturaTexto <= 100) {
                posicao = limiteSuperior;
                visual.setPosicao(posicao);
                paraCronometro();
            }
            pintar(posicao + alturaLetra);
            getTempo();
        }
    }


    void frame_keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == 35) {
            visual.paraTexto();
        }
        if (keyCode == 40) {
            visual.desceTexto();
        }
        if (keyCode == 38) {
            visual.sobeTexto();
        }
        if (keyCode == 37) {
            visual.diminuiVelocidade();
        }
        if (keyCode == 39) {
            visual.aumentaVelocidade();
        }
        if (keyCode == 36) {
            visual.setInicioTexto();
        }
    }


    void frame_mouseWheelMoved(MouseWheelEvent e) {
        if (e.getWheelRotation() == -1) {
            visual.aumentaVelocidade();
        }
        if (e.getWheelRotation() == 1) {
            visual.diminuiVelocidade();
        }
    }

    void frame_mousePressed(MouseEvent e) {
        MousePos = e.getY();
        visual.paraTexto();
    }

    void frame_mouseDragged(MouseEvent e) {
        if (e.getY() < MousePos) {
            visual.sobeTexto();
        }
        if (e.getY() > MousePos) {
            visual.desceTexto();
        }
    }
}
