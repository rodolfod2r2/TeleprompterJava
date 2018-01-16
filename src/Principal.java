import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends javax.swing.JFrame {
    private javax.help.HelpSet hs;
    private javax.help.HelpBroker hb;
    private JButton jButtonDesce;
    private JButton jButtonInicio;
    private JButton jButtonPara;
    private JButton jButtonSobe;
    private JButton jButtonValidar;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabelLogo;
    private JMenu jMenuAjuda;
    private JMenu jMenuArquivo;
    private javax.swing.JMenuBar jMenuBar1;
    private JMenu jMenuConfigurar;
    private JMenu jMenuEditar;
    private JMenuItem jMenuItemAbrir;
    private JMenuItem jMenuItemCaixaAlta;
    private JMenuItem jMenuItemCaixaBaixa;
    private JMenuItem jMenuItemCaixaNormal;
    private JMenuItem jMenuItemColar;
    private JMenuItem jMenuItemCopiar;
    private JMenuItem jMenuItemCorCronometro;
    private JMenuItem jMenuItemCorDestaque;
    private JMenuItem jMenuItemCorFundo;
    private JMenuItem jMenuItemCorLetra;
    private JMenuItem jMenuItemCorReferencia;
    private JMenuItem jMenuItemExibeCronometro;
    private JMenuItem jMenuItemFontEdicao;
    private JMenuItem jMenuItemFontExibicao;
    private JMenuItem jMenuItemFonte;
    private JMenuItem jMenuItemImprimir;
    private JMenuItem jMenuItemInverterTexto;
    private JMenuItem jMenuItemLimparTela;
    private JMenuItem jMenuItemSair;
    private JMenuItem jMenuItemSalvar;
    private JMenuItem jMenuItemSalvarComo;
    private JMenuItem jMenuItemTextoCentrado;
    private JMenuItem jMenuItemTextoEsquerada;
    private JMenuItem jMenuItemTopicos;
    private JPanel jPComandos;
    private JPanel jPComandos1;
    private JPanel jPComandos2;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanelEdicao;
    private JPanel jPanelLogo;
    private JPanel jPanelPreview;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private JPopupMenu.Separator jSeparator1;
    private JPopupMenu.Separator jSeparator10;
    private JPopupMenu.Separator jSeparator13;
    private JPopupMenu.Separator jSeparator15;
    private JPopupMenu.Separator jSeparator17;
    private JPopupMenu.Separator jSeparator19;
    private JPopupMenu.Separator jSeparator3;
    private JPopupMenu.Separator jSeparator4;
    private JPopupMenu.Separator jSeparator5;
    private JPopupMenu.Separator jSeparator6;
    private JPopupMenu.Separator jSeparator7;
    private JPopupMenu.Separator jSeparator8;
    private JSlider jSliderFPS;
    private JSlider jSliderVelocidade;
    private javax.swing.JTabbedPane jTabbedPane1;
    private JTextArea jTextAreaEdicao;
    private JTextArea jTextAreaPreview;
    private java.awt.Font fonteExibicao = new java.awt.Font("Arial Black", 1, 95);
    private java.awt.Font fonteEdicao = new java.awt.Font("Arial", 1, 20);
    private java.awt.Color corFundo = java.awt.Color.black;
    private java.awt.Color corFonte = java.awt.Color.yellow;
    private java.awt.Color corReferencia = java.awt.Color.red;
    private java.awt.Color corCronometro = java.awt.Color.yellow;
    private java.awt.Color corDestaque = java.awt.Color.green;
    private javax.swing.JFileChooser jFileChooser1 = null;
    private javax.swing.JColorChooser jColorChooser1 = null;
    private String nomeArquivo = "";
    private String diretorioSelecionado = null;
    private ImagemProcesso impEspelho = new ImagemProcesso(this, "Espelho               N@Moral Produções Audio Visuais");
    private ImagemProcesso impMonitor = new ImagemProcesso(this, "Monitor               N@Moral Produções Audio Visuais");
    private boolean tipoFonteEdicao = true;
    private java.awt.datatransfer.Clipboard clipboard = getToolkit().getSystemClipboard();
    private boolean inverte = true;
    private int tempo = 10;
    private int avanco;
    private int posicao;
    private int velocidade;
    private int pinturas;
    private int contaPinturas = 0;
    private boolean acima;
    private boolean abaixo;
    private boolean margemCentro = false;
    private boolean exibeCronometro = false;
    private String[] vetorLaudas = null;
    private int laudaSelecionada = 0;
    private int numeroLaudasAtual = 0;
    private int numeroLaudasAnterior = 0;
    private int caixa = 0;

    public Principal() {
        initComponents();
        justificaTexto(false);
        impEspelho.mostraCronometro(false);
        impMonitor.mostraCronometro(false);
        setDefault();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    private void initComponents() {
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelEdicao = new JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaEdicao = new JTextArea();
        jPanelPreview = new JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaPreview = new JTextArea();
        jPanel1 = new JPanel();
        jPComandos = new JPanel();
        jButtonSobe = new JButton();
        jButtonDesce = new JButton();
        jButtonInicio = new JButton();
        jButtonPara = new JButton();
        jButtonValidar = new JButton();
        jPComandos1 = new JPanel();
        jSliderVelocidade = new JSlider();
        jPComandos2 = new JPanel();
        jSliderFPS = new JSlider();
        jPanel2 = new JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jPanelLogo = new JPanel();
        jLabelLogo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArquivo = new JMenu();
        jMenuItemAbrir = new JMenuItem();
        jSeparator1 = new JPopupMenu.Separator();
        jMenuItemSalvar = new JMenuItem();
        jMenuItemSalvarComo = new JMenuItem();
        jSeparator3 = new JPopupMenu.Separator();
        jMenuItemImprimir = new JMenuItem();
        jSeparator4 = new JPopupMenu.Separator();
        jMenuItemSair = new JMenuItem();
        jMenuEditar = new JMenu();
        jMenuItemCopiar = new JMenuItem();
        jSeparator6 = new JPopupMenu.Separator();
        jMenuItemColar = new JMenuItem();
        jSeparator7 = new JPopupMenu.Separator();
        jMenuItemLimparTela = new JMenuItem();
        jSeparator8 = new JPopupMenu.Separator();
        jMenuItemFontEdicao = new JMenuItem();
        jMenuItemFontExibicao = new JMenuItem();
        jMenuConfigurar = new JMenu();
        jMenuItemFonte = new JMenuItem();
        jSeparator5 = new JPopupMenu.Separator();
        jMenuItemCorLetra = new JMenuItem();
        jMenuItemCorFundo = new JMenuItem();
        jMenuItemCorDestaque = new JMenuItem();
        jSeparator10 = new JPopupMenu.Separator();
        jMenuItemCaixaAlta = new JMenuItem();
        jMenuItemCaixaBaixa = new JMenuItem();
        jMenuItemCaixaNormal = new JMenuItem();
        jSeparator13 = new JPopupMenu.Separator();
        jMenuItemTextoCentrado = new JMenuItem();
        jMenuItemTextoEsquerada = new JMenuItem();
        jSeparator15 = new JPopupMenu.Separator();
        jMenuItemCorReferencia = new JMenuItem();
        jSeparator17 = new JPopupMenu.Separator();
        jMenuItemCorCronometro = new JMenuItem();
        jMenuItemExibeCronometro = new JMenuItem();
        jSeparator19 = new JPopupMenu.Separator();
        jMenuItemInverterTexto = new JMenuItem();
        jMenuAjuda = new JMenu();
        jMenuItemTopicos = new JMenuItem();

        setDefaultCloseOperation(3);
        setTitle("Operador  Teleprompter N@Moral Produções Audio Visuais");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                Principal.this.formWindowOpened(evt);
            }
        });
        addWindowStateListener(evt -> Principal.this.formWindowStateChanged(evt));
        jPanelEdicao.setLayout(new java.awt.CardLayout());

        jTextAreaEdicao.setColumns(20);
        jTextAreaEdicao.setLineWrap(true);
        jTextAreaEdicao.setRows(5);
        jTextAreaEdicao.setWrapStyleWord(true);
        jTextAreaEdicao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Principal.this.jTextAreaEdicaoKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTextAreaEdicao);

        jPanelEdicao.add(jScrollPane1, "card2");

        jTabbedPane1.addTab("Edição", jPanelEdicao);

        jPanelPreview.setLayout(new java.awt.CardLayout());

        jTextAreaPreview.setColumns(20);
        jTextAreaPreview.setEditable(false);
        jTextAreaPreview.setLineWrap(true);
        jTextAreaPreview.setRows(5);
        jTextAreaPreview.setWrapStyleWord(true);
        jScrollPane2.setViewportView(jTextAreaPreview);

        jPanelPreview.add(jScrollPane2, "card2");

        jTabbedPane1.addTab("Preview", jPanelPreview);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));
        jPanel1.setPreferredSize(new java.awt.Dimension(1180, 135));

        jPComandos.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        jPComandos.setLayout(null);

        jButtonSobe.setIcon(new ImageIcon(getClass().getResource("/icone/SubirP.png")));
        jButtonSobe.setToolTipText("Subir");
        jButtonSobe.setBorder(new javax.swing.border.SoftBevelBorder(0));
        jButtonSobe.setContentAreaFilled(false);
        jButtonSobe.setPressedIcon(new ImageIcon(getClass().getResource("/icone/SubirNP.png")));
        jButtonSobe.addActionListener(evt -> Principal.this.jButtonSobeActionPerformed(evt));
        jPComandos.add(jButtonSobe);
        jButtonSobe.setBounds(10, 10, 40, 40);

        jButtonDesce.setIcon(new ImageIcon(getClass().getResource("/icone/DescerP.png")));
        jButtonDesce.setToolTipText("Descer");
        jButtonDesce.setBorder(new javax.swing.border.SoftBevelBorder(0));
        jButtonDesce.setContentAreaFilled(false);
        jButtonDesce.setPressedIcon(new ImageIcon(getClass().getResource("/icone/DescerNP.png")));
        jButtonDesce.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Principal.this.jButtonDesceActionPerformed(evt);
            }
        });
        jPComandos.add(jButtonDesce);
        jButtonDesce.setBounds(10, 60, 40, 40);

        jButtonInicio.setIcon(new ImageIcon(getClass().getResource("/icone/InicioP.png")));
        jButtonInicio.setToolTipText("Inicio");
        jButtonInicio.setBorder(new javax.swing.border.SoftBevelBorder(0));
        jButtonInicio.setContentAreaFilled(false);
        jButtonInicio.setPressedIcon(new ImageIcon(getClass().getResource("/icone/InicioNP.png")));
        jButtonInicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Principal.this.jButtonInicioActionPerformed(evt);
            }
        });
        jPComandos.add(jButtonInicio);
        jButtonInicio.setBounds(60, 10, 40, 39);

        jButtonPara.setIcon(new ImageIcon(getClass().getResource("/icone/PararP.png")));
        jButtonPara.setToolTipText("Parar");
        jButtonPara.setBorder(new javax.swing.border.SoftBevelBorder(0));
        jButtonPara.setContentAreaFilled(false);
        jButtonPara.setPressedIcon(new ImageIcon(getClass().getResource("/icone/PararNP.png")));
        jButtonPara.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Principal.this.jButtonParaActionPerformed(evt);
            }
        });
        jPComandos.add(jButtonPara);
        jButtonPara.setBounds(60, 60, 40, 40);

        jButtonValidar.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButtonValidar.setText("Validar");
        jButtonValidar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Principal.this.jButtonValidarActionPerformed(evt);
            }
        });
        jPComandos.add(jButtonValidar);
        jButtonValidar.setBounds(110, 10, 90, 90);

        jPComandos1.setBorder(javax.swing.BorderFactory.createTitledBorder("Velocidade"));
        jPComandos1.setLayout(new java.awt.BorderLayout());

        jSliderVelocidade.setMaximum(20);
        jSliderVelocidade.setMinimum(1);
        jSliderVelocidade.setMinorTickSpacing(1);
        jSliderVelocidade.setPaintTicks(true);
        jSliderVelocidade.setSnapToTicks(true);
        jSliderVelocidade.setValueIsAdjusting(true);
        jSliderVelocidade.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Principal.this.jSliderVelocidadeStateChanged(evt);
            }
        });
        jPComandos1.add(jSliderVelocidade, "Center");

        jPComandos2.setBorder(javax.swing.BorderFactory.createTitledBorder("F.P.S"));
        jPComandos2.setLayout(new java.awt.BorderLayout());

        jSliderFPS.setMaximum(20);
        jSliderFPS.setMinimum(1);
        jSliderFPS.setMinorTickSpacing(1);
        jSliderFPS.setPaintTicks(true);
        jSliderFPS.setSnapToTicks(true);
        jSliderFPS.setValueIsAdjusting(true);
        jSliderFPS.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Principal.this.jSliderFPSStateChanged(evt);
            }
        });
        jPComandos2.add(jSliderFPS, "Center");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Laudas", 2, 0, new java.awt.Font("Tahoma", 1, 14)));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Principal.this.jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Principal.this.jComboBox1ActionPerformed(evt);
            }

        });
        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(jComboBox1, -2, 112, -2).addContainerGap()));


        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(56, 32767).addComponent(jComboBox1, -2, -1, -2).addContainerGap()));


        jPanelLogo.setBorder(javax.swing.BorderFactory.createBevelBorder(0));

        jLabelLogo.setHorizontalAlignment(4);
        jLabelLogo.setIcon(new ImageIcon(getClass().getResource("/bgpm.jpg")));

        GroupLayout jPanelLogoLayout = new GroupLayout(jPanelLogo);
        jPanelLogo.setLayout(jPanelLogoLayout);
        jPanelLogoLayout.setHorizontalGroup(jPanelLogoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jLabelLogo));


        jPanelLogoLayout.setVerticalGroup(jPanelLogoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jLabelLogo));


        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(12, 12, 12).addComponent(jPComandos, -2, 210, -2).addGap(10, 10, 10).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jPComandos1, -1, 488, 32767).addComponent(jPComandos2, -1, 488, 32767)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jPanel2, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jPanelLogo, -2, -1, -2).addContainerGap()));


        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(jPComandos, -2, 110, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(jPComandos2, -2, 60, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jPComandos1, -2, 60, -2)).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jPanelLogo, -2, -1, -2)).addComponent(jPanel2, -2, -1, -2));


        jMenuArquivo.setText("Arquivo");

        jMenuItemAbrir.setIcon(new ImageIcon(getClass().getResource("/icone/folder-open-document.png")));
        jMenuItemAbrir.setText("Abrir");
        jMenuItemAbrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Principal.this.jMenuItemAbrirActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuItemAbrir);
        jMenuArquivo.add(jSeparator1);

        jMenuItemSalvar.setIcon(new ImageIcon(getClass().getResource("/icone/disk.png")));
        jMenuItemSalvar.setText("Salvar");
        jMenuItemSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Principal.this.jMenuItemSalvarActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuItemSalvar);

        jMenuItemSalvarComo.setIcon(new ImageIcon(getClass().getResource("/icone/disk--pencil.png")));
        jMenuItemSalvarComo.setText("Salvar Como");
        jMenuItemSalvarComo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Principal.this.jMenuItemSalvarComoActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuItemSalvarComo);
        jMenuArquivo.add(jSeparator3);

        jMenuItemImprimir.setIcon(new ImageIcon(getClass().getResource("/icone/printer.png")));
        jMenuItemImprimir.setText("Imprimir");
        jMenuItemImprimir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Principal.this.jMenuItemImprimirActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuItemImprimir);
        jMenuArquivo.add(jSeparator4);

        jMenuItemSair.setIcon(new ImageIcon(getClass().getResource("/icone/door-open-in.png")));
        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Principal.this.jMenuItemSairActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuItemSair);

        jMenuBar1.add(jMenuArquivo);

        jMenuEditar.setText("Editar");

        jMenuItemCopiar.setIcon(new ImageIcon(getClass().getResource("/icone/document-copy.png")));
        jMenuItemCopiar.setText("Copiar");
        jMenuItemCopiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Principal.this.jMenuItemCopiarActionPerformed(evt);
            }
        });
        jMenuEditar.add(jMenuItemCopiar);
        jMenuEditar.add(jSeparator6);

        jMenuItemColar.setIcon(new ImageIcon(getClass().getResource("/icone/clipboard-paste.png")));
        jMenuItemColar.setText("Colar");
        jMenuItemColar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Principal.this.jMenuItemColarActionPerformed(evt);
            }
        });
        jMenuEditar.add(jMenuItemColar);
        jMenuEditar.add(jSeparator7);

        jMenuItemLimparTela.setIcon(new ImageIcon(getClass().getResource("/icone/eraser.png")));
        jMenuItemLimparTela.setText("Limpar tela");
        jMenuItemLimparTela.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Principal.this.jMenuItemLimparTelaActionPerformed(evt);
            }
        });
        jMenuEditar.add(jMenuItemLimparTela);
        jMenuEditar.add(jSeparator8);

        jMenuItemFontEdicao.setIcon(new ImageIcon(getClass().getResource("/icone/ui-label.png")));
        jMenuItemFontEdicao.setText("Fonte de Edição");
        jMenuItemFontEdicao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Principal.this.jMenuItemFontEdicaoActionPerformed(evt);
            }
        });
        jMenuEditar.add(jMenuItemFontEdicao);

        jMenuItemFontExibicao.setIcon(new ImageIcon(getClass().getResource("/icone/edit.png")));
        jMenuItemFontExibicao.setText("Fonte de Exibição");
        jMenuItemFontExibicao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Principal.this.jMenuItemFontExibicaoActionPerformed(evt);
            }
        });
        jMenuEditar.add(jMenuItemFontExibicao);

        jMenuBar1.add(jMenuEditar);

        jMenuConfigurar.setText("Configurar");
        jMenuConfigurar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Principal.this.jMenuConfigurarActionPerformed(evt);
            }

        });
        jMenuItemFonte.setIcon(new ImageIcon(getClass().getResource("/icone/edit-size.png")));
        jMenuItemFonte.setText("Fonte");
        jMenuItemFonte.addActionListener(evt -> Principal.this.jMenuItemFonteActionPerformed(evt));
        jMenuConfigurar.add(jMenuItemFonte);
        jMenuConfigurar.add(jSeparator5);

        jMenuItemCorLetra.setIcon(new ImageIcon(getClass().getResource("/icone/edit-color.png")));
        jMenuItemCorLetra.setText("Cor da Fonte");
        jMenuItemCorLetra.addActionListener(evt -> Principal.this.jMenuItemCorLetraActionPerformed(evt));
        jMenuConfigurar.add(jMenuItemCorLetra);

        jMenuItemCorFundo.setIcon(new ImageIcon(getClass().getResource("/icone/paint-can-color.png")));
        jMenuItemCorFundo.setText("Cor do Fundo");
        jMenuItemCorFundo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Principal.this.jMenuItemCorFundoActionPerformed(evt);
            }
        });
        jMenuConfigurar.add(jMenuItemCorFundo);

        jMenuItemCorDestaque.setIcon(new ImageIcon(getClass().getResource("/icone/edit-color.png")));
        jMenuItemCorDestaque.setText("Cor de Destaque");
        jMenuItemCorDestaque.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Principal.this.jMenuItemCorDestaqueActionPerformed(evt);
            }
        });
        jMenuConfigurar.add(jMenuItemCorDestaque);
        jMenuConfigurar.add(jSeparator10);

        jMenuItemCaixaAlta.setIcon(new ImageIcon(getClass().getResource("/icone/edit-uppercase.png")));
        jMenuItemCaixaAlta.setText("Caixa Alta");
        jMenuItemCaixaAlta.addActionListener(evt -> Principal.this.jMenuItemCaixaAltaActionPerformed(evt));
        jMenuConfigurar.add(jMenuItemCaixaAlta);

        jMenuItemCaixaBaixa.setIcon(new ImageIcon(getClass().getResource("/icone/edit-lowercase.png")));
        jMenuItemCaixaBaixa.setText("Caixa Baixa");
        jMenuItemCaixaBaixa.addActionListener(evt -> Principal.this.jMenuItemCaixaBaixaActionPerformed(evt));
        jMenuConfigurar.add(jMenuItemCaixaBaixa);

        jMenuItemCaixaNormal.setIcon(new ImageIcon(getClass().getResource("/icone/edit-small-caps.png")));
        jMenuItemCaixaNormal.setText("Caixa Normal");
        jMenuItemCaixaNormal.addActionListener(evt -> Principal.this.jMenuItemCaixaNormalActionPerformed(evt));
        jMenuConfigurar.add(jMenuItemCaixaNormal);
        jMenuConfigurar.add(jSeparator13);

        jMenuItemTextoCentrado.setIcon(new ImageIcon(getClass().getResource("/icone/edit-alignment-center.png")));
        jMenuItemTextoCentrado.setText("Texto Centrado");
        jMenuItemTextoCentrado.addActionListener(evt -> Principal.this.jMenuItemTextoCentradoActionPerformed(evt));
        jMenuConfigurar.add(jMenuItemTextoCentrado);

        jMenuItemTextoEsquerada.setIcon(new ImageIcon(getClass().getResource("/icone/edit-alignment.png")));
        jMenuItemTextoEsquerada.setText("Texto a Esquerda");
        jMenuItemTextoEsquerada.addActionListener(evt -> Principal.this.jMenuItemTextoEsqueradaActionPerformed(evt));
        jMenuConfigurar.add(jMenuItemTextoEsquerada);
        jMenuConfigurar.add(jSeparator15);

        jMenuItemCorReferencia.setIcon(new ImageIcon(getClass().getResource("/icone/palette-color.png")));
        jMenuItemCorReferencia.setText("Cor Referencia");
        jMenuItemCorReferencia.addActionListener(evt -> Principal.this.jMenuItemCorReferenciaActionPerformed(evt));
        jMenuConfigurar.add(jMenuItemCorReferencia);
        jMenuConfigurar.add(jSeparator17);

        jMenuItemCorCronometro.setIcon(new ImageIcon(getClass().getResource("/icone/color.png")));
        jMenuItemCorCronometro.setText("Cor do Cronometro");
        jMenuItemCorCronometro.addActionListener(evt -> Principal.this.jMenuItemCorCronometroActionPerformed(evt));
        jMenuConfigurar.add(jMenuItemCorCronometro);

        jMenuItemExibeCronometro.setIcon(new ImageIcon(getClass().getResource("/icone/counter-count-up.png")));
        jMenuItemExibeCronometro.setText("Cronometro Exibe/Oculta");
        jMenuItemExibeCronometro.addActionListener(evt -> Principal.this.jMenuItemExibeCronometroActionPerformed(evt));
        jMenuConfigurar.add(jMenuItemExibeCronometro);
        jMenuConfigurar.add(jSeparator19);

        jMenuItemInverterTexto.setIcon(new ImageIcon(getClass().getResource("/icone/television--arrow.png")));
        jMenuItemInverterTexto.setText("Inverter Texto do Espelho");
        jMenuItemInverterTexto.addActionListener(evt -> Principal.this.jMenuItemInverterTextoActionPerformed(evt));
        jMenuConfigurar.add(jMenuItemInverterTexto);

        jMenuBar1.add(jMenuConfigurar);

        jMenuAjuda.setText("Ajuda");

        jMenuItemTopicos.setIcon(new ImageIcon(getClass().getResource("/icone/information.png")));
        jMenuItemTopicos.setText("Topicos");
        jMenuItemTopicos.addActionListener(evt -> Principal.this.jMenuItemTopicosActionPerformed(evt));
        jMenuAjuda.add(jMenuItemTopicos);

        jMenuBar1.add(jMenuAjuda);

        setJMenuBar(jMenuBar1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(jTabbedPane1, GroupLayout.Alignment.LEADING, -1, 1180, 32767)).addContainerGap()));


        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jTabbedPane1, -2, 531, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jPanel1, -2, 135, -2).addContainerGap(54, 32767)));


        pack();
    }

    private void jMenuItemSairActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    private void jMenuItemAbrirActionPerformed(ActionEvent evt) {
        abrir();
    }

    private void jMenuItemSalvarActionPerformed(ActionEvent evt) {
        salvar();
    }

    private void jMenuItemSalvarComoActionPerformed(ActionEvent evt) {
        salvarComo();
    }

    private void jMenuItemFonteActionPerformed(ActionEvent evt) {
        setFonteExibicao();
    }

    private void jMenuItemFontExibicaoActionPerformed(ActionEvent evt) {
        setEdicaoFonteExibicao();
    }

    private void jMenuItemFontEdicaoActionPerformed(ActionEvent evt) {
        setEdicaoFonteEdicao();
    }

    private void jMenuItemCorLetraActionPerformed(ActionEvent evt) {
        setCorFonte();
    }

    private void jMenuItemCorFundoActionPerformed(ActionEvent evt) {
        setCorFundo();
    }

    private void jMenuItemCorReferenciaActionPerformed(ActionEvent evt) {
        setCorReferencia();
    }

    private void jMenuItemCorCronometroActionPerformed(ActionEvent evt) {
        setCorCronometro();
    }

    private void jButtonValidarActionPerformed(ActionEvent evt) {
        setValidar();
    }

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {
    }

    private void jComboBox1ActionPerformed(ActionEvent evt) {
        setSelecaoLaudas();
    }

    private void jTextAreaEdicaoKeyTyped(java.awt.event.KeyEvent evt) {
        textoEdicaoMudado();
    }

    private void jMenuItemLimparTelaActionPerformed(ActionEvent evt) {
        limparTela();
    }

    private void jButtonInicioActionPerformed(ActionEvent evt) {
        setInicioTexto();
    }

    private void jButtonParaActionPerformed(ActionEvent evt) {
        paraTexto();
    }

    private void jButtonSobeActionPerformed(ActionEvent evt) {
        sobeTexto();
    }

    private void jButtonDesceActionPerformed(ActionEvent evt) {
        desceTexto();
    }

    private void jMenuItemCaixaAltaActionPerformed(ActionEvent evt) {
        setTextoCaixaAlta();
    }

    private void jMenuItemCaixaBaixaActionPerformed(ActionEvent evt) {
        setTextoCaixaBaixa();
    }

    private void jMenuItemCaixaNormalActionPerformed(ActionEvent evt) {
        setTextoCaixaNormal();
    }

    private void jMenuConfigurarActionPerformed(ActionEvent evt) {
        justificaTexto(true);
    }

    private void jMenuItemTextoEsqueradaActionPerformed(ActionEvent evt) {
        justificaTexto(false);
    }

    private void jMenuItemExibeCronometroActionPerformed(ActionEvent evt) {
        setCronometro();
    }

    private void jSliderVelocidadeStateChanged(javax.swing.event.ChangeEvent evt) {
        int i = jSliderVelocidade.getValue();
        setVelocidade(i);
    }

    private void jMenuItemCopiarActionPerformed(ActionEvent evt) {
        copiar();
    }

    private void jMenuItemColarActionPerformed(ActionEvent evt) {
        colar();
    }

    private void jMenuItemImprimirActionPerformed(ActionEvent evt) {
        imprimir();
    }

    private void jMenuItemTopicosActionPerformed(ActionEvent evt) {
        ajuda();
    }

    private void jMenuItemInverterTextoActionPerformed(ActionEvent evt) {
        inverteTexto();
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {
        setExtendedState(6);
    }

    private void jMenuItemTextoCentradoActionPerformed(ActionEvent evt) {
        justificaTexto(true);
    }

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {
    }

    private void jSliderFPSStateChanged(javax.swing.event.ChangeEvent evt) {
    }

    private void jMenuItemCorDestaqueActionPerformed(ActionEvent evt) {
        setCorDestaque();
    }

    public void setDefault() {
        setInterfaceUsuario();
        setConfig();
    }


    public void setConfig() {
        if (tipoFonteEdicao == true) {
            jTextAreaEdicao.setFont(fonteEdicao);
        }
        if (!tipoFonteEdicao) {
            jTextAreaEdicao.setFont(fonteExibicao);
        }

        jTextAreaEdicao.setBackground(corFundo);
        jTextAreaEdicao.setForeground(corFonte);
        jTextAreaEdicao.setCaretColor(corFonte);

        jTextAreaPreview.setFont(fonteExibicao);
        jTextAreaPreview.setBackground(corFundo);
        jTextAreaPreview.setForeground(corFonte);
        jTextAreaPreview.setCaretColor(corFonte);

        posicao = 0;
        velocidade = 5;
        avanco = 1;
        margemCentro = false;
        exibeCronometro = false;

        jSliderFPS.setValue(10);
        jSliderVelocidade.setValue(10);

        impEspelho.setCorFonte(corFonte);
        impEspelho.setCorFundo(corFundo);
        impEspelho.setFonte(fonteExibicao);
        impEspelho.inverteTexto(inverte);
        impEspelho.setCorReferencia(corReferencia);
        impEspelho.setCorCronometro(corCronometro);
        impEspelho.setCorDestaque(corDestaque);


        impMonitor.setCorReferencia(corReferencia);
        impMonitor.setCorFonte(corFonte);
        impMonitor.setCorFundo(corFundo);
        impMonitor.setFonte(fonteExibicao);
        impMonitor.setCorCronometro(corCronometro);
        impMonitor.setCorDestaque(corDestaque);

        setValidar();
    }


    public void setInterfaceUsuario() {
        UIManager.put("FileChooser.lookInLabelMnemonic", new Integer(69));
        UIManager.put("FileChooser.lookInLabelText", "Examinar");
        UIManager.put("FileChooser.saveInLabelText", "Salvar em");
        UIManager.put("FileChooser.fileNameLabelMnemonic", new Integer(78));
        UIManager.put("FileChooser.fileNameLabelText", "Nome do arquivo");
        UIManager.put("FileChooser.filesOfTypeLabelMnemonic", new Integer(84));
        UIManager.put("FileChooser.filesOfTypeLabelText", "Tipo");
        UIManager.put("FileChooser.upFolderToolTipText", "Um nível acima");
        UIManager.put("FileChooser.upFolderAccessibleName", "Um nível acima");
        UIManager.put("FileChooser.homeFolderToolTipText", "Desktop");
        UIManager.put("FileChooser.homeFolderAccessibleName", "Desktop");
        UIManager.put("FileChooser.newFolderToolTipText", "Criar nova pasta");
        UIManager.put("FileChooser.newFolderAccessibleName", "Criar nova pasta");
        UIManager.put("FileChooser.listViewButtonToolTipText", "Lista");
        UIManager.put("FileChooser.listViewButtonAccessibleName", "Lista");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Detalhes");
        UIManager.put("FileChooser.detailsViewButtonAccessibleName", "Detalhes");
        UIManager.put("FileChooser.fileNameHeaderText", "Nome");
        UIManager.put("FileChooser.fileSizeHeaderText", "Tamanho");
        UIManager.put("FileChooser.fileTypeHeaderText", "Tipo");
        UIManager.put("FileChooser.fileDateHeaderText", "Data");
        UIManager.put("FileChooser.fileAttrHeaderText", "Atributos");
        UIManager.put("FileChooser.cancelButtonText", "Cancelar");
        UIManager.put("FileChooser.openButtonText", "Abrir");
        UIManager.put("FileChooser.saveButtonText", "Salvar");

        UIManager.put("ColorChooser.sampleText", "Texto Exemplo");
        UIManager.put("ColorChooser.swatchesNameText", "Escolha");
        UIManager.put("ColorChooser.resetText", "Restaurar");
        UIManager.put("ColorChooser.previewText", "Pré-Visualizar");
        UIManager.put("ColorChooser.cancelText", "Cancelar");
        UIManager.put("ColorChooser.swatchesRecentText", "Recentes");

        jFileChooser1 = new javax.swing.JFileChooser();
        jColorChooser1 = new javax.swing.JColorChooser();
    }

    public void abrir() {
        nomeArquivo = null;
        jFileChooser1.setDialogTitle("Escolha um Arquivo *.txt para Abrir");
        jFileChooser1.addChoosableFileFilter(new TextFilter());
        if (0 == jFileChooser1.showOpenDialog(this)) {
            repaint();
            nomeArquivo = jFileChooser1.getSelectedFile().getPath();
        } else {
            return;
        }
        try {
            java.io.File arquivo = new java.io.File(nomeArquivo);
            int tamanho = (int) arquivo.length();
            int caracteres = 0;
            java.io.FileReader lerArquivo = new java.io.FileReader(arquivo);
            char[] dados = new char[tamanho];
            while (lerArquivo.ready()) {
                caracteres += lerArquivo.read(dados, caracteres, tamanho - caracteres);
            }
            lerArquivo.close();
            String texto = new String(dados, 0, caracteres);
            nomeArquivo = arquivo.getName();
            diretorioSelecionado = arquivo.getPath();

            jTextAreaEdicao.setText(texto);
            setValidar();
            if (numeroLaudasAtual >= 0) {
                jComboBox1.setSelectedIndex(0);
            }
        } catch (Exception ex) {
        }
    }

    public boolean salvarComo() {
        jFileChooser1.setDialogTitle("Escolha um Arquivo *.txt para Salvar");
        jFileChooser1.addChoosableFileFilter(new TextFilter());
        if (0 == jFileChooser1.showSaveDialog(this)) {
            diretorioSelecionado = jFileChooser1.getSelectedFile().getPath();
            nomeArquivo = jFileChooser1.getSelectedFile().getName();

            repaint();
            return salvar();
        }
        repaint();
        return false;
    }

    public boolean salvar() {
        if (diretorioSelecionado == null) {
            return salvarComo();
        }
        String texto = "";
        texto = jTextAreaEdicao.getText();

        if (!diretorioSelecionado.endsWith(".txt")) {
            diretorioSelecionado += ".txt";
        }
        try {
            java.io.File arquivo = new java.io.File(diretorioSelecionado);
            java.io.FileWriter fw = new java.io.FileWriter(arquivo);
            fw.write(texto);
            fw.close();
            return true;
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao salvar o arquivo" + diretorioSelecionado);
        }
        return false;
    }

    public void setFonteExibicao() {
        final javax.swing.JFrame f = new javax.swing.JFrame("Selecao da Fonte");
        final FontChooser2 fc = new FontChooser2(f);
        java.awt.Container cp = f.getContentPane();
        cp.setLayout(new java.awt.GridLayout(0, 1));
        JButton theButton = new JButton("Mudar a Fonte");
        cp.add(theButton);
        final javax.swing.JLabel theLabel = new javax.swing.JLabel("N@moral Produções", 0);
        cp.add(theLabel);


        theButton.addActionListener(e -> {
            fc.setVisible(true);
            java.awt.Font myNewFont = fc.getSelectedFont();
            theLabel.setFont(myNewFont);

            fonteExibicao = myNewFont;
            setConfig();

            f.pack();
            fc.dispose();
        });
        f.setSize(250, 100);
        f.setVisible(true);
    }

    public void setEdicaoFonteExibicao() {
        tipoFonteEdicao = false;
        setConfig();
    }

    public void setEdicaoFonteEdicao() {
        tipoFonteEdicao = true;
        setConfig();
    }

    public void setCorFonte() {
        corFonte = javax.swing.JColorChooser.showDialog(this, "Selecione a Cor da Fonte", corFonte);
        setConfig();
    }

    public void setCorFundo() {
        corFundo = javax.swing.JColorChooser.showDialog(this, "Selecione a Cor do Fundo", corFundo);
        setConfig();
    }

    public void setCorReferencia() {
        corReferencia = javax.swing.JColorChooser.showDialog(this, "Selecione a Cor da Refencia", corReferencia);
        impEspelho.setCorReferencia(corReferencia);
        impMonitor.setCorReferencia(corReferencia);
    }

    public void setCorCronometro() {
        corCronometro = javax.swing.JColorChooser.showDialog(this, "Selecione a Cor do Cronometro", corCronometro);
        impEspelho.setCorCronometro(corCronometro);
        impMonitor.setCorCronometro(corCronometro);
    }

    public void setCorDestaque() {
        corDestaque = javax.swing.JColorChooser.showDialog(this, "Selecione a Cor de Destaque", corDestaque);
        impEspelho.setCorDestaque(corDestaque);
        impMonitor.setCorDestaque(corDestaque);
    }

    public void inverteTexto() {
        inverte = (!inverte);
        setConfig();
    }

    public void colar() {
        java.awt.datatransfer.Transferable clipData = clipboard.getContents(clipboard);
        if (clipData != null) {
            try {
                if (clipData.isDataFlavorSupported(java.awt.datatransfer.DataFlavor.stringFlavor)) {
                    String s = (String) clipData.getTransferData(java.awt.datatransfer.DataFlavor.stringFlavor);
                    jTextAreaEdicao.replaceSelection(s);
                }
            } catch (java.awt.datatransfer.UnsupportedFlavorException ufe) {
                System.err.println("Flavor unsupported: " + ufe);
            } catch (java.io.IOException ioe) {
                System.err.println("Data not available: " + ioe);
            }
        }
    }

    public void copiar() {
        String selection = jTextAreaEdicao.getSelectedText();
        java.awt.datatransfer.StringSelection data = new java.awt.datatransfer.StringSelection(selection);
        clipboard.setContents(data, data);
    }

    public void setValidar() {
        int indice = 0;
        int numeroTokens = 0;
        vetorLaudas = null;
        jButtonValidar.setForeground(java.awt.Color.red);

        String textoEdicao = jTextAreaEdicao.getText();
        java.util.StringTokenizer st = new java.util.StringTokenizer(textoEdicao, "//");
        numeroTokens = st.countTokens();

        if (numeroTokens < 1) {
            return;
        }

        numeroLaudasAtual = numeroTokens;

        vetorLaudas = new String[numeroTokens];

        while (st.hasMoreTokens()) {
            String token = st.nextToken().trim();
            vetorLaudas[indice] = token;
            indice += 1;
        }
        setComboLaudas();
        setTextoPreview();
        jButtonValidar.setForeground(java.awt.Color.green);
    }

    public void textoEdicaoMudado() {
        jButtonValidar.setForeground(java.awt.Color.red);
    }

    public void limpaComboBox() {
        if (jComboBox1 == null) {
            return;
        }
        int itens = jComboBox1.getItemCount();

        if (itens > 0) {
            jComboBox1.removeAllItems();
        }
    }

    public void setComboLaudas() {
        int laudaAtual = laudaSelecionada;

        limpaComboBox();

        for (int i = 0; i < numeroLaudasAtual; i++) {
            jComboBox1.addItem("Lauda  " + (i + 1));
        }

        if (numeroLaudasAtual >= numeroLaudasAnterior) {
            laudaSelecionada = laudaAtual;
        }
        if (numeroLaudasAtual < numeroLaudasAnterior) {
            laudaSelecionada = 0;
        }
        numeroLaudasAnterior = numeroLaudasAtual;
        jComboBox1.setSelectedIndex(laudaSelecionada);
        jComboBox1.repaint();
    }

    public void setTextoPreview() {
        if (vetorLaudas == null) {
            return;
        }
        if (laudaSelecionada < 0) {
            return;
        }

        String textoPreview = vetorLaudas[laudaSelecionada];
        String textoExibicao = "";

        if (caixa == 0) {
            textoExibicao = textoPreview;
        }
        if (caixa == 1) {
            textoExibicao = textoPreview.toLowerCase();
        }
        if (caixa == 2) {
            textoExibicao = textoPreview.toUpperCase();
        }

        jTextAreaPreview.setText(textoExibicao);
        String textoRolagem = getTextoEnquadrado(jTextAreaPreview);
        impEspelho.setTexto(textoRolagem, nomeArquivo);
        impMonitor.setTexto(textoRolagem, nomeArquivo);
    }

    public void setSelecaoLaudas() {
        if (jComboBox1 == null) {
            return;
        }
        laudaSelecionada = jComboBox1.getSelectedIndex();

        if (laudaSelecionada < 0) {
            return;
        }


        setTextoPreview();
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

    public void limparTela() {
        jTextAreaEdicao.setText("");
        jTextAreaPreview.setText("");
        limpaComboBox();
        numeroLaudasAtual = 0;
        numeroLaudasAnterior = 0;
        laudaSelecionada = 0;
        impEspelho.setTexto("Abrir ou digitar *.txt", "");
        impMonitor.setTexto("Abrir ou digitar *.txt", "");
    }

    public void aumentaVelocidade() {
        if (velocidade < 20) {
            velocidade += 1;
        }
        setAvancoPinturas();
        jSliderVelocidade.setValue(velocidade);
    }

    public void diminuiVelocidade() {
        if (velocidade > 1) {
            velocidade -= 1;
        }
        setAvancoPinturas();
        jSliderVelocidade.setValue(velocidade);
    }

    public void setAvancoPinturas() {
        if (velocidade > 10) {
            avanco = (velocidade - 10);
            pinturas = 1;
        }
        if (velocidade < 10) {
            avanco = 1;
            pinturas = (10 - velocidade);
        }
        if (velocidade == 10) {
            avanco = 1;
            pinturas = 1;
        }
    }

    public void setVelocidade(int i) {
        velocidade = i;
        setAvancoPinturas();
    }

    public synchronized int getPosicao() {
        contaPinturas += 1;
        if ((acima == true) && (contaPinturas >= pinturas)) {
            posicao -= avanco;
        }
        if ((abaixo == true) && (contaPinturas >= pinturas)) {
            posicao += avanco;
        }
        if (contaPinturas >= pinturas) {
            contaPinturas = 0;
        }
        return posicao;
    }

    public void setPosicao(int i) {
        posicao = i;
    }

    public void sobeTexto() {
        acima = true;
        abaixo = false;
        impEspelho.iniciaCronometro();
        impMonitor.iniciaCronometro();
    }

    public void desceTexto() {
        acima = false;
        abaixo = true;
    }

    public void paraTexto() {
        acima = false;
        abaixo = false;
    }

    public void setInicioTexto() {
        acima = false;
        abaixo = false;
        impEspelho.resetCronometro();
        impMonitor.resetCronometro();
        posicao = 0;
    }

    public void setTextoCaixaAlta() {
        caixa = 2;
        setTextoPreview();
    }

    public void setTextoCaixaBaixa() {
        caixa = 1;
        setTextoPreview();
    }

    public void setTextoCaixaNormal() {
        caixa = 0;
        setTextoPreview();
    }

    public void justificaTexto(boolean margem) {
        margemCentro = margem;
        impMonitor.justificaTexto(margemCentro);
        impEspelho.justificaTexto(margemCentro);
    }

    public void setCronometro() {
        exibeCronometro = (!exibeCronometro);
        impEspelho.mostraCronometro(exibeCronometro);
        impMonitor.mostraCronometro(exibeCronometro);
    }

    public void setTempo(int i) {
        tempo = i;
        impEspelho.setTempo(tempo);
        impMonitor.setTempo(tempo);
    }

    public void imprimir() {
        Impressao pt = new Impressao();

        pt.setString(jTextAreaEdicao.getText());
        pt.imprimiTexto();
    }

    public void ajuda() {
        openHelp();
    }

    public void openHelp() {
        String pathToHS = "/docs/helpSet.xml";

        try {
            java.net.URL hsURL = getClass().getResource(pathToHS);
            hs = new javax.help.HelpSet(null, hsURL);
        } catch (Exception ee) {
            System.out.println("HelpSet " + ee.getMessage());
            System.out.println("Help Set " + pathToHS + " not found");
            return;
        }


        hb = hs.createHelpBroker();

        hb.setDisplayed(true);
    }

    class TextFilter extends javax.swing.filechooser.FileFilter {
        TextFilter() {
        }

        public boolean accept(java.io.File f) {
            if (f.isDirectory()) {
                return true;
            }
            String s = f.getName();
            int i = s.lastIndexOf('.');

            if ((i > 0) && (i < s.length() - 1) &&
                    (s.substring(i + 1).toLowerCase().equals("txt"))) {
                return true;
            }


            return false;
        }

        public String getDescription() {
            return "Somente Arquivos *.txt";
        }
    }
}
