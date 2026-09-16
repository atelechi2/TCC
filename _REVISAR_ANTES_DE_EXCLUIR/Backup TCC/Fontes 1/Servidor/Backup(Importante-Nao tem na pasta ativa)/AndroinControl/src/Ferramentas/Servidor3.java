package Ferramentas;

import AndroidControl.*;
import java.sql.*;   
import FerramentasArduino.*;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import serialcom.SerialComLeitura;
import java.text.SimpleDateFormat; 
import java.util.Date;
import serialcom.SerialCom;


public class Servidor3 extends javax.swing.JFrame {
    static SerialComLeitura serialEscrita;
    static String x;
    static boolean L1= false;
    static boolean L2= false;
    static boolean L3= false;
    static String ip;
    static String portaArduino = "COM7";
    static int portaSocket = 12345;
    static String usuario = "atelechi";
    static String senha = "123";
    static String [] buffer = new String[3]; 
    
 
    /** Creates new form Painel */
    public Servidor3() throws UnknownHostException 
        {
        initComponents();
        java.net.InetAddress i = java.net.InetAddress.getLocalHost();  
        String ipServer = i.getHostAddress(); 
        labelIp.setText("IP: "+ ipServer);
        serialEscrita = new SerialComLeitura(portaArduino, 9600, 0);
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
        labelIp = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        Saida = new javax.swing.JMenu();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        LabelServidor.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        LabelServidor.setText("Android Control");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(LabelServidor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        liagaLampada2.setEnabled(false);
        liagaLampada2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                liagaLampada2ActionPerformed(evt);
            }
        });

        desliagaLampada2.setText("Off");
        desliagaLampada2.setEnabled(false);
        desliagaLampada2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desliagaLampada2ActionPerformed(evt);
            }
        });

        jButton3.setText("ON");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("ON");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("OFF");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("OFF");
        jButton6.setEnabled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(liagaLampada2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(desliagaLampada2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 30, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(liagaLampada2, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(desliagaLampada2, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(labelIp)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelIp)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Configuração");
        jMenu1.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu1MenuSelected(evt);
            }
        });

        jMenuItem1.setText("Comunicação com o Arduino");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Auditoria");

        jMenuItem2.setText("Verificar Log");
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Cadastros");
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        Saida.setText("Saida");
        Saida.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                SaidaMenuSelected(evt);
            }
        });
        Saida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaidaActionPerformed(evt);
            }
        });
        Saida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SaidaKeyPressed(evt);
            }
        });
        jMenuBar1.add(Saida);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
