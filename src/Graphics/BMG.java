package Graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class BMG extends JFrame {
    private static final String SIGNATURE_FOLDER_NAME = "BMG-signatures";
    private static final String MIMI_SIGNATURE_FILE = "mimi-signature.png";
    private static final String KOY_SIGNATURE_FILE = "koy-signature.png";

    private static final Color WINDOW_BG = Color.WHITE;
    private static final Color PINK = new Color(230, 184, 207);
    private static final Color PURPLE = new Color(153, 51, 102);
    private static final Color TEXT_COLOR = new Color(60, 40, 50);
    private static final Color SIGNATURE_COLOR = new Color(120, 40, 80);

    private static final Font TITLE_FONT = new Font("Serif", Font.BOLD, 24);
    private static final Font BUTTON_FONT = new Font("Serif", Font.BOLD, 18);
    private static final Font CONTRACT_FONT = new Font("Serif", Font.PLAIN, 16);
    private static final Font SIGN_LABEL_FONT = new Font("Serif", Font.BOLD, 18);

    private static final String[] NO_MESSAGES = {
        "System error: bad decision detected 🚨",
        "Let me help you—press yes. Trust me, life gets better",
        "Uhmm...That option seems incorrect.",
        "Hmm...that answer looks illegal. Try again",
        "Not saying yes is wrong… but like… it is wrong",
        "Think carefully… your future happiness depends on this choice 🫵"
    };

    private static final String CONTRACT_TEXT =
        "THE AGREEMENT\n\n" +
        "this is not a contract just something i wrote because i like you\n\n" +
        "if you say yes it means we start something nice together\n\n" +
        "20 benefits of being my girlfriend\n\n" +
        "1. you will never be bored you got me to annoy you \n" +
        "2. call me whenever you want im 24/7 ready for you\n" +
        "3. i will support your goals like they are mine\n" +
        "4. if u want i can send u home everyday but since u dont like riding my bike.. im sorry \n" +
        "5. you will have someone who chooses you not just likes you\n" +
        "6. i will be soft with you when it matters\n" +
        "7. you will never question if i care\n" +
        "8. i will grow with you not hold you back\n" +
        "9. when you are sick i will take care of you food medicine hospital i will be there\n" +
        "10. food buddy + dessert dates guaranteed\n" +
        "11. your gym partner -lets build together hehe \n" +
        "12. i will try to make you smile even on bad days\n" +
        "13. study partner sometimes productive sometimes not ToT\n" +
        "14. i will respect your space but still be there when you need me\n" +
        "15. i will be patient with you even when you are a bit annoying (u never tho)\n" +
        "16. you will always have someone on your side\n" +
        "17. late night talks - i will stay up with you when it matters\n" +
        "18. random little surprises just because i thought of you\n" +
        "19. i will stay real with you always\n" +
        "20. if u ever feel lost u will not be alone anymore\n\n" +
        "just so you know\n\n" +
        "- i might be annoying sometimes\n" +
        "- i can be a bit clingy when i miss u\n" +
        "- overthinking..final boss\n\n"+

        "43 reasons why i like koy \n\n" +
        "1. first thing i noticed u are naturally funny\n" +
        "2. you dont even try but still make me laugh\n" +
        "3. you made me feel comfortable since the beginning\n" +
        "4. i remember thinking u are kinda different\n" +
        "5. you are actually very charming and the more i get to know u the more i see it\n" +
        "6. u are sexy like..tua mae fr\n" +
        "7. i like the way u talk it just feels different from everyone else\n" +
        "8. you underestimate yourself a lot but u are actually really smart but u still say others are better than u..ugh\n" +
        "9. u have this calm vibe but also chaotic at the same time somehow\n" +
        "10. i like how u dont fake things u just be yourself\n" +
        "11. u make everything feel easy even when its not \n" +
        "12. being with u feels warm and safe\n" +
        "13. i enjoy just sitting next to u doing nothing\n" +
        "14. i like going out with u\n" +
        "15. that day at the mall when u helped me get out of that seller ToT that moment impressed me a lot\n" +
        "16. i was like damn u are actually so cool because i cant reject people like that but u can\n" +
        "17. i like how u dont get awkward easily u just handle things naturally\n" +
        "18. you are brave when it matters like when my car got hit and u talked for me. i love u even more hehe\n" +
        "19. u make me want to be a better version of myself without forcing me\n" +
        "20. i like how u remember small things about me\n" +
        "21. you take care of yourself really well\n" +
        "22. somehow u take care of me too like when u put sunscreen for me in the morning i felt really nice not gonna lie ngl\n" +
        "23. i feel like i can be myself around u without thinking too much\n" +
        "24. i like watching movies with u even if i cant focus sometimes because my heart beats too fast when im with u\n" +
        "25. even the way u look at me sometimes makes me lose focus\n" +
        "26. you make me nervous in a good way and thats why my hands get wet easily\n" +
        "27. i like how u can be crazy but serious when it comes to studying\n" +
        "28. you care more than u show and sometimes u understand me without me saying anything\n" +
        "29. you never leave me feeling bad\n" +
        "30. and being with u just feels right\n" +
        "31. i like sleeping next to u and just holding u the whole night, lowkey wish we could just sleep and stay like that forever\n" +
        "32. i like it so much i lowkey wish we could just sleep and stay like that forever\n" +
        "33. i like how u have this soft caring vibe, being with u feels like home\n" +
        "34. i get comfortable with u so fast and so easily, it just feels natural\n" +
        "35. i like how u actually value love and take it seriously\n" +
        "36. i like the way u see love as something romantic, it’s rare and i’ve never really seen someone like you before\n" +
        "37. i like when u said if u love someone, u love them hard… that stayed with me\n"+
        "38. i like your bangs, they look really cool on u even if they’re a bit annoying sometimes\n"+
        "39. i like how when i tell u what i dont like, u actually adjust right away… it makes me feel like the luckiest person\n"+
        "40. i like when u tryna aaojai me like taking me to eat what i want\n"+
        "41. i like everything about u, even random things like your armpit is flawless.. \n"+
        "42. i like how u bring out a side of me i dont show to everyone\n"+
        "43. and somehow… out of everyone, u’re the one i chose without even thinking twice\n\n" +
        "i dont know when exactly… but somewhere along the way, i started liking u more than i planned \n"+

        "Signature below indicates graceful acceptance of this heartfelt proposal.";

    private final JButton yesButton = new JButton("Yes");
    private final JButton noButton = new JButton("No");
    private final JLabel questionLabel = new JLabel("Koy, would you consider being my girlfriend?");
    private final Random random = new Random();

    private BufferedImage mimiSignature;
    private BufferedImage koySignature;

    public BMG() {
        setupMainWindow();
        setupQuestionLabel();
        setupButtons();
        addMainComponents();
        attachEvents();
        setVisible(true);
    }

    private void setupMainWindow() {
        setTitle("A Very Important Question");
        setSize(700, 450);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(WINDOW_BG);
        setLocationRelativeTo(null);
    }

    private void setupQuestionLabel() {
        questionLabel.setBounds(60, 70, 600, 40);
        questionLabel.setFont(TITLE_FONT);
        questionLabel.setForeground(PURPLE);
    }

    private void setupButtons() {
        styleButton(yesButton, 170, 240, 140, 50, PINK, BUTTON_FONT);
        styleButton(noButton, 390, 240, 140, 50, new Color(220, 220, 220), new Font("Serif", Font.PLAIN, 18));
    }

    private void styleButton(JButton button, int x, int y, int width, int height, Color color, Font font) {
        button.setBounds(x, y, width, height);
        button.setBackground(color);
        button.setFocusPainted(false);
        button.setFont(font);
    }

    private void addMainComponents() {
        add(questionLabel);
        add(yesButton);
        add(noButton);
    }

    private void attachEvents() {
        yesButton.addActionListener(e -> showContract());

        noButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                moveNoButton();
                questionLabel.setText(getRandomNoMessage());
            }
        });
    }

    private void showContract() {
        JFrame contractFrame = createContractFrame();
        JTextArea contractTextArea = createContractTextArea();
        ScribblePanel koySignPanel = createSignaturePanel();

        JButton doneButton = createDoneButton(contractFrame, koySignPanel);
        JPanel bottomPanel = createContractBottomPanel(koySignPanel, doneButton);

        contractFrame.add(new JScrollPane(contractTextArea), BorderLayout.CENTER);
        contractFrame.add(bottomPanel, BorderLayout.SOUTH);
        contractFrame.setVisible(true);
    }

    private JFrame createContractFrame() {
        JFrame frame = new JFrame("Our Agreement");
        frame.setSize(650, 750);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        return frame;
    }

    private JTextArea createContractTextArea() {
        JTextArea textArea = new JTextArea(CONTRACT_TEXT);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(CONTRACT_FONT);
        textArea.setBackground(WINDOW_BG);
        textArea.setForeground(TEXT_COLOR);
        return textArea;
    }

    private ScribblePanel createSignaturePanel() {
        ScribblePanel panel = new ScribblePanel();
        panel.setPreferredSize(new Dimension(240, 160));
        return panel;
    }

    private JButton createDoneButton(JFrame contractFrame, ScribblePanel koySignPanel) {
        JButton doneButton = new JButton("Done");
        doneButton.setFont(new Font("Serif", Font.BOLD, 16));
        doneButton.setBackground(PINK);
        doneButton.setFocusPainted(false);

        doneButton.addActionListener(e -> {
            mimiSignature = loadSavedSignature(MIMI_SIGNATURE_FILE);
            koySignature = koySignPanel.getSignatureImage();
            File koySavedFile = saveSignatureToFile(koySignature, KOY_SIGNATURE_FILE);

            contractFrame.dispose();
            showFinalPage(koySavedFile);
        });

        return doneButton;
    }

    private JPanel createContractBottomPanel(ScribblePanel koySignPanel, JButton doneButton) {
        JPanel signaturesPanel = new JPanel(new GridLayout(1, 1));
        signaturesPanel.setBackground(WINDOW_BG);
        signaturesPanel.add(createSignatureBox("Sign here:", koySignPanel));

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(WINDOW_BG);
        bottomPanel.add(signaturesPanel, BorderLayout.CENTER);
        bottomPanel.add(doneButton, BorderLayout.SOUTH);
        return bottomPanel;
    }

    private JPanel createSignatureBox(String title, ScribblePanel signPanel) {
        JPanel box = new JPanel(new BorderLayout(0, 8));
        box.setBackground(WINDOW_BG);

        JLabel label = new JLabel(title, JLabel.CENTER);
        label.setFont(SIGN_LABEL_FONT);

        box.add(label, BorderLayout.NORTH);
        box.add(signPanel, BorderLayout.CENTER);
        return box;
    }

    private void showFinalPage(File koySavedFile) {
        JFrame finalFrame = new JFrame("With All My Heart");
        finalFrame.setSize(700, 500);
        finalFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        finalFrame.setLocationRelativeTo(null);

        HeartPanel heartPanel = new HeartPanel(mimiSignature, koySignature);
        heartPanel.setLayout(new BorderLayout());
        heartPanel.setBackground(WINDOW_BG);
        heartPanel.add(createFinalMessageLabel(), BorderLayout.CENTER);

        finalFrame.setContentPane(heartPanel);
        finalFrame.setVisible(true);

        heartPanel.startAnimation();
        showSavedFilesMessage(finalFrame, koySavedFile);
    }

    private JLabel createFinalMessageLabel() {
        JLabel label = new JLabel(
            "<html><div style='text-align: center;'>"
                + "<br><br>"
                + "<h1>Thank you for saying yes</h1>"
                + "<p>This means more than words can properly express.</p>"
                + "<p>From this moment on, I promise sincerity, care, and devotion.</p>"
                + "<p>With affection,<br>Yours truly.</p>"
                + "</div></html>",
            JLabel.CENTER
        );
        label.setFont(new Font("Serif", Font.PLAIN, 22));
        label.setForeground(SIGNATURE_COLOR);
        return label;
    }

    private void showSavedFilesMessage(JFrame parent, File koySavedFile) {
        if (koySavedFile == null) {
            return;
        }

        JOptionPane.showMessageDialog(
            parent,
            "Saved signature:\nKoy: " + koySavedFile.getAbsolutePath(),
            "Signatures Saved",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    private BufferedImage loadSavedSignature(String fileName) {
        File inputFile = new File(getSignatureFolder(), fileName);
        if (!inputFile.exists()) {
            return null;
        }

        try {
            return ImageIO.read(inputFile);
        } catch (IOException ex) {
            showError("Could not load the saved signature:\n" + ex.getMessage());
            return null;
        }
    }

    private File saveSignatureToFile(BufferedImage signatureImage, String fileName) {
        File folder = getSignatureFolder();
        if (!folder.exists() && !folder.mkdirs()) {
            showError("Could not create the signature folder.");
            return null;
        }

        File outputFile = new File(folder, fileName);

        try {
            ImageIO.write(signatureImage, "png", outputFile);
            return outputFile;
        } catch (IOException ex) {
            showError("Could not save the signature:\n" + ex.getMessage());
            return null;
        }
    }

    private File getSignatureFolder() {
        return new File(System.getProperty("user.home"), SIGNATURE_FOLDER_NAME);
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Save Error", JOptionPane.ERROR_MESSAGE);
    }

    private void moveNoButton() {
        int x = random.nextInt(Math.max(1, getWidth() - 150));
        int y = random.nextInt(Math.max(1, getHeight() - 150));
        noButton.setLocation(x, y);
    }

    private String getRandomNoMessage() {
        return NO_MESSAGES[random.nextInt(NO_MESSAGES.length)];
    }

    public static void main(String[] args) {
        new BMG();
    }
}

class HeartPanel extends JPanel {
    private static final Color HEART_COLOR = new Color(220, 100, 140);
    private static final Color SIGNATURE_COLOR = new Color(120, 40, 80);

    private final ArrayList<FloatingHeart> hearts = new ArrayList<>();
    private final Random random = new Random();
    private final BufferedImage mimiSignature;
    private final BufferedImage koySignature;

    HeartPanel(BufferedImage mimiSignature, BufferedImage koySignature) {
        this.mimiSignature = mimiSignature;
        this.koySignature = koySignature;
    }

    public void startAnimation() {
        Timer timer = new Timer(60, e -> {
            addHeartIfNeeded();
            moveHeartsUp();
            hearts.removeIf(heart -> heart.y < -30);
            repaint();
        });
        timer.start();
    }

    private void addHeartIfNeeded() {
        if (hearts.size() >= 25) {
            return;
        }

        hearts.add(new FloatingHeart(
            random.nextInt(Math.max(1, getWidth() - 30)),
            getHeight(),
            20 + random.nextInt(20)
        ));
    }

    private void moveHeartsUp() {
        for (FloatingHeart heart : hearts) {
            heart.y -= 2;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawHearts(g);
        drawSignatureArea((Graphics2D) g);
    }

    private void drawHearts(Graphics g) {
        for (FloatingHeart heart : hearts) {
            g.setFont(new Font("Serif", Font.PLAIN, heart.size));
            g.setColor(HEART_COLOR);
            g.drawString("♥", heart.x, heart.y);
        }
    }

    private void drawSignatureArea(Graphics2D g2) {
        int baseY = getHeight() - 60;
        int mimiLineX1 = getWidth() - 320;
        int mimiLineX2 = getWidth() - 200;
        int koyLineX1 = getWidth() - 180;
        int koyLineX2 = getWidth() - 60;

        g2.setColor(SIGNATURE_COLOR);
        g2.setFont(new Font("Serif", Font.PLAIN, 14));
        g2.drawLine(mimiLineX1, baseY, mimiLineX2, baseY);
        g2.drawLine(koyLineX1, baseY, koyLineX2, baseY);

        if (mimiSignature != null) {
            g2.drawImage(mimiSignature, mimiLineX1, baseY - 55, 110, 40, null);
        }
        if (koySignature != null) {
            g2.drawImage(koySignature, koyLineX1, baseY - 55, 110, 40, null);
        }

        g2.drawString("Mimi", mimiLineX1 + 30, baseY + 20);
        g2.drawString("Koy", koyLineX1 + 35, baseY + 20);
    }
}

class FloatingHeart {
    int x;
    int y;
    int size;

    FloatingHeart(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }
}
