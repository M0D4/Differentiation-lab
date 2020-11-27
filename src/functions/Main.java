package functions;

import com.sun.webkit.ColorChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import tokenizer.AbstractTreeBuilder;
import tokenizer.TokenizerException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Moustafa
 */
public class Main {

    JLabel lab;
    JLabel yLab, example;
    JFrame frame;
    JButton getDriv;
    JButton save;
    JButton chooseColor;
    String eq;
    JTextField jt;
    String forFile;
    BufferedWriter bw;
    JPanel panel;
    JScrollPane scroller;
    Color colorChoose;

    public Main() throws TokenizerException, IOException {

        frame = new JFrame("Differentiation lab");
        frame.setIconImage(new ImageIcon("Icon.ico").getImage());

        lab = new JLabel();
        save = new JButton("save");
        example = new JLabel("        example: x^2 + sin(x)                                               "
                + "                                  "
                + "                                                                               ");
        yLab = new JLabel("y = ");

        frame.add(example);

        frame.setSize(650, 500);
        frame.add(yLab);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setResizable(false);

        jt = new JTextField();
        jt.setSize(610, 30);
        jt.setFont(new Font("CoconNextArabic-light", Font.BOLD, 15));
        jt.setPreferredSize(new Dimension(610, 30));
        jt.setForeground(Color.red);
        frame.add(jt);

        

        getDriv = new JButton("Get Derivative");
        frame.add(getDriv);

        frame.add(save);
        
        chooseColor = new JButton("choose Color");
        chooseColor.setBounds(350, 200, 30, 30);
        frame.add(chooseColor);

        lab.setSize(625, 2000);
        lab.setOpaque(true);
        lab.setPreferredSize(new Dimension(625, 2000));
        lab.setVerticalAlignment(SwingConstants.TOP);
        lab.setHorizontalAlignment(JLabel.LEADING);
        lab.setForeground(Color.BLACK);

        panel = new JPanel();
        panel.add(lab);
        //panel.setOpaque(true);
        //panel.setBackground(Color.decode("#2B9EB3"));
        panel.setBorder(new EmptyBorder(6, 20, 0, 0));
        panel.setPreferredSize(new Dimension(625, 2000));

        scroller = new JScrollPane(panel);
        scroller.setOpaque(true);

        scroller.setPreferredSize(new Dimension(630, 490));
        frame.add(scroller);

        getDriv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    eq = jt.getText().toLowerCase();
                    calc(eq);
                } catch (TokenizerException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        chooseColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorChoose = JColorChooser.showDialog(null, "choose color", Color.decode("#2B9EB3"));
                frame.getContentPane().setBackground(colorChoose);
                lab.setBackground(colorChoose);
                scroller.setBackground(colorChoose);
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (eq != null && lab.getText() != null) {

                        JFileChooser fc = new JFileChooser();
                        fc.showSaveDialog(null);
                        fc.setLayout(new FlowLayout());
                        String bath = fc.getSelectedFile().toPath().toString() + ".html";

                        bw = new BufferedWriter(new FileWriter(bath, true));
                        bw.write("y = " + eq + "</br>");
                        bw.write(lab.getText() + "</br></br>");
                        bw.close();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NullPointerException e2) {

                }
            }
        });

        frame.setVisible(true);

    }

    public void calc(String eq) throws TokenizerException {
        String op = eq;
        if (op.startsWith("-")) {
            op = "0" + op;
        }
        op = op.replace("(-", "(0-");
        AbstractTreeBuilder tree = new AbstractTreeBuilder(op);
        Operation drev = tree.getTree().getDerivative();
        String drev2 = drev.toString();

        drev2 = reform1(drev2);

        forFile = drev2;
        forFile = "<html>\n"
                + "<head>\n"
                + "<style>\n"
                + "body {\n"
                + "background-color: #d24dff\n"
                + "}" + forFile + "<html>\n"
                + "<head>\n"
                + "<style>\n"
                + "body {\n"
                + "background-color: #d24dff\n"
                + "}";
        drev2 = reform2(drev2);

        lab.setText(drev2);
        lab.setToolTipText("derivative");
        lab.setFont(new Font("Berlin Sans FB Demi Bold", Font.BOLD, 19));

    }

    public String reform1(String drev2) {
        drev2 = drev2.replace("++", "+");
        drev2 = drev2.replace("+-", "-");
        drev2 = drev2.replace("-+", "-");
        drev2 = drev2.replace("--", "+");
        drev2 = drev2.replace("(0.0-", "(-");

        drev2 = drev2.replace("(0.0+", "(+");

        drev2 = drev2.replace("(0+", "(+");

        drev2 = drev2.replace("(0-", "(-");

        drev2 = drev2.replaceAll("(-0)", "(0)");

        drev2 = drev2.replaceAll("(0-0)", "(0)");

        drev2 = drev2.replace("((-0)*(log(x))+", "");
        drev2 = drev2.replace("((0)*(x)+", "(");
        drev2 = drev2.replace("(0)*(x)+", "");
        drev2 = drev2.replace("((0))*(x)+", "");
        drev2 = drev2.replace("((0))*(x)-", "-");

        drev2 = drev2.replace("((0))*(sin(x))+", "");
        drev2 = drev2.replace("((0))*(sin(x))-", "-");
        drev2 = drev2.replace("((0))*(asin(x))+", "");
        drev2 = drev2.replace("((0))*(asin(x))-", "-");

        drev2 = drev2.replace("((0))*(cos(x))+", "");
        drev2 = drev2.replace("((0))*(cos(x))-", "-");
        drev2 = drev2.replace("((0))*(acos(x))+", "");
        drev2 = drev2.replace("((0))*(acos(x))-", "-");

        drev2 = drev2.replace("((0))*(tan(x))+", "");
        drev2 = drev2.replace("((0))*(tan(x))-", "-");
        drev2 = drev2.replace("((0))*(atan(x))+", "");
        drev2 = drev2.replace("((0))*(atan(x))-", "-");

        drev2 = drev2.replace("((0)*(x)-", "(-");
        drev2 = drev2.replace("(0)*(x)-", "-");
        drev2 = drev2.replace("((0)*(log(x))+", "(");
        drev2 = drev2.replace("((0)*(log(x))-", "(-");
        drev2 = drev2.replace("((0))*(log(x))+", "");
        drev2 = drev2.replace("((0))*(log(x))-", "-");

        drev2 = drev2.replace("((-0)*(log(x))-", "-");

        return drev2;
    }

    public String reform2(String drev2) {
        drev2 = drev2.replace("++", "+");
        drev2 = drev2.replace("+-", "-");
        drev2 = drev2.replace("-+", "-");
        drev2 = drev2.replace("--", "+");
        drev2 = drev2.replace("+", " + ");
        drev2 = drev2.replace("*", " * ");
        drev2 = drev2.replaceAll("-", " - ");
        drev2 = drev2.replaceAll("\\( -", "(-");
        drev2 = drev2.replaceAll("/", " / ");
        drev2 = drev2.replaceAll("<STARTsup>", "<sup>");
        drev2 = drev2.replaceAll("<STARTsub>", "<sub>");
        drev2 = drev2.replaceAll("<ENDsup>", "</sup>");
        drev2 = drev2.replaceAll("<ENDsub>", "</sub>");
        drev2 = drev2.replaceAll("<STARTp>", "<p>");
        drev2 = drev2.replaceAll("<ENDp>", "</p>");
        drev2 = "y<sup>\\</sup> = " + drev2;
        drev2 = "<html>" + drev2 + "</html>";

        return drev2;
    }

    public static void main(String[] args) throws TokenizerException, IOException {
        Main m = new Main();
    }
}
