/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gourmet.sistema;

import gourmet.conexao.conexaoGourmet;
import java.awt.Image;
import java.awt.Toolkit;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rafael S. Paes Leme - Desenvolvedor Java|PHP|MySQL
 */
public class jogo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException, InterruptedException {

        setIcon();
        
        String msg_sabor = "", msg_tipo = "";

        Connection conn = conexaoGourmet.GeraConexao();

        String sql = "SELECT * FROM tab_adivinha WHERE situacao = 1";

        PreparedStatement comando = conn.prepareStatement(sql);

        ResultSet rs = comando.executeQuery();

        while (rs.next()) {

            msg_tipo = rs.getString("nome_adivinha");
            msg_sabor = rs.getString("nome_adivinha2");

        }

        //Fechar as conexões
        comando.close();
        conn.close();

        String mensagem1 = "Pense em um prato que gosta", titulo1 = "Jogo Gourmet";

        Object[] options1 = {"OK"};
        int n1 = JOptionPane.showOptionDialog(null,
                mensagem1, titulo1,
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options1,
                options1[0]);

        //confirmando primeira janela
        if (n1 == JOptionPane.YES_OPTION) {

            String mensagem2 = "O prato que você pensou é " + msg_sabor + "?", titulo2 = "Jogo Gourmet";

            Object[] options2 = {"SIM", "NÃO"};
            int n2 = JOptionPane.showOptionDialog(null, mensagem2, titulo2,
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options2,
                    options2[0]);

            //confirmando segunda janela
            if (n2 == JOptionPane.YES_OPTION) {

                String mensagem3 = "O prato que você pensou é " + msg_tipo + "?", titulo3 = "Jogo Gourmet";

                Object[] options3 = {"SIM", "NÃO"};
                int n3 = JOptionPane.showOptionDialog(null, mensagem3, titulo3,
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options3,
                        options3[0]);

                //confirmando terceira janela
                if (n3 == JOptionPane.YES_OPTION) {

                    JOptionPane.showMessageDialog(null, "Acertei!");

                } else {
                    System.out.println("");
                    if ("doce".equalsIgnoreCase(msg_sabor) || "bolo".equalsIgnoreCase(msg_sabor) || "torta".equalsIgnoreCase(msg_sabor) || "pudim".equalsIgnoreCase(msg_sabor) || "mousse".equalsIgnoreCase(msg_sabor) || "sorvete".equalsIgnoreCase(msg_sabor) || "pavê".equalsIgnoreCase(msg_sabor)) {

                        String mensagem5 = "O prato que você pensou é " + msg_sabor.replace("B", "b").replace("D", "d").replace("T", "t").replace("P", "p").replace("M", "m").replace("S", "s") + " de chocolate?", titulo5 = "Jogo Gourmet";

                        Object[] options5 = {"SIM", "NÃO"};
                        int n5 = JOptionPane.showOptionDialog(null, mensagem5, titulo5,
                                JOptionPane.YES_NO_CANCEL_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                options5,
                                options5[0]);

                        //confirmando terceira janela
                        if (n5 == JOptionPane.YES_OPTION) {

                            JOptionPane.showMessageDialog(null, "Acertei!");

                        } else {

                            String mensagemInput = "Qual prato você pensou?";
                            String recebe_msg_sabor = JOptionPane.showInputDialog(mensagemInput);

                            String mensagemInput2 = recebe_msg_sabor + " é ____________, mas " + msg_tipo + " não.";
                            String recebe_msg_tipo = JOptionPane.showInputDialog(mensagemInput2);

                            Connection conn2 = conexaoGourmet.GeraConexao();

                            String sql2 = "UPDATE tab_adivinha SET nome_adivinha = '" + recebe_msg_sabor + "', nome_adivinha2 = '" + recebe_msg_tipo + "' WHERE id = 1";

                            PreparedStatement comando2 = conn2.prepareStatement(sql2);

                            //Execulta o comando no banco
                            comando2.executeUpdate();

                            //Fechar as conecções
                            comando2.close();
                            conn2.close();

                            Process pro = Runtime.getRuntime().exec("cmd.exe /C  javaw.exe -jar ..\\dist\\JogoGourmet.jar");
                            pro.waitFor();

                        }

                    } else {

                        String mensagem5 = "O prato que você pensou é " + msg_sabor + " de nozes?", titulo5 = "Jogo Gourmet";

                        Object[] options5 = {"SIM", "NÃO"};
                        int n5 = JOptionPane.showOptionDialog(null, mensagem5, titulo5,
                                JOptionPane.YES_NO_CANCEL_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                options5,
                                options5[0]);

                        //confirmando terceira janela
                        if (n5 == JOptionPane.YES_OPTION) {

                            JOptionPane.showMessageDialog(null, "Acertei!");

                        } else {

                            String mensagemInput = "Qual prato você pensou?";
                            String recebe_msg_sabor = JOptionPane.showInputDialog(mensagemInput);

                            String mensagemInput2 = recebe_msg_sabor + " é ____________, mas " + msg_tipo + " não.";
                            String recebe_msg_tipo = JOptionPane.showInputDialog(mensagemInput2);

                            Connection conn2 = conexaoGourmet.GeraConexao();

                            String sql2 = "UPDATE tab_adivinha SET nome_adivinha = '" + recebe_msg_sabor + "', nome_adivinha2 = '" + recebe_msg_tipo + "' WHERE id = 1";

                            PreparedStatement comando2 = conn2.prepareStatement(sql2);

                            //Execulta o comando no banco
                            comando2.executeUpdate();

                            //Fechar as conecções
                            comando2.close();
                            conn2.close();

                            Process pro = Runtime.getRuntime().exec("cmd.exe /C  javaw.exe -jar ..\\dist\\JogoGourmet.jar");
                            pro.waitFor();

                        }

                    }//aaaaaaaaaaaaaaaaaaaaaaaaaa
                }
            } else {
                System.out.println("");
                if (!"salgado".equalsIgnoreCase(msg_sabor) || !"torta".equalsIgnoreCase(msg_sabor) 
                        || !"bolo".equalsIgnoreCase(msg_sabor) || !"refeição".equalsIgnoreCase(msg_sabor) || !"lanche".equalsIgnoreCase(msg_sabor)) {

                    String mensagemNao1 = "O prato que você pensou é doce de tapioca?", tituloNao1 = "Jogo Gourmet";

                    Object[] optionsNao = {"SIM", "NÃO"};
                    int n3 = JOptionPane.showOptionDialog(null, mensagemNao1, tituloNao1,
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            optionsNao,
                            optionsNao[0]);

                    //confirmando tela de não primeira janela
                    if (n3 == JOptionPane.YES_OPTION) {

                        JOptionPane.showMessageDialog(null, "Acertei!");

                    } else {

                        String mensagemInput = "Qual prato você pensou?";
                        String recebe_msg_sabor = JOptionPane.showInputDialog(mensagemInput);

                        String mensagemInput2 = recebe_msg_sabor + " é ____________, mas " + msg_tipo + " não.";
                        String recebe_msg_tipo = JOptionPane.showInputDialog(mensagemInput2);

                        Connection conn2 = conexaoGourmet.GeraConexao();

                        String sql2 = "UPDATE tab_adivinha SET nome_adivinha = '" + recebe_msg_sabor + "', nome_adivinha2 = '" + recebe_msg_tipo + "' WHERE id = 1";

                        PreparedStatement comando2 = conn2.prepareStatement(sql2);

                        //Execulta o comando no banco
                        comando2.executeUpdate();

                        //Fechar as conecções
                        comando2.close();
                        conn2.close();

                        Process pro = Runtime.getRuntime().exec("cmd.exe /C  javaw.exe -jar ..\\dist\\JogoGourmet.jar");
                        pro.waitFor();

                    }

                } else {

                    String mensagemNao1 = "O prato que você pensou é Bolo de chocolate?", tituloNao1 = "Jogo Gourmet";

                    Object[] optionsNao = {"SIM", "NÃO"};
                    int n3 = JOptionPane.showOptionDialog(null, mensagemNao1, tituloNao1,
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            optionsNao,
                            optionsNao[0]);

                    //confirmando tela de não primeira janela
                    if (n3 == JOptionPane.YES_OPTION) {

                        String mensagem5 = "O prato que você pensou é " + msg_sabor + "?", titulo5 = "Jogo Gourmet";

                        Object[] options5 = {"SIM", "NÃO"};
                        int n5 = JOptionPane.showOptionDialog(null, mensagem5, titulo5,
                                JOptionPane.YES_NO_CANCEL_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                options5,
                                options5[0]);

                        //confirmando terceira janela
                        if (n5 == JOptionPane.YES_OPTION) {

                            JOptionPane.showMessageDialog(null, "Acertei!");

                        } else {

                            String mensagemInput = "Qual prato você pensou?";
                            String recebe_msg_sabor = JOptionPane.showInputDialog(mensagemInput);

                            String mensagemInput2 = recebe_msg_sabor + " é ____________, mas " + msg_tipo + " não.";
                            String recebe_msg_tipo = JOptionPane.showInputDialog(mensagemInput2);

                            Connection conn2 = conexaoGourmet.GeraConexao();

                            String sql2 = "UPDATE tab_adivinha SET nome_adivinha = '" + recebe_msg_sabor + "', nome_adivinha2 = '" + recebe_msg_tipo + "' WHERE id = 1";

                            PreparedStatement comando2 = conn2.prepareStatement(sql2);

                            //Execulta o comando no banco
                            comando2.executeUpdate();

                            //Fechar as conecções
                            comando2.close();
                            conn2.close();

                            Process pro = Runtime.getRuntime().exec("cmd.exe /C  javaw.exe -jar ..\\dist\\JogoGourmet.jar");
                            pro.waitFor();

                        }

                    } else {

                        String mensagemInput = "Qual prato você pensou?";
                        String recebe_msg_sabor = JOptionPane.showInputDialog(mensagemInput);

                        String mensagemInput2 = recebe_msg_sabor + " é ____________, mas " + msg_tipo + " não.";
                        String recebe_msg_tipo = JOptionPane.showInputDialog(mensagemInput2);

                        Connection conn2 = conexaoGourmet.GeraConexao();

                        String sql2 = "UPDATE tab_adivinha SET nome_adivinha = '" + recebe_msg_sabor + "', nome_adivinha2 = '" + recebe_msg_tipo + "' WHERE id = 1";

                        PreparedStatement comando2 = conn2.prepareStatement(sql2);

                        //Execulta o comando no banco
                        comando2.executeUpdate();

                        //Fechar as conecções
                        comando2.close();
                        conn2.close();

                        Process pro = Runtime.getRuntime().exec("cmd.exe /C  javaw.exe -jar ..\\dist\\JogoGourmet.jar");
                        pro.waitFor();

                    }

                }//bbbbbbbbbbbbbbbbbbbbbbbbbbb

            }

        }
    }

    public void setIcon() {

                setIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("")));
       
    }


}
