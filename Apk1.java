package umilatorr;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;





public class Apk1 {

    Umilacz sraka;
    public static  ChromeDriver driver;
    private JFrame frmUmilator;
    private JTextField Alias;
    boolean sprawdzanko;
    boolean przejdz;
    boolean  alias= true;
    boolean  token=false; 
    boolean  bazowka=false;
    boolean  rachunek=false;
    private int Radio_Stan;
    private String telefonbezstafki = null;
    private JTextField Imie;
    private JTextField nazwisko;
    private JTextField telefon;
    private JTextField email;
    private JTextField Status;
    private JTextField definicja;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JTextField Nrref;
    private JTextField vdOD;
    private JTextField vDo;
    private JTextField cdOD;
    private JTextField cdDO;
    private JTextField AML_IMIE;
    private JTextField AML_NAZWISKO;
    private final ButtonGroup buttonGroup_1 = new ButtonGroup();
    private final ButtonGroup buttonGroup_2 = new ButtonGroup();
    private JTextField KwotaOd;
    private JTextField KwotaDo;
    private JTextField Format;
    private JTextField txtDataDdmmrrrr;
    private JTextField txtKwota;
    private JTable table;
    private JTextField Waluta;
    private String[] split;
    private JTextPane txtpnError;
    /**
     * Launch the application.
     */


    //klasa aby nie wylogowywalo
    public void szlip() {   
            int C = 1;
        while (true) {
            try {

                TimeUnit.MINUTES.sleep(1);
                WebDriverWait wait = new WebDriverWait(driver, 9999);                                   
                wait.until(ExpectedConditions.elementToBeClickable(By.id("PortalAppSwitcher")));
                driver.findElement(By.id("PortalAppSwitcher")).click();
                driver.findElement(By.id("PortalAppSwitcher")).click();                     
                driver.findElement(By.xpath("/html/body/div[8]/div[1]")).click();
                driver.findElement(By.xpath("/html/body/div[8]/div[1]")).click();
                driver.findElement(By.id("lastLoginMessage")).click();  
                driver.findElement(By.id("lastLoginMessage")).click();  


                System.out.println("non log off"+ " " + C);
                C++;


            } catch (Exception u) {                 


                System.out.println("nie moge kliknac w non log off");
            }


        }
    }   



        //pobieranie tekstow motywacyjnych
    public void motywacja() {
    try { 

        BufferedReader xd;

        xd = new BufferedReader(new FileReader("\\\\olscmesf001\\Data_Oth\\Bohaterowie_CitiDirect\\MotywacyjneTeksty.txt"));
        String line = xd.readLine();
        split = line.split(";",-1);
        int count = line.length() - line.replace(";", "").length();

        while(true) {
            Random rand = new Random();
            TimeUnit.SECONDS.sleep(120);
            int n = rand.nextInt(count);
            n += 1;

            txtpnError.setText(split[n]);



        }
    }
    catch (Exception u) {               


        System.out.println("nie moge kliknac w non log off");
    }

    }