//----------------------------------------main-----------------------------------------------------------------------    
    public static void main(String[] args) throws IOException, Exception 
        {
        Servidor3 g = new Servidor3();
        g.setVisible(true);   
        
        //Inicia Arduino  
        System.out.println("AUTO TESTE");
        enviaDadoArduino("Q");
        enviaDadoArduino("A");
        enviaDadoArduino("X");
        System.out.println("*****************************");
        System.out.println("* Arduino pronto para o uso *");
        System.out.println("*****************************");        
        g.jButton3.setEnabled(true);
        g.jButton5.setEnabled(true);
        g.liagaLampada2.setEnabled(true);
        g.desliagaLampada2.setEnabled(true);
        g.jButton4.setEnabled(true);
        g.jButton6.setEnabled(true);
        //Thred da conexão
        Ouvindo T1 = new Ouvindo();
        Thread tarefa;
        tarefa = new Thread(T1);
        tarefa.start();
        }
    
    
    private void liagaLampada2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_liagaLampada2ActionPerformed
            L2=true;    
            enviaDadoArduino("S");
            gravarLog("|cliente:"+usuario+"|","S");
            recebeDadoArduino();
    }//GEN-LAST:event_liagaLampada2ActionPerformed

    private void desliagaLampada2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desliagaLampada2ActionPerformed
            L2=false;    
            enviaDadoArduino("A");
            gravarLog("|cliente:"+usuario+"|","A");
            recebeDadoArduino();            
            
    }//GEN-LAST:event_desliagaLampada2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
            L1=true;
            enviaDadoArduino("W");
            gravarLog("|cliente:"+usuario+"|","W");
            recebeDadoArduino();            
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
            L1=false;
            enviaDadoArduino("Q");
            gravarLog("|cliente:"+usuario+"|","Q");
            recebeDadoArduino();            
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
            L3=true;
            enviaDadoArduino("Y");
            gravarLog("|cliente:"+usuario+"|","Y");
            recebeDadoArduino();            
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
            enviaDadoArduino("X");
            L3=false;
            gravarLog("|cliente:"+usuario+"|","X");
            recebeDadoArduino();            
    }//GEN-LAST:event_jButton6ActionPerformed

    private void SaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaidaActionPerformed

       // JOptionPane.showInputDialog("Teste");
       //  
        
        
    }//GEN-LAST:event_SaidaActionPerformed

    private void SaidaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SaidaKeyPressed

       // JOptionPane.showInputDialog("Teste");
    }//GEN-LAST:event_SaidaKeyPressed

    private void SaidaMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_SaidaMenuSelected
   
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
               System.exit(1);    
               }
            
             //}
       
        //Toolkit.getDefaultToolkit().beep();*/

    }//GEN-LAST:event_SaidaMenuSelected

    private void jMenu1MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu1MenuSelected
       
       Object[] options = {"Fechar Programa",
                         "Cancelar"
                       };
            int n = JOptionPane.showOptionDialog(null,"Escolha a porta do arduino",
                                                            "Android Control",
                                                             JOptionPane.YES_NO_CANCEL_OPTION,
                                                            JOptionPane.QUESTION_MESSAGE,
                                                            null,
                                                            options,
                                                            options[1]);
            
             if(n==0)
               {
               System.exit(1);    
               }
            
        
        
        
        
        
        
    }//GEN-LAST:event_jMenu1MenuSelected



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelServidor;
    private javax.swing.JMenu Saida;
    private javax.swing.JButton desliagaLampada2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
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
                   // System.out.println("Conexão com o cliente " + cliente.getInetAddress().getHostAddress());
                    Scanner s = new Scanner(cliente.getInputStream());
                    if(s.hasNext()) 
                        {
                        x = s.nextLine();
                        if(x.equalsIgnoreCase("Q"))
                            {
                            L1=false;    
                            }
                        if(x.equalsIgnoreCase("W"))
                            {
                            L1=true;    
                            }
                        if(x.equalsIgnoreCase("A"))
                            {
                            L2=false;    
                            }
                        if(x.equalsIgnoreCase("S"))
                            {
                            L2=true;    
                            }
                        if(x.equalsIgnoreCase("X"))
                            {
                            L3=false;    
                            }
                        if(x.equalsIgnoreCase("Y"))
                            {
                            L3=true;    
                            }
                        enviaDadoArduino(x);
                        String dado = recebeDadoArduino();                        
            //Envia estado das lampadas para clientes                
                        PrintStream feedback = new PrintStream(cliente.getOutputStream()); 
                        
                        feedback.println(x); 
            //Gravar logs no Arquivo            
                        gravarLog("|cliente:"+cliente.getInetAddress().getHostAddress()+"|",x);
                        }
                    s.close();
                    servidor.close();
                    cliente.close();
                    }
                catch (IOException ex) 
                    {
                    Logger.getLogger(Servidor3.class.getName()).log(Level.SEVERE, null, ex);
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
  //      serialleitura.serialEvent(null)
        
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
    
    
    
    
    static void gravarLog(String usuarioLocal,String acao )
        {
        //*************************Grava em Arquivo***********************************                    
        try 
            {  
            File arquivo;  
            arquivo = new File("c:\\arquivo.txt");  
            FileOutputStream fos = new FileOutputStream(arquivo,true);
            Date date = new Date(); 
            SimpleDateFormat logData = new SimpleDateFormat("dd/MM/yyyy hh:mm");	
            fos.write(logData.format(date).getBytes());
            fos.write(usuarioLocal.getBytes());
            String texto = null;

            if(acao.equals("Q"))
                {
                texto = "desligada lampada 1";
                }
            if(acao.equals("W"))
                {
                texto = "Ligada lampada 1";
                }
            if(acao.equals("A"))
                {
                texto = "desligada lampada 2";
                }
            if(acao.equals("S"))
                {
                texto = "Ligada lampada 2";
                }
            if(acao.equals("X"))
                {
                texto = "desligada lampada 3";
                }
            if(acao.equals("Y"))
                {
                texto = "Ligada lampada 4";
                }
            fos.write(texto.getBytes());
            String espaco ="\n";
            fos.write(espaco.getBytes());
            fos.close();  
            System.out.println(logData.format(date)+usuarioLocal+texto);
            }  
        catch (Exception ee) 
            {  
            ee.printStackTrace();  
            } 
        }
}






                        //System.out.println(L1+" "+L2+" "+L3);
                        //Arduino
                        /*serialEscrita.HabilitarEscrita();
                        serialEscrita.ObterIdDaPorta();
                        serialEscrita.AbrirPorta();
                        serialEscrita.EnviarUmaString(x);
                        serialEscrita.FecharCom();
                        Toolkit.getDefaultToolkit().beep();*/
