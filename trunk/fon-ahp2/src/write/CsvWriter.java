/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package write;

import data.ACStorage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import model.Goal;
import org.omg.CORBA.portable.OutputStream;
import java.io.PrintWriter;

/**
 *
 * @author Ivan
 */
public class CsvWriter {

    public static void writeIntoCsv(String filepath) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filepath)));
        PrintWriter pw = new PrintWriter(bw);

        pw.print("Goal" + "\n");
        pw.print("name");
        pw.print(',');
        pw.print("description" + "\n");

        pw.print(ACStorage.getInstance().getGoal().getName() + "," + ACStorage.getInstance().getGoal().getDescription());
        pw.print("\n");
        pw.print("\n");
        pw.print("\n");


        pw.print("Alternatives");
        pw.print("\n");
        pw.print("\n");

        for (int i = 0; i < ACStorage.getInstance().getGoal().getListAlternative().size(); i++) {

            pw.print(ACStorage.getInstance().getGoal().getListAlternative().get(i).getName());
            pw.print(",");
            pw.print(ACStorage.getInstance().getGoal().getListAlternative().get(i).getDescription());
            pw.print("\n");

        }


        pw.print("\n");
        pw.print("\n");

        pw.print("Criterias");
        pw.print("\n");
        pw.print("\n");

        for (int i = 0; i < ACStorage.getInstance().getGoal().getListCriteria().size(); i++) {

            pw.print(ACStorage.getInstance().getGoal().getListCriteria().get(i).getName());
            pw.print(",");
            pw.print(ACStorage.getInstance().getGoal().getListCriteria().get(i).getDescription());
            pw.print("\n");

        }
        pw.print("\n");
        pw.print("\n");


        for (int x = 0; x < ACStorage.getInstance().getGoal().getListCriteria().size(); x++) {

            pw.print("\n");
            pw.print("\n");
            pw.print("Alternative marks");
            pw.print("\n");
            pw.print("\n");

            pw.print(ACStorage.getInstance().getGoal().getListCriteria().get(x).getName());

            pw.print(",");
            for (int i = 0; i < ACStorage.getInstance().getGoal().getListAlternative().size(); i++) {

                pw.print(ACStorage.getInstance().getGoal().getListAlternative().get(i).getName());
                pw.print(",");
            }


            pw.print("\n");
            for (int i = 0; i < ACStorage.getInstance().getGoal().getListAlternative().size(); i++) {

                pw.print(ACStorage.getInstance().getGoal().getListAlternative().get(i).getName());
                pw.print(",");
                for (int j = 0; j < ACStorage.getInstance().getGoal().getListAlternative().size(); j++) {
                    pw.print(ACStorage.getInstance().getGoal().getListCriteria().get(x).getAlternativeRankInList(ACStorage.getInstance().getGoal().getListAlternative().get(j), ACStorage.getInstance().getGoal().getListAlternative().get(i)).getMark());
                    pw.print(",");


                }
                pw.print("\n");
            }


            pw.print("\n");
            pw.print("\n");

            pw.print("Alternative normalized marks");
            pw.print("\n");
            pw.print("\n");

            pw.print(ACStorage.getInstance().getGoal().getListCriteria().get(x).getName());

            pw.print(",");
            for (int i = 0; i < ACStorage.getInstance().getGoal().getListAlternative().size(); i++) {
                pw.print(ACStorage.getInstance().getGoal().getListAlternative().get(i).getName());
                pw.print(",");
            }
            pw.print("\n");
            for (int i = 0; i < ACStorage.getInstance().getGoal().getListAlternative().size(); i++) {
                pw.print(ACStorage.getInstance().getGoal().getListAlternative().get(i).getName());
                pw.print(",");
                for (int j = 0; j < ACStorage.getInstance().getGoal().getListAlternative().size(); j++) {
                    pw.print(ACStorage.getInstance().getGoal().getListCriteria().get(x).getAlternativeRankInList(ACStorage.getInstance().getGoal().getListAlternative().get(j), ACStorage.getInstance().getGoal().getListAlternative().get(i)).getNormalizedMark());
                    pw.print(",");


                }
                pw.print("\n");
            }


            pw.print("\n");
            pw.print("\n");



        }

        pw.print("Criteria marks");
        pw.print("\n");
        pw.print("\n");

        pw.print("Criterias");
        pw.print(",");
        for (int i = 0; i < ACStorage.getInstance().getGoal().getListCriteria().size(); i++) {
            pw.print(ACStorage.getInstance().getGoal().getListCriteria().get(i).getName());
            pw.print(",");
        }

        pw.print("\n");
        for (int i = 0; i < ACStorage.getInstance().getGoal().getListCriteria().size(); i++) {
            pw.print(ACStorage.getInstance().getGoal().getListCriteria().get(i).getName());
            pw.print(",");
            for (int j = 0; j < ACStorage.getInstance().getGoal().getListCriteria().size(); j++) {
                pw.print(ACStorage.getInstance().getGoal().getCriteriaWeightInList(ACStorage.getInstance().getGoal().getListCriteria().get(j), ACStorage.getInstance().getGoal().getListCriteria().get(i)).getMark());
                pw.print(",");
            }
            pw.print("\n");
        }
        pw.print("\n");
        pw.print("\n");

        pw.print("Criteria normalized marks");
        pw.print("\n");
        pw.print("\n");

        pw.print("Criterias");
        pw.print(",");
        for (int i = 0; i < ACStorage.getInstance().getGoal().getListCriteria().size(); i++) {
            pw.print(ACStorage.getInstance().getGoal().getListCriteria().get(i).getName());
            pw.print(",");
        }

        pw.print("\n");
        for (int i = 0; i < ACStorage.getInstance().getGoal().getListCriteria().size(); i++) {
            pw.print(ACStorage.getInstance().getGoal().getListCriteria().get(i).getName());
            pw.print(",");
            for (int j = 0; j < ACStorage.getInstance().getGoal().getListCriteria().size(); j++) {
                pw.print(ACStorage.getInstance().getGoal().getCriteriaWeightInList(ACStorage.getInstance().getGoal().getListCriteria().get(j), ACStorage.getInstance().getGoal().getListCriteria().get(i)).getNormalizedMark());
                pw.print(",");
            }
            pw.print("\n");
        }
        pw.print("\n");
        pw.print("\n");

        pw.flush();
        pw.close();
    }
}