    public static void main(String[] args) {    


        EventQueue.invokeLater(new Runnable() {
            public void run() {     
                try {



                    //wybranie drivera
            System.setProperty("webdriver.chrome.driver", ".\\Resources\\chromedriver.exe");    
                driver = new ChromeDriver();
                }   
                catch (Exception u) {
                        int glupiiterator = 0;
                        List <String> line = new ArrayList<String>();
                        Scanner scanner = new Scanner(u.toString());
                        while (scanner.hasNextLine()) {
                          glupiiterator ++;
                          line.add(scanner.nextLine());
                          if (glupiiterator>2) {break;}
                          // process the line
                        }
                        scanner.close();
                        System.out.println("\n");
                        if (line.get(0).contains("This version of ChromeDriver only supports Chrome")) {
                            String versionnumber;
                            versionnumber = line.get(1).substring(27, 30);
                            try {
                                Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f");
                                TimeUnit.SECONDS.sleep(2);
                                Files.move(Paths.get(".//SeleniumDrivers//" + versionnumber + "//chromedriver.exe"), Paths.get(".//chromedriver.exe"), StandardCopyOption.REPLACE_EXISTING);
                                return;
                            } catch (IOException | InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("\n");
                }

                driver.get("https://www.citidirect.com/login/landing");                     
                Apk1 window = new Apk1();
                window.frmUmilator.setVisible(true);



            }

        });
    }





    /**
     * Create the application.
     */
    public Apk1() {
        new Thread(this::szlip).start();
        new Thread(this::motywacja).start();

        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() { 
        frmUmilator = new JFrame();
        frmUmilator.setResizable(false);
        frmUmilator.setFont(new Font("Dialog", Font.PLAIN, 65));
        frmUmilator.setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Resources\\icon.png"));
        frmUmilator.setTitle("Umilator");
        frmUmilator.setAlwaysOnTop(true);
        frmUmilator.getContentPane().setBackground(new Color(0,0,0,0));
        frmUmilator.setBounds(100, 100, 548, 310);
        frmUmilator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmUmilator.getContentPane().setLayout(null);


        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBackground(new Color(255, 255, 255));
        tabbedPane.setBounds(0, 0, 454, 271);
        frmUmilator.getContentPane().add(tabbedPane);

        JPanel Umilator = new JPanel();
        Umilator.setBackground(new Color(0,0,0,0));
        tabbedPane.addTab("Umilator", null, Umilator, null);
        tabbedPane.setBackgroundAt(0, new Color(255, 255, 255));
        tabbedPane.setEnabledAt(0, true);
        Umilator.setLayout(null);




        definicja = new JTextField();
        definicja.setBounds(12, 11, 183, 22);
        Umilator.add(definicja);
        definicja.setBackground(Color.WHITE);
        definicja.setEditable(false);
        definicja.setColumns(10);

        telefon = new JTextField();
        telefon.setHorizontalAlignment(SwingConstants.LEFT);
        telefon.setBounds(232, 212, 100, 22);
        Umilator.add(telefon);
        telefon.setBackground(Color.WHITE);
        telefon.setText("");
        telefon.setEditable(false);
        telefon.setColumns(10);

        email = new JTextField();
        email.setHorizontalAlignment(SwingConstants.LEFT);
        email.setBounds(342, 212, 100, 22);
        Umilator.add(email);
        email.setBackground(Color.WHITE);
        email.setText("");
        email.setEditable(false);
        email.setColumns(10);


        txtpnError = new JTextPane();
        txtpnError.setBounds(310, 98, 132, 80);
        Umilator.add(txtpnError);
        txtpnError.setEditable(false);
        txtpnError.setForeground(Color.BLACK);
        txtpnError.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtpnError.setBackground(new Color(132,188,218));

        JButton Znajdz_Admina = new JButton("Znajdz\r\n Admina");
        Znajdz_Admina.setBackground(new Color(255, 255, 255));
        Znajdz_Admina.setBounds(337, 44, 105, 23);
        Umilator.add(Znajdz_Admina);
        Znajdz_Admina.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {


                WebDriverWait wait = new WebDriverWait(driver, 5);
                try {
                    driver.switchTo().defaultContent(); 
                    txtpnError.setText("");
                    wait.until(ExpectedConditions.elementToBeClickable(By.id("uifw-megamenu-109")));
                    driver.findElement(By.id("uifw-megamenu-109")).click();         
                    wait.until(ExpectedConditions.elementToBeClickable(By.id("sitemap-109-301-394")));
                    driver.findElement(By.id("sitemap-109-301-394")).click();           
                    driver.switchTo().frame("idashboard"); 

                    wait.until(ExpectedConditions.elementToBeClickable(By.id("usermenu")));
                    driver.findElement(By.id("usermenu")).click();  

                    wait.until(ExpectedConditions.elementToBeClickable(By.id("AMA_NAV_AP")));
                    driver.findElement(By.id("AMA_NAV_AP")).click();    

                    wait.until(ExpectedConditions.elementToBeClickable(By.id("ui-id-2")));
                    driver.findElement(By.id("ui-id-2")).click();

                    TimeUnit.SECONDS.sleep(3);  

                    wait.until(ExpectedConditions.elementToBeClickable(By.id("OuterPanel_toggleLeftText")));
                    driver.findElement(By.id("OuterPanel_toggleLeftText")).click();

                    wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_Criteria_AccessProfileName_FilterValue")));
                    driver.findElement(By.id("Criteria_Criteria_AccessProfileName_FilterValue")).sendKeys("ADMIN");

                    wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_Criteria_AccessProfileName_FilterType_IconAnchor")));
                    driver.findElement(By.id("Criteria_Criteria_AccessProfileName_FilterType_IconAnchor")).click();

                    wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_Criteria_AccessProfileName_FilterType_Contains")));
                    driver.findElement(By.id("Criteria_Criteria_AccessProfileName_FilterType_Contains")).click();

                    wait.until(ExpectedConditions.elementToBeClickable(By.id("OuterPanel_go")));
                    driver.findElement(By.id("OuterPanel_go")).click();         
                    driver.switchTo().defaultContent();         
                }

                catch(Exception b) {
                    txtpnError.setText("jest niemilo nie dalem rady znalezc admina");
                    driver.switchTo().defaultContent();
                }
            }
        });
        Znajdz_Admina.setFont(new Font("Tahoma", Font.PLAIN, 11));

        nazwisko = new JTextField();
        nazwisko.setHorizontalAlignment(SwingConstants.LEFT);
        nazwisko.setBounds(122, 212, 100, 22);
        Umilator.add(nazwisko);
        nazwisko.setBackground(Color.WHITE);
        nazwisko.setText("");
        nazwisko.setEditable(false);
        nazwisko.setColumns(10);


        //dane wyjsciowe        
        Imie = new JTextField();
        Imie.setHorizontalAlignment(SwingConstants.LEFT);
        Imie.setBounds(12, 212, 100, 22);
        Umilator.add(Imie);
        Imie.setBackground(Color.WHITE);
        Imie.setText("");
        Imie.setEditable(false);
        Imie.setColumns(10);


        Alias  = new JTextField();
        Alias.setBounds(138, 94, 161, 36);
        Umilator.add(Alias);
        Alias.setFont(new Font("Tahoma", Font.PLAIN, 26));
        Alias.setToolTipText("");
        Alias.setColumns(10);



        JTextPane Tokenalias = new JTextPane();
        Tokenalias.setBounds(150, 56, 139, 35);
        Umilator.add(Tokenalias);
        Tokenalias.setEditable(false);
        Tokenalias.setFont(new Font("SimSun", Font.PLAIN, 24));
        Tokenalias.setBackground(new Color(132,188,218)); 
        Tokenalias.setText("Token/Alias");




        JCheckBox przejdz_do_klienta = new JCheckBox("Przejdz na klienta");
        przejdz_do_klienta.setFont(new Font("Tahoma", Font.PLAIN, 11));
        przejdz_do_klienta.setBackground(new Color(132,188,218));
        przejdz_do_klienta.setBounds(12, 68, 116, 23);
        Umilator.add(przejdz_do_klienta);


        JCheckBox spawdz_ostatnie_logowania = new JCheckBox("Ostatnio zalogowany");
        spawdz_ostatnie_logowania.setBackground(new Color(132,188,218));
        spawdz_ostatnie_logowania.setFont(new Font("Tahoma", Font.PLAIN, 11));
        spawdz_ostatnie_logowania.setBounds(12, 40, 132, 23);
        Umilator.add(spawdz_ostatnie_logowania);

        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Alias", "Token", "Email", "Bazowka", "Rachunek"}));
        comboBox.setBounds(314, 73, 128, 22);
        Umilator.add(comboBox);

        JButton Umil = new JButton("Wyszukaj");
        Umil.setBounds(138, 134, 161, 47);
        Umilator.add(Umil);
        Umil.setFont(new Font("Tahoma", Font.PLAIN, 25));
        Umil.addMouseListener(new MouseAdapter() {
            @Override
            //komunikacja z plikiem umilacz.java
            public void mouseClicked(MouseEvent e) {    
                String x = String.valueOf(comboBox.getSelectedItem());
                    if (x.equals("Alias")) {
                        Radio_Stan = 1;
                    }   

                    if (x.equals("Token")) {
                        Radio_Stan = 2;
                    }
                    if (x.equals("Bazowka")) {
                        Radio_Stan = 3;
                    }           

                    if (x.equals("Rachunek")) {
                        Radio_Stan = 4;
                    }       

                    if (x.equals("Email")) {
                        Radio_Stan = 5;
                    }



                    if(spawdz_ostatnie_logowania.isSelected()) {

                        sprawdzanko = true;


                    }
                    if(!spawdz_ostatnie_logowania.isSelected()) {

                        sprawdzanko = false;

                    }

                    if(przejdz_do_klienta.isSelected()) {

                        przejdz = true;

                    }

                    if(!przejdz_do_klienta.isSelected()) {


                        przejdz = false;


                    }
                    driver.switchTo().defaultContent(); 




                    try {

                        sraka = new Umilacz();  
                        String Dane = Alias.getText();                  
                        sraka.umilacz(driver,Dane,Radio_Stan,sprawdzanko,przejdz);
                        if(sraka.ErrCode !=null && !sraka.ErrCode.isEmpty()) {
                            txtpnError.setText(sraka.ErrCode);

                            //dane
                            Imie.setText(sraka.imie);
                            nazwisko.setText(sraka.nazwisko);
                            telefon.setText(sraka.telefon);
                            email.setText(sraka.mail);
                            Status.setText(sraka.status);
                            definicja.setText(sraka.element);
                    }} catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }


                }

            });
            Umil.setBackground(new Color(255, 255, 255));
            Umil.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            //tutaj


        JButton Starsuj = new JButton("Starsuj");
        Starsuj.setBackground(new Color(255, 255, 255));
        Starsuj.setForeground(Color.BLACK);
        Starsuj.addMouseListener(new MouseAdapter() {
            @Override
            //przekazywanie info do starsinatora
            public void mouseClicked(MouseEvent e) {                
                txtpnError.setText("");
                WebDriverWait wait = new WebDriverWait(driver, 11); 

                try {   
                    driver.switchTo().defaultContent(); 
                    wait.until(ExpectedConditions.elementToBeClickable(By.id("uifw-megamenu-108")));
                    driver.findElement(By.id("uifw-megamenu-108")).click();

                    wait.until(ExpectedConditions.elementToBeClickable(By.id("sitemap-108-9003-9014")));
                    driver.findElement(By.id("sitemap-108-9003-9014")).click();
                    driver.switchTo().frame("idashboard"); 

                    wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_Row1_AccountSelectionModel_Value_Number_FilterValue_dialog_link")));
                    driver.findElement(By.id("Criteria_Row1_AccountSelectionModel_Value_Number_FilterValue_dialog_link")).click();

                    driver.switchTo().frame("Criteria_Row1_AccountSelectionModel_Value_Number_FilterValue_dialog_link_iframe");
                    wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_toggleLeftText")));

                    driver.findElement(By.id("Criteria_toggleLeftText")).click();

                    wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria__toggleLeftText")));
                    driver.findElement(By.id("Criteria__toggleLeftText")).click();

                    wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_Advanced_BranchName_FilterValue")));
                    driver.findElement(By.id("Criteria_Advanced_BranchName_FilterValue")).sendKeys("WARSAW");


                    wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_go")));
                    driver.findElement(By.id("Criteria_go")).click();

                    TimeUnit.SECONDS.sleep(1);
                    wait.until(ExpectedConditions.elementToBeClickable(By.id("addSelectedRows")));
                    wait.until(ExpectedConditions.elementToBeClickable(By.id("jqgh_Results_BranchName")));


                    WebElement parent = driver.findElement(By.id("Results"));       

                    wait.until(ExpectedConditions.elementToBeClickable(parent.findElement(By.cssSelector("td[aria-describedby='Results_AccountNumber']"))));

                    String Konto_Stars = parent.findElement(By.cssSelector("td[aria-describedby='Results_AccountNumber']")).getText();
                    System.out.println(Konto_Stars);



                    driver.switchTo().defaultContent(); 
                    driver.switchTo().frame("idashboard"); 

                    wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByClassName("ui-dialog-buttonset").findElement(By.cssSelector("button[buttontype='OK']"))));
                    driver.findElementByClassName("ui-dialog-buttonset").findElement(By.cssSelector("button[buttontype='OK']")).click();

                    driver.switchTo().defaultContent(); 


                    wait.until(ExpectedConditions.elementToBeClickable(By.id("uifw-megamenu-101")));
                    driver.findElement(By.id("uifw-megamenu-101")).click();
                    txtpnError.setText("");


                    try {               


                        System.setProperty("file.encoding","UTF-8");
                        Field charset = Charset.class.getDeclaredField("defaultCharset");
                        charset.setAccessible(true);
                        charset.set(null,null);
                        String telefonbezstafki = sraka.telefon.replaceAll("\\s","");

                        String nowedane = sraka.imie.replaceAll("-"," ") + ";" + sraka.nazwisko.replaceAll("-"," ") +";"+ telefonbezstafki +";"+ sraka.mail +";"+ Konto_Stars;


                        File HUB = new File(".\\Resources\\HUB.txt");
                        PrintWriter zapis = new PrintWriter(".\\Resources\\HUB.txt");
                        zapis.println(nowedane);
                        zapis.close();


                    }
                    catch (Exception e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

                }


                catch( Exception vv ) {
                    System.out.println("nie udalo mi sie znalezc rachunku" );
                    txtpnError.setText("nie udalo mi sie znalezc rachunku");
                    driver.switchTo().defaultContent(); 
                }       




            }
        });
        Starsuj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        Starsuj.setBounds(337, 11, 105, 23);
        Umilator.add(Starsuj);

