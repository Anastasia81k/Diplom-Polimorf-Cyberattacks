package sample;


import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import org.apache.log4j.spi.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.logging.*;

public class FuzzyAttack {
    public static int countDOS =0;
    public static int countR2L =0;
    public static int countPROBE =0;
    public static int countNORMAL =0;
    public static int countU2R =0;

    private static final Logger logger= Logger.getLogger(FuzzyAttack.class.getName());
    // public Logger logger;


    public static double startFuzzify(Map<String, Double> map) { ///результат от одной атаки!!!
     /*  File f = new File("logFile/result.txt");
        if(!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        FileHandler fh = null;
        try {
            fh = new FileHandler("logFile/result.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.addHandler(fh);*/
       // SimpleFormatter formatter = new SimpleFormatter();
       // fh.setFormatter(formatter);
        double threat = 0.0;
        String result = "";
        String filename = "attackFuzzy.fcl";
        //String filename = "attackFuzzyPolimorf.fcl";
        FIS fis = FIS.load(filename, true);
        if (fis == null) {
            System.out.println("Can't load file: '" + filename + "'");
            System.exit(1);
            return 0.0;
        }
        FunctionBlock fb = fis.getFunctionBlock(null);

        for (Map.Entry<String, Double> entry : map.entrySet()) {
            String keyAttack = entry.getKey();
            Double value = (Double) entry.getValue();
           // System.out.println("Attack  - " + keyAttack + " value - " + value);
            fb.setVariable(keyAttack, value);




            fb.evaluate();
            threat = fb.getVariable("threat").getLatestDefuzzifiedValue();
           // count(threat);

           if (threat >= 0.5 && threat <= 1.5) {
                countDOS++;
                result = ("Threat : " + threat + " is DOS attack " + countDOS );
               // logger.info(new LoggedInMessage());
                //LocalDateTime dt = LocalDateTime.now();
                //logger.info("TEST");
                System.out.println(result);
            } else if (threat >= 1.5 && threat <= 2.5) {
                countR2L++;
                result = ("Threat : " + threat + " is R2L attack" + countR2L);
                System.out.println(result);
            } else if (threat >= 3.5 && threat <= 4.5) {
                countPROBE++;
                result = ("Threat : " + threat + " is PROBE attack " + countPROBE);
                System.out.println(result);
            } else if (threat >= 4.5 && threat <= 5.5) {
                countNORMAL++;
                result = ("Threat : " + threat + " is NORMAL attack " + countNORMAL);
                System.out.println(result);
            } else if (threat >= 5.5 && threat <= 6.0) {
                countU2R++;
                result = ("Threat : " + threat + " is U2R attack " + countU2R);
                System.out.println(result);
            }

        }
        //System.out.println("Total result of monitoring: " + countDOS + " - count DOS attacks " +  countR2L + " - count R2L " + countPROBE + " - count PROBE " + countNORMAL + " - count Normal " + countU2R + "  - count R2L");
        return threat;

    }



    /*public List<Double> execute(Map<String, Double> map, int step, int stepsize){
        String filename = "attackFuzzy.fcl";
        FIS fis = FIS.load(filename, true);
        if(fis == null){
            System.out.println("Can't load file: '" + filename + "'");
            System.exit(1);

        }
        FunctionBlock fb = fis.getFunctionBlock(null);
        List<Result> result = new ArrayList<Result>();
    }*/
}
