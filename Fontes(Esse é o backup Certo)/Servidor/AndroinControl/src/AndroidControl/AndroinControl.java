package AndroidControl;

import BD.BEAN.LogsBean;
import BD.DAO.JDBClogsDAO;
import BD.DAO.LogsDAO;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import serialcom.SerialComLeitura;


public class AndroinControl extends javax.swing.JFrame 
    {
    
    
    
    
    //Retorno da TelaLogar
    static SerialComLeitura serialEscrita;
//    static String usuario = null;
    static int idUsuario = 0;
    
    static String portaArduino = null;
    static int portaSocket = 12345;
    
    static String x;
    static String L1= null;
    static String L2= null;
    static String L3= null;
   // static String ip;


    
    static String senha = "123";
    static String [] buffer = new String[3]; 
    
//***********************************CONSTRUTOR*******************************************
    /** Creates new form Painel */
    public AndroinControl() throws UnknownHostException 
        {
        initComponents();
        //Ip local
        java.net.InetAddress i = java.net.InetAddress.getLocalHost();  
        String ipServer = i.getHostAddress(); 
        labelIp.setText("IP: "+ ipServer);
        Ouvindo T1 = new Ouvindo();
        Thread tarefa;
        tarefa = new Thread(T1);
        tarefa.start();
        }
  
//----------------------------------------main-----------------------------------------------------------------------    
    public static void main(String[] args) throws IOException, Exception 
        {
        }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        LabelServidor = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        liagaLampada2 = new javax.swing.JButton();
        desliagaLampada2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelIp = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        EfeitoTeste = new javax.swing.JMenuItem();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        LabelServidor.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        LabelServidor.setText("Android Control");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(LabelServidor)
                .addContainerGap(193, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelServidor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        liagaLampada2.setText("ON");
        liagaLampada2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                liagaLampada2ActionPerformed(evt);
            }
        });

        desliagaLampada2.setText("Off");
        desliagaLampada2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desliagaLampada2ActionPerformed(evt);
            }
        });

        jButton3.setText("ON");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("ON");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("OFF");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("OFF");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Lampada 1");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Lampada 2");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Lampada 3");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(liagaLampada2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(desliagaLampada2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel2)
                .addGap(78, 78, 78)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(40, 40, 40))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(liagaLampada2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(desliagaLampada2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(60, 60, 60))
        );

        labelIp.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        labelIp.setText("IP: 000.000.000.000");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(labelIp)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelIp)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jMenu3.setText("Sistema");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        jMenuItem4.setText("Reiniciar Sistema");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem5.setText("Sobre");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem1.setText("Saida");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Auditoria");

        jMenuItem2.setText("Verificar Log");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Cadastros");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu1.setText("Efeitos");
        jMenu1.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu1MenuSelected(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        EfeitoTeste.setText("Efeito para Teste");
        EfeitoTeste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EfeitoTesteActionPerformed(evt);
            }
        });
        jMenu1.add(EfeitoTeste);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    private void liagaLampada2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_liagaLampada2ActionPerformed
            L2="S";    
            enviaDadoArduino("S");
            gravarLog(null,"7");//7 = lampada2 ligada //Null - usuario corrente
           // recebeDadoArduino();
    }//GEN-LAST:event_liagaLampada2ActionPerformed

    private void desliagaLampada2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desliagaLampada2ActionPerformed
            L2="A";    
            enviaDadoArduino("A");
            gravarLog(null,"8");//8 = lampada2 Desligada //Null - usuario corrente
           // recebeDadoArduino();      
    }//GEN-LAST:event_desliagaLampada2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
            L1="W";
            enviaDadoArduino("W");
            gravarLog(null,"5");//5 = lampada1 ligada //Null - usuario corrente
          //  recebeDadoArduino();            
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
            L1="Q";
            enviaDadoArduino("Q");
            gravarLog(null,"6");//5 = lampada1 Desligada //Null - usuario corrente
          //  recebeDadoArduino();            
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
            L3="Y";
            enviaDadoArduino("Y");
            gravarLog(null,"9");//9 = lampada3 ligada //Null - usuario corrente
          //  recebeDadoArduino();            
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
            enviaDadoArduino("X");
            L3="X";
            gravarLog(null,"10");//10 = lampada3 ligada //Null - usuario corrente 
          //  recebeDadoArduino();            
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jMenu1MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu1MenuSelected
    }//GEN-LAST:event_jMenu1MenuSelected

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        
        
        TelaDeCadastros Te = new TelaDeCadastros();
        Te.setVisible(true);  
        
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void EfeitoTesteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EfeitoTesteActionPerformed
         SerialComLeitura serialEscrita1 = new SerialComLeitura(portaArduino, 9600, 0);
         serialEscrita1.HabilitarEscrita();
         serialEscrita1.ObterIdDaPorta();
         serialEscrita1.AbrirPorta();
         serialEscrita1.EnviarUmaString("H");
         serialEscrita1.FecharCom();        
         gravarLog(null, "11"); //11 Auto Teste //Null - usuario corrente
                        
    }//GEN-LAST:event_EfeitoTesteActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
    VerificaLogs Logs = new VerificaLogs();
        Logs.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
      
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Object[] options = {"Fechar Programa",
            "Cancelar"
        };
        int n = JOptionPane.showOptionDialog(null,"Sair do Sistema",
            "Android Control",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[1]);

        if(n==0)
        {
            gravarLog(null, "2");//2 = Deslogar do sistema //Null - usuario corrente
            System.exit(1);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
          Object[] options = {"Reinicar Sistema",
            "Cancelar"
        };
        int n = JOptionPane.showOptionDialog(null,"Reiniciar Sistema",
            "Android Control",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[1]);

        if(n==0)
        {
        gravarLog(null, "2");//2 = Deslogar do sistema //Null - usuario corrente
        this.dispose();
        TelaLogar te = new TelaLogar();
        te.setVisible(true);
        }  
       
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed

     Sobre sobre = new Sobre();
        sobre.setVisible(true);   
        
        
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseMoved



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem EfeitoTeste;
    private javax.swing.JLabel LabelServidor;
    private javax.swing.JButton desliagaLampada2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelIp;
    private javax.swing.JButton liagaLampada2;
    // End of variables declaration//GEN-END:variables



    private static class Ouvindo implements Runnable
        {
        static ServerSocket servidor;
        public Ouvindo() 
            {
       // sleepTime=generator.nextInt(240);
            }
    @Override
        public void run() 
           {
     
           while(true)
                {
                    
                try 
                    {
                    servidor = new ServerSocket(portaSocket); 
                    Socket cliente = servidor.accept();
                    String dispositivo = cliente.getInetAddress().getHostAddress();
                  //  if(dispPertenceUsuario(dispositivo))
                  //  {
                    Scanner s = new Scanner(cliente.getInputStream());
                    String log = "0";
                    if(s.hasNext()) 
                        {
                        x = s.nextLine();
                        if(x.equalsIgnoreCase("W"))//5 = lampada1 ligada
                            {
                            L1="W";    
                            log = "5";
                            }
                        if(x.equalsIgnoreCase("Q"))//6 = lampada1 Desligada
                            {
                            L1="Q";    
                            log = "6";
                            }
                        if(x.equalsIgnoreCase("S"))//7 = lampada2 ligada
                            {
                            L2="S";    
                            log = "7";
                            }
                        if(x.equalsIgnoreCase("A"))//8 = lampada2 Desligada
                            {
                            L2="A";
                            log = "8";
                            }
                        if(x.equalsIgnoreCase("Y"))//9 = lampada3 ligada
                            {
                            L3="Y";    
                            log = "9";
                            }
                        if(x.equalsIgnoreCase("X"))//10 = lampada3 desligada
                            {
                            L3="X";
                            log = "10";
                            }
                        enviaDadoArduino(x);
                       // String dado = recebeDadoArduino();  
                        
                        //Envia estado das lampadas para clientes                
                        PrintStream feedback = new PrintStream(cliente.getOutputStream()); 
                        x=L1+L2+L3;
                        feedback.println(x); 
                        gravarLog(dispositivo,log);//Gravar ip do Dispositivo e o logs no Arquivo  
                        }
                    s.close();
                 //   }
                //    else
                 //       {
                  //      JOptionPane.showMessageDialog(null, "dispositivo desconhecido");
                  //      }
                    servidor.close();
                    cliente.close();
                    }
                catch (IOException ex) 
                    {
                    Logger.getLogger(AndroinControl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                }
            }
        }
    
//*******************************************Procedure comunicação com o arduino***********************************    
    static void enviaDadoArduino(String dado)
        {
        SerialComLeitura serialEscrita1 = new SerialComLeitura(portaArduino, 9600, 0);
        serialEscrita1.HabilitarEscrita();
        serialEscrita1.ObterIdDaPorta();
        serialEscrita1.AbrirPorta();
        serialEscrita1.EnviarUmaString(dado);
        serialEscrita1.FecharCom();            
        Toolkit.getDefaultToolkit().beep();
        }
 //*******************************************Procedure escuta porta do arduino***********************************    
    static String recebeDadoArduino()
        {
        String dado = null;
        SerialComLeitura serialleitura = new SerialComLeitura(portaArduino, 9600, 0);
        serialleitura.HabilitarLeitura();
        serialleitura.ObterIdDaPorta();
        serialleitura.AbrirPorta();
        serialleitura.run();
        serialleitura.LerDados();
        //Controle de tempo da leitura aberta na serial
       try 
            {
            Thread.sleep(1000);//Valor correto
            System.out.println("Aqui"+serialleitura.getPeso());
            dado = serialleitura.getPeso();
            }
        catch (InterruptedException ex) 
            {
            System.out.println("Erro na Thread: " + ex);
            }
        serialleitura.FecharCom();
        Toolkit.getDefaultToolkit().beep();
        return dado;
        }
//********************************GRAVALOG****************************************************
//A data atual é inserida pelo banco (on update CURRENT_TIMESTAMP)
//******************************************************************************************    
    static void gravarLog(String usuarioLocal,String acao )
        {
        int acaoInt=Integer.parseInt(acao);
        
        //Grava acao no banco
        LogsBean entidade;
        entidade = new LogsBean();
        //if(usuarioLocal.equals(null))//Verifica se a açao foi feita no server usuarioLocal = null
          //  {
            entidade.setId_Usuario(idUsuario);//Grava o usuario corrente
          /*  }
        else
            {
                
            //tratamento do dono do dispositivo    
            entidade.setId_Usuario(usuarioLocal);//Grava o usuario corrente
             }*/
        entidade.setListaacao_id(acaoInt);
        LogsDAO log;
        try 
            {
            log = new JDBClogsDAO();
            log.insereAcao(entidade);
            }
        catch (Exception ex) 
            {
            Logger.getLogger(VerificaLogs.class.getName()).log(Level.SEVERE, null, ex);
            }    
        }
    
public void setPortaArduino(String portaArduino)
    {
    AndroinControl.portaArduino = portaArduino;
    }

public void setIdUsuario(int idUsuario)
    {
    AndroinControl.idUsuario = idUsuario;
    }

public static boolean dispPertenceUsuario(String dispositivo)
    {
    
        
    return true;     
    }





}