        Status = new JTextField();
        Status.setBounds(12, 182, 100, 22);
        Umilator.add(Status);
        Status.setBackground(Color.WHITE);
        Status.setText("");
        Status.setEditable(false);
        Status.setColumns(10);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(Apk1.class.getResource("/umilatorr/tlo.png")));
        lblNewLabel.setBounds(0, 0, 449, 243);
        Umilator.add(lblNewLabel);


        JPanel AML = new JPanel();

        JPanel Płatności = new JPanel();
        Płatności.setBackground(new Color(132,188,218));
        tabbedPane.addTab("P\u0142atno\u015Bci", null, Płatności, null);
        Płatności.setLayout(null);

        JTextPane textkwotra = new JTextPane();
        textkwotra.setBounds(56, 86, 50, 20);
        textkwotra.setEditable(false);
        textkwotra.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textkwotra.setBackground(new Color(132,188,218));
        textkwotra.setText("Kwota");
        Płatności.add(textkwotra);

        KwotaOd = new JTextField();
        KwotaOd.setBounds(12, 117, 67, 20);
        Płatności.add(KwotaOd);
        KwotaOd.setColumns(10);

        KwotaDo = new JTextField();
        KwotaDo.setBounds(89, 117, 67, 20);
        Płatności.add(KwotaDo);
        KwotaDo.setColumns(10);

        Nrref = new JTextField();
        Nrref.setBounds(12, 53, 119, 22);
        Płatności.add(Nrref);
        Nrref.setColumns(10);

        vdOD = new JTextField();
        vdOD.setBounds(141, 53, 67, 22);
        vdOD.setToolTipText("");
        Płatności.add(vdOD);
        vdOD.setColumns(10);

        vDo = new JTextField();
        vDo.setBounds(218, 53, 67, 22);
        vDo.setToolTipText("");
        vDo.setColumns(10);
        Płatności.add(vDo);

        cdOD = new JTextField();
        cdOD.setBounds(295, 53, 67, 22);
        cdOD.setColumns(10);
        Płatności.add(cdOD);

        cdDO = new JTextField();
        cdDO.setBounds(372, 53, 67, 22);
        cdDO.setColumns(10);
        Płatności.add(cdDO);

        Waluta = new JTextField();
        Waluta.setBounds(166, 116, 85, 22);
        Waluta.setToolTipText("");
        Waluta.setColumns(10);
        Płatności.add(Waluta);
        AML.setBackground(new Color(132,188,218));
        tabbedPane.addTab("AML/Global Entitlement", null, AML, null);
        AML.setLayout(null);

        JTextPane textWaluta = new JTextPane();
        textWaluta.setBounds(179, 86, 72, 20);
        textWaluta.setText("Waluta");
        textWaluta.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textWaluta.setEditable(false);
        textWaluta.setBackground(new Color(132,188,218));
        Płatności.add(textWaluta);

        JTextPane txtpnNrReferencyjny = new JTextPane();
        txtpnNrReferencyjny.setForeground(new Color(0, 0, 0));
        txtpnNrReferencyjny.setBounds(22, 23, 106, 20);
        txtpnNrReferencyjny.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtpnNrReferencyjny.setEditable(false);
        txtpnNrReferencyjny.setBackground(new Color(132,188,218));
        txtpnNrReferencyjny.setText("Nr referencyjny");
        Płatności.add(txtpnNrReferencyjny);

        JTextPane txtpnDataWaluty = new JTextPane();
        txtpnDataWaluty.setBounds(166, 20, 97, 22);
        txtpnDataWaluty.setFont(new Font("Tahoma", Font.PLAIN, 17));
        txtpnDataWaluty.setEditable(false);
        txtpnDataWaluty.setBackground(new Color(132,188,218));
        txtpnDataWaluty.setText("Data waluty");
        Płatności.add(txtpnDataWaluty);

        JTextPane txtpnDataUtworzenia = new JTextPane();
        txtpnDataUtworzenia.setBounds(304, 23, 135, 20);
        txtpnDataUtworzenia.setFont(new Font("Tahoma", Font.PLAIN, 17));
        txtpnDataUtworzenia.setEditable(false);
        txtpnDataUtworzenia.setBackground(new Color(132,188,218));
        txtpnDataUtworzenia.setText("Data utworzenia");
        Płatności.add(txtpnDataUtworzenia);

        JRadioButton ANALIZAPLATNOSCI = new JRadioButton("ANALIZA PLATNOSCI");
        ANALIZAPLATNOSCI.setBounds(12, 172, 135, 25);
        ANALIZAPLATNOSCI.setFont(new Font("Tahoma", Font.PLAIN, 10));
        buttonGroup_1.add(ANALIZAPLATNOSCI);

        ANALIZAPLATNOSCI.setBackground(new Color(132,188,218));
        Płatności.add(ANALIZAPLATNOSCI);

        JRadioButton ZAPYTANIEOTRANSAKCJE = new JRadioButton("Zap. o transakcje");
        ZAPYTANIEOTRANSAKCJE.setBounds(12, 200, 135, 23);
        ZAPYTANIEOTRANSAKCJE.setFont(new Font("Tahoma", Font.PLAIN, 12));
        buttonGroup_1.add(ZAPYTANIEOTRANSAKCJE);
        ZAPYTANIEOTRANSAKCJE.setBackground(new Color(132,188,218));
        Płatności.add(ZAPYTANIEOTRANSAKCJE);

        JRadioButton WSZYSTKIEPLATNOSCI = new JRadioButton("WSZYSTKIE PLATNOSCI");
        WSZYSTKIEPLATNOSCI.setBounds(12, 144, 140, 25);
        WSZYSTKIEPLATNOSCI.setFont(new Font("Tahoma", Font.PLAIN, 10));
        buttonGroup_1.add(WSZYSTKIEPLATNOSCI);
        WSZYSTKIEPLATNOSCI.setSelected(true);
        WSZYSTKIEPLATNOSCI.setBackground(new Color(132,188,218));
        Płatności.add(WSZYSTKIEPLATNOSCI);

        Format = new JTextField();
        Format.setBounds(330, 138, 86, 32);
        Format.setBackground(new Color(132,188,218));
        Format.setEditable(false);
        Format.setHorizontalAlignment(SwingConstants.LEFT);
        Format.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Format.setText("   Format\r\n");
        Płatności.add(Format);
        Format.setColumns(10);

        txtDataDdmmrrrr = new JTextField();
        txtDataDdmmrrrr.setBounds(330, 167, 86, 32);
        txtDataDdmmrrrr.setBackground(new Color(132,188,218));
        txtDataDdmmrrrr.setText("Data: DD/MM/RRRR");
        txtDataDdmmrrrr.setHorizontalAlignment(SwingConstants.LEFT);
        txtDataDdmmrrrr.setFont(new Font("Tahoma", Font.PLAIN, 13));
        txtDataDdmmrrrr.setEditable(false);
        txtDataDdmmrrrr.setColumns(10);
        Płatności.add(txtDataDdmmrrrr);

        txtKwota = new JTextField();
        txtKwota.setBounds(330, 197, 86, 32);
        txtKwota.setBackground(new Color(132,188,218));
        txtKwota.setText("KWOTA: 123,00");
        txtKwota.setHorizontalAlignment(SwingConstants.LEFT);
        txtKwota.setFont(new Font("Tahoma", Font.PLAIN, 10));
        txtKwota.setEditable(false);
        txtKwota.setColumns(10);
        Płatności.add(txtKwota);

        AML_IMIE = new JTextField();
        AML_IMIE.setColumns(10);
        AML_IMIE.setBackground(Color.WHITE);
        AML_IMIE.setBounds(100, 77, 116, 22);
        AML.add(AML_IMIE);
        AML_NAZWISKO = new JTextField();
        AML_NAZWISKO.setBounds(227, 77, 116, 22);
        AML.add(AML_NAZWISKO);
        AML_NAZWISKO.setColumns(10);

        JTextPane textAMLIMIE = new JTextPane();
        textAMLIMIE.setFont(new Font("SimSun", Font.PLAIN, 21));
        textAMLIMIE.setEditable(false);
        textAMLIMIE.setBackground(new Color(132,188,218));
        textAMLIMIE.setText("IMIE");
        textAMLIMIE.setBounds(136, 47, 51, 30);
        AML.add(textAMLIMIE);

        JTextPane txtpnNazwisko = new JTextPane();
        txtpnNazwisko.setFont(new Font("SimSun", Font.PLAIN, 21));
        txtpnNazwisko.setEditable(false);
        txtpnNazwisko.setBackground(new Color(132,188,218));
        txtpnNazwisko.setText("NAZWISKO");
        txtpnNazwisko.setBounds(238, 47, 105, 30);
        AML.add(txtpnNazwisko);

        JRadioButton ToolKit = new JRadioButton("ToolKit");
        ToolKit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        buttonGroup_2.add(ToolKit); 
        ToolKit.setSelected(true);
        ToolKit.setBackground(new Color(132,188,218));
        ToolKit.setBounds(100, 106, 65, 25);
        AML.add(ToolKit);

        JRadioButton Raport_AML = new JRadioButton("Raport");
        buttonGroup_2.add(Raport_AML);
        Raport_AML.setBackground(new Color(132,188,218));
        Raport_AML.setBounds(167, 106, 63, 25);
        AML.add(Raport_AML);
        tabbedPane.setBackgroundAt(2, new Color(255, 255, 255));

        JButton znajdzplatnosc = new JButton("ZNAJDZ PLATNOSC");
        znajdzplatnosc.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        znajdzplatnosc.setBackground(new Color(255, 255, 255));
        znajdzplatnosc.setBounds(153, 148, 167, 72);
        znajdzplatnosc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                WebDriverWait wait = new WebDriverWait(driver, 25);


                if(WSZYSTKIEPLATNOSCI.isSelected()) {

                    System.out.println("WSZYSTKIEPLATNOSCI");
                    driver.switchTo().defaultContent(); 

                    try {
                        driver.switchTo().defaultContent(); 
                        wait.until(ExpectedConditions.elementToBeClickable(By.id("uifw-megamenu-103")));
                        driver.findElement(By.id("uifw-megamenu-103")).click();

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("sitemap-103-5101-5111")));
                        driver.findElement(By.id("sitemap-103-5101-5111")).click();
                        driver.switchTo().frame("idashboard"); 

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("OuterPanel_backToSearch")));
                        driver.findElement(By.id("OuterPanel_backToSearch")).click();

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("OuterPanel_clear")));
                        driver.findElement(By.id("OuterPanel_clear")).click();




                        String nr_ref = Nrref.getText();
                        if(nr_ref !=null && !nr_ref.isEmpty()) {
                            wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_Basic_PaymentsWorklistBasicSearchCriteriaRow1_TransactionReferenceNumber_FilterValue")));        
                            driver.findElement(By.id("Criteria_Basic_PaymentsWorklistBasicSearchCriteriaRow1_TransactionReferenceNumber_FilterValue")).sendKeys(nr_ref);
                        }                               
                        String vdod = vdOD.getText();   

                        if(vdod !=null && !vdod.isEmpty()) {
                            wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_Basic_PaymentsWorklistBasicSearchCriteriaRow1_ValueDateFrom")));
                            driver.findElement(By.id("Criteria_Basic_PaymentsWorklistBasicSearchCriteriaRow1_ValueDateFrom")).sendKeys(vdod);
                        }                   
                        String vddo = vDo.getText();    

                        if(vddo !=null && !vddo.isEmpty()) {
                            wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_Basic_PaymentsWorklistBasicSearchCriteriaRow1_ValueDateTo")));
                            driver.findElement(By.id("Criteria_Basic_PaymentsWorklistBasicSearchCriteriaRow1_ValueDateTo")).sendKeys(vddo);     
                        }

                        String cdod = cdOD.getText();   

                        if(cdod !=null && !cdod.isEmpty()) {
                            wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_Basic_PaymentsWorklistBasicSearchCriteriaRow1_CreationDateFrom")));
                            driver.findElement(By.id("Criteria_Basic_PaymentsWorklistBasicSearchCriteriaRow1_CreationDateFrom")).sendKeys(cdod);        
                        }

                        String cddo = cdDO.getText();   

                        if(cddo !=null && !cddo.isEmpty()) {
                            wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_Basic_PaymentsWorklistBasicSearchCriteriaRow1_CreationDateTo")));
                            driver.findElement(By.id("Criteria_Basic_PaymentsWorklistBasicSearchCriteriaRow1_CreationDateTo")).sendKeys(cddo);      
                        }

                        String kwotaOD = KwotaOd.getText();

                        if(kwotaOD !=null && !kwotaOD.isEmpty()) {
                            wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_Basic_PaymentsWorklistBasicSearchCriteriaRow3_PaymentAmountFrom")));
                            driver.findElement(By.id("Criteria_Basic_PaymentsWorklistBasicSearchCriteriaRow3_PaymentAmountFrom")).sendKeys(kwotaOD);        
                        }

                        String kwotaDO = KwotaDo.getText();

                        if(kwotaDO !=null && !kwotaDO.isEmpty()) {
                            wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_Basic_PaymentsWorklistBasicSearchCriteriaRow3_PaymentAmountTo")));
                            driver.findElement(By.id("Criteria_Basic_PaymentsWorklistBasicSearchCriteriaRow3_PaymentAmountTo")).sendKeys(kwotaDO);      
                        }

                        String WALUTA = Waluta.getText().toUpperCase();                 

                        if(WALUTA !=null && !WALUTA.isEmpty()){ 


                            wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_Basic_PaymentsWorklistBasicSearchCriteriaRow2_PaymentCurrency")));
                            driver.findElement(By.id("Criteria_Basic_PaymentsWorklistBasicSearchCriteriaRow2_PaymentCurrency")).sendKeys(WALUTA);   


                        }

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("OuterPanel_go")));
                        driver.findElement(By.id("OuterPanel_go")).click();

                        driver.switchTo().defaultContent(); 
                        txtpnError.setText("");


                    }           

                    catch(Exception b) {
                        driver.switchTo().defaultContent(); 
                        System.out.println("nie znalazłem platnosci");      

                    }
                }




                if(ANALIZAPLATNOSCI.isSelected()) {

                    System.out.println("ANALIZAPLATNOSCI");

                    try {
                        driver.switchTo().defaultContent(); 

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("uifw-megamenu-103")));
                        driver.findElement(By.id("uifw-megamenu-103")).click();

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("sitemap-103-5150-5151")));
                        driver.findElement(By.id("sitemap-103-5150-5151")).click();

                        driver.switchTo().frame("idashboard"); 


                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[1]/div/app-paymentoverview-dashboard/div[2]/div[2]/div/div/omni-cfw-search-panel/div/omni-cfw-accordion/uib-accordion/div/ng-transclude/omni-cfw-accordion-group/div/div[2]/div/ng-transclude/form/div/div[2]/span[2]")));
                        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/app-paymentoverview-dashboard/div[2]/div[2]/div/div/omni-cfw-search-panel/div/omni-cfw-accordion/uib-accordion/div/ng-transclude/omni-cfw-accordion-group/div/div[2]/div/ng-transclude/form/div/div[2]/span[2]")).click();


                        String nr_ref = Nrref.getText();
                        if(nr_ref !=null && !nr_ref.isEmpty()) {


                            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[1]/div/app-paymentoverview-dashboard/div[2]/div[2]/div/div/omni-cfw-search-panel/div/omni-cfw-accordion/uib-accordion/div/ng-transclude/omni-cfw-accordion-group/div/div[2]/div/ng-transclude/form/div/div[1]/div[2]/div/omni-cfw-dropdown/div/div/div/input")));                                                                                                                        
                            driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/app-paymentoverview-dashboard/div[2]/div[2]/div/div/omni-cfw-search-panel/div/omni-cfw-accordion/uib-accordion/div/ng-transclude/omni-cfw-accordion-group/div/div[2]/div/ng-transclude/form/div/div[1]/div[2]/div/omni-cfw-dropdown/div/div/div/input")).click(); 

                            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TranRefSelection\"]/div/ul/omni-cfw-option[2]/li/a")));
                            driver.findElement(By.xpath("//*[@id=\"TranRefSelection\"]/div/ul/omni-cfw-option[2]/li/a")).click();   


                            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[1]/div/app-paymentoverview-dashboard/div[2]/div[2]/div/div/omni-cfw-search-panel/div/omni-cfw-accordion/uib-accordion/div/ng-transclude/omni-cfw-accordion-group/div/div[2]/div/ng-transclude/form/div/div[1]/div[3]/div/div/div/omni-cfw-textbox/div/input")));     
                            driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/app-paymentoverview-dashboard/div[2]/div[2]/div/div/omni-cfw-search-panel/div/omni-cfw-accordion/uib-accordion/div/ng-transclude/omni-cfw-accordion-group/div/div[2]/div/ng-transclude/form/div/div[1]/div[3]/div/div/div/omni-cfw-textbox/div/input")).sendKeys(nr_ref);
                        }                               

                        String vdod = vdOD.getText();   


                        if(vdod !=null && !vdod.isEmpty()) {
                            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[1]/div/app-paymentoverview-dashboard/div[2]/div[2]/div/div/omni-cfw-search-panel/div/omni-cfw-accordion/uib-accordion/div/ng-transclude/omni-cfw-accordion-group/div/div[2]/div/ng-transclude/form/div/div[1]/div[1]/div/div/div[1]/omni-cfw-datepicker/p/input")));

                            driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/app-paymentoverview-dashboard/div[2]/div[2]/div/div/omni-cfw-search-panel/div/omni-cfw-accordion/uib-accordion/div/ng-transclude/omni-cfw-accordion-group/div/div[2]/div/ng-transclude/form/div/div[1]/div[1]/div/div/div[1]/omni-cfw-datepicker/p/input")).clear();
                            driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/app-paymentoverview-dashboard/div[2]/div[2]/div/div/omni-cfw-search-panel/div/omni-cfw-accordion/uib-accordion/div/ng-transclude/omni-cfw-accordion-group/div/div[2]/div/ng-transclude/form/div/div[1]/div[1]/div/div/div[1]/omni-cfw-datepicker/p/input")).sendKeys(vdod);
                        }                                                                           
                        String vddo = vDo.getText();    
                        if(vddo !=null && !vddo.isEmpty()) {
                            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[1]/div/app-paymentoverview-dashboard/div[2]/div[2]/div/div/omni-cfw-search-panel/div/omni-cfw-accordion/uib-accordion/div/ng-transclude/omni-cfw-accordion-group/div/div[2]/div/ng-transclude/form/div/div[1]/div[1]/div/div/div[2]/omni-cfw-datepicker/p/input")));

                            driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/app-paymentoverview-dashboard/div[2]/div[2]/div/div/omni-cfw-search-panel/div/omni-cfw-accordion/uib-accordion/div/ng-transclude/omni-cfw-accordion-group/div/div[2]/div/ng-transclude/form/div/div[1]/div[1]/div/div/div[2]/omni-cfw-datepicker/p/input")).clear();
                            driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/app-paymentoverview-dashboard/div[2]/div[2]/div/div/omni-cfw-search-panel/div/omni-cfw-accordion/uib-accordion/div/ng-transclude/omni-cfw-accordion-group/div/div[2]/div/ng-transclude/form/div/div[1]/div[1]/div/div/div[2]/omni-cfw-datepicker/p/input")).sendKeys(vddo);       

                        }

                        String kwotunia = KwotaOd.getText() + KwotaDo.getText();
                        String kwota = KwotaOd.getText()+"-"+ KwotaDo.getText();
                        if(kwotunia !=null && !kwotunia.isEmpty()) {

                            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[1]/div/app-paymentoverview-dashboard/div[2]/div[2]/div/div/omni-cfw-search-panel/div/omni-cfw-accordion/uib-accordion/div/ng-transclude/omni-cfw-accordion-group/div/div[2]/div/ng-transclude/form/div/div[3]/div[3]/div/div/omni-cfw-fx-menu/div/span")));
                            driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/app-paymentoverview-dashboard/div[2]/div[2]/div/div/omni-cfw-search-panel/div/omni-cfw-accordion/uib-accordion/div/ng-transclude/omni-cfw-accordion-group/div/div[2]/div/ng-transclude/form/div/div[3]/div[3]/div/div/omni-cfw-fx-menu/div/span")).click();

                            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[1]/div/app-paymentoverview-dashboard/div[2]/div[2]/div/div/omni-cfw-search-panel/div/omni-cfw-accordion/uib-accordion/div/ng-transclude/omni-cfw-accordion-group/div/div[2]/div/ng-transclude/form/div/div[3]/div[3]/div/div/omni-cfw-fx-menu/div/ul/li[4]")));
                            driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/app-paymentoverview-dashboard/div[2]/div[2]/div/div/omni-cfw-search-panel/div/omni-cfw-accordion/uib-accordion/div/ng-transclude/omni-cfw-accordion-group/div/div[2]/div/ng-transclude/form/div/div[3]/div[3]/div/div/omni-cfw-fx-menu/div/ul/li[4]")).click();

                            wait.until(ExpectedConditions.elementToBeClickable(By.id("Amount")));
                            driver.findElement(By.id("Amount")).sendKeys(kwota);        

                        }

                        String WALUTA = Waluta.getText().toUpperCase();                 

                        if(WALUTA !=null && !WALUTA.isEmpty()){ 

                            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[1]/div/app-paymentoverview-dashboard/div[2]/div[2]/div/div/omni-cfw-search-panel/div/omni-cfw-accordion/uib-accordion/div/ng-transclude/omni-cfw-accordion-group/div/div[2]/div/ng-transclude/form/div/div[3]/div[4]/div/div/div[1]/div/div/div/omni-cfw-textbox/div/input")));
                            driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/app-paymentoverview-dashboard/div[2]/div[2]/div/div/omni-cfw-search-panel/div/omni-cfw-accordion/uib-accordion/div/ng-transclude/omni-cfw-accordion-group/div/div[2]/div/ng-transclude/form/div/div[3]/div[4]/div/div/div[1]/div/div/div/omni-cfw-textbox/div/input")).sendKeys(WALUTA);

                        }


                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[1]/div/app-paymentoverview-dashboard/div[2]/div[2]/div/div/omni-cfw-search-panel/div/omni-cfw-accordion/uib-accordion/div/ng-transclude/omni-cfw-accordion-group/div/div[2]/div/ng-transclude/form/div/div[4]/omni-cfw-action-button[1]/button")));
                        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/app-paymentoverview-dashboard/div[2]/div[2]/div/div/omni-cfw-search-panel/div/omni-cfw-accordion/uib-accordion/div/ng-transclude/omni-cfw-accordion-group/div/div[2]/div/ng-transclude/form/div/div[4]/omni-cfw-action-button[1]/button")).click();

                        txtpnError.setText("");
                        driver.switchTo().defaultContent(); 
                    }

                    catch(Exception b) {
                        System.out.println(b);  
                        System.out.println("nie znalazłem platnosci :c");       
                        driver.switchTo().defaultContent(); 
                    }


                }

                if(ZAPYTANIEOTRANSAKCJE.isSelected()) {

                    System.out.println("ZAPYTANIEOTRANSAKCJE");


                    try {

                        driver.switchTo().defaultContent(); 
                        wait.until(ExpectedConditions.elementToBeClickable(By.id("uifw-megamenu-108")));
                        driver.findElement(By.id("uifw-megamenu-108")).click();

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("sitemap-108-9085-9094")));
                        driver.findElement(By.id("sitemap-108-9085-9094")).click();

                        driver.switchTo().frame("idashboard"); 


                        String nrRef = Nrref.getText();

                        if(nrRef !=null && !nrRef.isEmpty()) {


                            wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_Row1_TransactionIDMT100")));
                            driver.findElement(By.id("Criteria_Row1_TransactionIDMT100")).sendKeys(nrRef);

                        }

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("BottomSave")));
                        driver.findElement(By.id("BottomSave")).click();
                        TimeUnit.SECONDS.sleep(2);

                        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("load_Results")));

                        Boolean isPresent = driver.findElements(By.id("Results_emptyrecords")).size() > 0;

                        if(isPresent)
                        {
                            //  C002930001   13620C0YO4J
                            System.out.println(driver.findElement(By.id("Results_emptyrecords")).getText());
                            System.out.println(isPresent);
                            System.out.println("nie ma tu");
                            wait.until(ExpectedConditions.elementToBeClickable(By.id("textSpan_RtntoTransactionInquiry")));
                            driver.findElement(By.id("textSpan_RtntoTransactionInquiry")).click();


                            wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_Row1_SourceSystem")));
                            driver.findElement(By.xpath("//*[@id=\"Criteria_Row1_SourceSystem\"]/option[4]")).click();

                            wait.until(ExpectedConditions.elementToBeClickable(By.id("BottomSave")));
                            driver.findElement(By.id("BottomSave")).click();
                        }

                        driver.switchTo().defaultContent(); 
                    }


                    catch(Exception b) {
                        System.out.println(b);  
                        System.out.println("nie znalazłem platnosci :c");       
                        driver.switchTo().defaultContent(); 

                    }
                }

            }
        });
        Płatności.add(znajdzplatnosc);

        JRadioButton GlobalEntitlement = new JRadioButton("Global Entitlement");
        buttonGroup_2.add(GlobalEntitlement);
        GlobalEntitlement.setBackground(new Color(132,188,218));
        GlobalEntitlement.setBounds(238, 107, 164, 23);
        AML.add(GlobalEntitlement);
        frmUmilator.setBounds(100, 100, 470, 310);
        frmUmilator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton SZUKAJAML = new JButton("SZUKAJ");
        SZUKAJAML.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
        SZUKAJAML.setBackground(new Color(255, 255, 255));
        SZUKAJAML.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                WebDriverWait wait = new WebDriverWait(driver, 30);
                if(ToolKit.isSelected())                    
                {
                    driver.switchTo().defaultContent();         

                    System.out.println("toolkit");
                    try {   
                        txtpnError.setText("");

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("uifw-megamenu-109")));
                        driver.findElement(By.id("uifw-megamenu-109")).click();

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("sitemap-109-301-11003")));
                        driver.findElement(By.id("sitemap-109-301-11003")).click();

                        driver.switchTo().frame("idashboard"); 

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("ui-id-9")));
                        driver.findElement(By.id("ui-id-9")).click();

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("ui-id-11")));
                        driver.findElement(By.id("ui-id-11")).click();

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("ACP055M")));
                        driver.findElement(By.id("ACP055M")).click();       

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_toggleLeftText")));
                        driver.findElement(By.id("Criteria_toggleLeftText")).click();   

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_Criteria_FirstName_FilterValue")));
                        String imie = AML_IMIE.getText();   
                        driver.findElement(By.id("Criteria_Criteria_FirstName_FilterValue")).sendKeys(imie);

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_Criteria_LastName_FilterValue")));
                        String nazwisko = AML_NAZWISKO.getText();   
                        driver.findElement(By.id("Criteria_Criteria_LastName_FilterValue")).sendKeys(nazwisko); 

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_go")));
                        driver.findElement(By.id("Criteria_go")).click();
                        driver.switchTo().defaultContent();         
                        txtpnError.setText("");

                    }
                    catch(Exception x) {

                        txtpnError.setText("nie wyszło mi :c");
                        driver.switchTo().defaultContent();         

                    }

                }

                if(Raport_AML.isSelected()){
                    driver.switchTo().defaultContent();         

                    System.out.println("raport");
                    try {   
                        txtpnError.setText("");

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("uifw-megamenu-107")));
                        driver.findElement(By.id("uifw-megamenu-107")).click();

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("sitemap-107-5673-5603")));
                        driver.findElement(By.id("sitemap-107-5673-5603")).click();

                        driver.switchTo().frame("idashboard"); 


                        TimeUnit.SECONDS.sleep(4);  

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("GenerateReportsResults_gi_ReportName_AMLStatusRpt")));
                        driver.findElement(By.id("GenerateReportsResults_gi_ReportName_AMLStatusRpt")).click();

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("TopPanel_ByUser_dialog_link")));
                        driver.findElement(By.id("TopPanel_ByUser_dialog_link")).click();

                        driver.switchTo().frame("TopPanel_ByUser_dialog_link_iframe"); 

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_toggleLeftText")));
                        driver.findElement(By.id("Criteria_toggleLeftText")).click();

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria__toggleLeftText")));
                        driver.findElement(By.id("Criteria__toggleLeftText")).click();

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_Advanced_FirstName_FilterValue")));
                        String imie = AML_IMIE.getText();   
                        driver.findElement(By.id("Criteria_Advanced_FirstName_FilterValue")).sendKeys(imie);

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_Advanced_LastName_FilterValue")));
                        String nazwisko = AML_NAZWISKO.getText();   
                        driver.findElement(By.id("Criteria_Advanced_LastName_FilterValue")).sendKeys(nazwisko); 

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_go")));
                        driver.findElement(By.id("Criteria_go")).click();

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("cb_Results")));
                        driver.findElement(By.id("cb_Results")).click();

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("addSelectedRows")));
                        driver.findElement(By.id("addSelectedRows")).click();

                        System.out.println("vhuj");

                        driver.switchTo().defaultContent();     
                        driver.switchTo().frame("idashboard");
                        driver.findElementByClassName("ui-dialog-buttonset").findElement(By.cssSelector("button[buttontype='OK']")).click();

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("TopPanel_Branch_dialog_link")));
                        driver.findElement(By.id("TopPanel_Branch_dialog_link")).click();

                        driver.switchTo().frame("TopPanel_Branch_dialog_link_iframe"); 

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("cb_Results")));
                        driver.findElement(By.id("cb_Results")).click();

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("addSelectedRows")));
                        driver.findElement(By.id("addSelectedRows")).click();

                        driver.switchTo().defaultContent();     
                        driver.switchTo().frame("idashboard");

                        wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByClassName("ui-dialog-buttonset").findElement(By.cssSelector("button[buttontype='OK']"))));
                        driver.findElementByClassName("ui-dialog-buttonset").findElement(By.cssSelector("button[buttontype='OK']")).click();
                        wait.until(ExpectedConditions.elementToBeClickable(By.id("RunCriteria")));
                        driver.findElement(By.id("RunCriteria")).click();
                        TimeUnit.SECONDS.sleep(20); 
                        List<WebElement> txt = driver.findElement(By.xpath("//*[@id=\"AvailableReportsResults\"]/tbody")).findElements(By.cssSelector("tr"));
                        System.out.println(txt.size());
                        String scieszka;
                        scieszka = "/html/body/div[3]/div[2]/form/div[2]/div[2]/div[1]/div[2]/div[1]/div/div/div/div[3]/div[4]/div/table/tbody/tr["+txt.size()+"]/td[11]/a";
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(scieszka)));
                        driver.findElement(By.xpath(scieszka)).click();


                        wait.until(ExpectedConditions.elementToBeClickable(By.id("ConfirmOk")));
                        driver.findElement(By.id("ConfirmOk")).click();
                        driver.switchTo().defaultContent(); 
                        txtpnError.setText("");

                    }
                    catch(Exception x) {
                        System.out.println(x);
                        txtpnError.setText("nie wyszło mi :c");
                        driver.switchTo().defaultContent(); 
                    }   

                }

                if(GlobalEntitlement.isSelected()) {
                    driver.switchTo().defaultContent();         
                    System.out.println("GlobalEntitlement");
                    try {   
                        txtpnError.setText("");

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("uifw-megamenu-107")));
                        driver.findElement(By.id("uifw-megamenu-107")).click();

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("sitemap-107-5673-5603")));
                        driver.findElement(By.id("sitemap-107-5673-5603")).click();

                        driver.switchTo().frame("idashboard"); 

                        TimeUnit.SECONDS.sleep(2);  
                        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("load_Results")));

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_backToSearch")));
                        driver.findElement(By.id("Criteria_backToSearch")).click();

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_Row1_BaseReportName_dialog_link")));
                        driver.findElement(By.id("Criteria_Row1_BaseReportName_dialog_link")).click();
                        driver.switchTo().frame("Criteria_Row1_BaseReportName_dialog_link_iframe"); 

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_BaseReportName_FilterValue")));
                        driver.findElement(By.id("Criteria_BaseReportName_FilterValue")).sendKeys("Global Entitlement Report");

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_go")));
                        driver.findElement(By.id("Criteria_go")).click();
                        TimeUnit.SECONDS.sleep(3);  

                        //TODO
                        WebElement chuja = driver.findElement(By.xpath("/html/body/div[2]/div/form/div[2]/div[2]/div[1]/div/div/div/div[3]/div[4]/div/table/tbody/tr[2]/td[1]/a"));

                        chuja.click();

                        driver.switchTo().defaultContent(); 
                        driver.switchTo().frame("idashboard");

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_go")));
                        driver.findElement(By.id("Criteria_go")).click();

                        wait.until(ExpectedConditions.elementToBeClickable(By.id("GenerateReportsResults_gi_ReportName_GlobalAuditRpt")));
                        driver.findElement(By.id("GenerateReportsResults_gi_ReportName_GlobalAuditRpt")).click();

                        String imie = AML_IMIE.getText();   
                        String nazwisko = AML_NAZWISKO.getText();   

                        if(imie !=null && !imie.isEmpty() && nazwisko !=null && !nazwisko.isEmpty()) {
                            wait.until(ExpectedConditions.elementToBeClickable(By.id("TopPanel_UserName_dialog_link")));
                            driver.findElement(By.id("TopPanel_UserName_dialog_link")).click();


                            driver.switchTo().frame("TopPanel_UserName_dialog_link_iframe"); 


                            wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_toggleLeftText")));
                            driver.findElement(By.id("Criteria_toggleLeftText")).click();

                            wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria__toggleLeftText")));
                            driver.findElement(By.id("Criteria__toggleLeftText")).click();



                            wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_Advanced_FirstName_FilterValue")));

                            driver.findElement(By.id("Criteria_Advanced_FirstName_FilterValue")).sendKeys(imie);

                            wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_Advanced_LastName_FilterValue")));


                            driver.findElement(By.id("Criteria_Advanced_LastName_FilterValue")).sendKeys(nazwisko); 

                            wait.until(ExpectedConditions.elementToBeClickable(By.id("Criteria_go")));
                            driver.findElement(By.id("Criteria_go")).click();


                            wait.until(ExpectedConditions.elementToBeClickable(By.id("cb_Results")));
                            driver.findElement(By.id("cb_Results")).click();

                            wait.until(ExpectedConditions.elementToBeClickable(By.id("addSelectedRows")));
                            driver.findElement(By.id("addSelectedRows")).click();

                            driver.switchTo().defaultContent();     
                            driver.switchTo().frame("idashboard");

                            wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByClassName("ui-dialog-buttonset").findElement(By.cssSelector("button[buttontype='OK']"))));
                            driver.findElementByClassName("ui-dialog-buttonset").findElement(By.cssSelector("button[buttontype='OK']")).click();
                        }


                        wait.until(ExpectedConditions.elementToBeClickable(By.id("RunCriteria")));
                        driver.findElement(By.id("RunCriteria")).click();

                        TimeUnit.SECONDS.sleep(20); 

                        List<WebElement> txt = driver.findElement(By.xpath("//*[@id=\"AvailableReportsResults\"]/tbody")).findElements(By.cssSelector("tr"));

                        System.out.println(txt.size());


                        String scieszka;
                        scieszka = "/html/body/div[3]/div[2]/form/div[2]/div[2]/div[1]/div[2]/div[1]/div/div/div/div[3]/div[4]/div/table/tbody/tr["+txt.size()+"]/td[11]/a";


                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(scieszka)));
                        driver.findElement(By.xpath(scieszka)).click();


                        wait.until(ExpectedConditions.elementToBeClickable(By.id("ConfirmOk")));
                        driver.findElement(By.id("ConfirmOk")).click();
                        driver.switchTo().defaultContent(); 


                        txtpnError.setText("");

                        driver.switchTo().defaultContent(); 

                    }



                    catch(Exception x) {
                        System.out.println(x);
                        txtpnError.setText("nie wyszło mi :c");
                        driver.switchTo().defaultContent(); 

                    }   


                }   


            }
        });
        SZUKAJAML.setBounds(136, 138, 180, 80);
        AML.add(SZUKAJAML);
    }
}