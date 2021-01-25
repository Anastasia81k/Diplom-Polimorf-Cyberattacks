package sample;

import javafx.concurrent.Task;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static sample.FuzzyAttack.startFuzzify;
import static sample.HashAttack.createMap;
/*
public class Monitoring{
    public List<Attack> listAttacks(String excelFilePath) throws IOException {
        List<Attack> list = new ArrayList<Attack>();
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();

        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            Attack attack = new Attack();

            while (cellIterator.hasNext()) {
                Cell nextCell = cellIterator.next();
                int columnIndex = nextCell.getColumnIndex();

                switch (columnIndex) {
                    case 0:
                        attack.setDuration_1((Double) getCellValue(nextCell));
                        break;
                    case 1:
                        attack.setSrc_bytes_2((Double) getCellValue(nextCell));
                        break;
                    case 2:
                        attack.setDst_bytes_3((Double) getCellValue(nextCell));
                        break;
                    case 3:
                        attack.setLand_4((Double) getCellValue(nextCell));
                        break;
                    case 4:
                        attack.setWrong_fragment_5((Double) getCellValue(nextCell));
                        break;
                    case 5:
                        attack.setUrgent_6((Double) getCellValue(nextCell));
                        break;
                    case 6:
                        attack.setHot_7((Double) getCellValue(nextCell));
                        break;
                    case 7:
                        attack.setNum_failed_logins_8((Double) getCellValue(nextCell));
                        break;
                    case 8:
                        attack.setLogged_in_9((Double) getCellValue(nextCell));
                        break;
                    case 9:
                        attack.setNum_compromised_10((Double) getCellValue(nextCell));
                        break;
                    case 10:
                        attack.setRoot_shell_11((Double) getCellValue(nextCell));
                        break;
                    case 11:
                        attack.setSu_attempted_12((Double) getCellValue(nextCell));
                        break;
                    case 12:
                        attack.setNum_root_13((Double) getCellValue(nextCell));
                        break;
                    case 13:
                        attack.setNum_file_creations_14((Double) getCellValue(nextCell));
                        break;
                    case 14:
                        attack.setNum_shells_15((Double) getCellValue(nextCell));
                        break;
                    case 15:
                        attack.setNum_access_files_16((Double) getCellValue(nextCell));
                        break;
                    case 16:
                        attack.setNum_outbound_cmds_17((Double) getCellValue(nextCell));
                        break;
                    case 17:
                        attack.setIs_host_login_18((Double) getCellValue(nextCell));
                        break;
                    case 18:
                        attack.setIs_guest_login_19((Double) getCellValue(nextCell));
                        break;
                    case 19:
                        attack.setCount_20((Double) getCellValue(nextCell));
                        break;
                    case 20:
                        attack.setSrv_count_21((Double) getCellValue(nextCell));
                        break;
                    case 21:
                        attack.setSerror_rate_22((Double) getCellValue(nextCell));
                        break;
                    case 22:
                        attack.setSrv_serror_rate_23((Double) getCellValue(nextCell));
                        break;
                    case 23:
                        attack.setRerror_rate_24((Double) getCellValue(nextCell));
                        break;
                    case 24:
                        attack.setSrv_rerror_rate_25((Double) getCellValue(nextCell));
                        break;
                    case 25:
                        attack.setSame_srv_rate_26((Double) getCellValue(nextCell));
                        break;
                    case 26:
                        attack.setDiff_srv_rate_27((Double) getCellValue(nextCell));
                        break;
                    case 27:
                        attack.setSrv_diff_host_rate_28((Double) getCellValue(nextCell));
                        break;
                    case 28:
                        attack.setDst_host_count_29((Double) getCellValue(nextCell));
                        break;
                    case 29:
                        attack.setDst_host_srv_count_30((Double) getCellValue(nextCell));
                        break;
                    case 30:
                        attack.setDst_host_same_srv_rate_31((Double) getCellValue(nextCell));
                        break;
                    case 31:
                        attack.setDst_host_diff_srv_rate_32((Double) getCellValue(nextCell));
                        break;
                    case 32:
                        attack.setDst_host_same_src_port_rate_33((Double) getCellValue(nextCell));
                        break;
                    case 33:
                        attack.setDst_host_srv_diff_host_rate_34((Double) getCellValue(nextCell));
                        break;
                    case 34:
                        attack.setDst_host_serror_rate_35((Double) getCellValue(nextCell));
                        break;
                    case 35:
                        attack.setDst_host_srv_serror_rate_36((Double) getCellValue(nextCell));
                        break;
                    case 36:
                        attack.setDst_host_rerror_rate_37((Double) getCellValue(nextCell));
                        break;
                    case 37:
                        attack.setDst_host_srv_rerror_rate_38((Double) getCellValue(nextCell));
                        break;
                }
            }
            list.add(attack);
        }
        workbook.close();
        inputStream.close();

        return list;
    }

    private Object getCellValue(Cell cell) {
        Double nullCell = (Double)null;
        if (cell == null) {
            return null;
        }
        switch (cell.getCellType()) {
            case BLANK:
                return (Double)nullCell;
            case STRING:
                return cell.getStringCellValue();
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case NUMERIC:
                return cell.getNumericCellValue();
            case ERROR:
                return cell.getErrorCellValue();

        }
        return null;

    }
}
*/


public class Monitoring extends Task<List<Attack>>{

    @Override
    protected List<Attack> call() throws Exception {
        List<Attack> list = new ArrayList<Attack>();
        String excelFilePath = "Vector.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        int countProgr = excelFilePath.length();
        int i =0;

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            Attack attack = new Attack();
            while (cellIterator.hasNext()) {
                Cell nextCell = cellIterator.next();
                int columnIndex = nextCell.getColumnIndex();
                switch (columnIndex) {
                    case 0:
                        attack.setDuration_1((Double) getCellValue(nextCell));
                        break;
                    case 1:
                        attack.setSrc_bytes_2((Double) getCellValue(nextCell));
                        break;
                    case 2:
                        attack.setDst_bytes_3((Double) getCellValue(nextCell));
                        break;
                    case 3:
                        attack.setLand_4((Double) getCellValue(nextCell));
                        break;
                    case 4:
                        attack.setWrong_fragment_5((Double) getCellValue(nextCell));
                        break;
                    case 5:
                        attack.setUrgent_6((Double) getCellValue(nextCell));
                        break;
                    case 6:
                        attack.setHot_7((Double) getCellValue(nextCell));
                        break;
                    case 7:
                        attack.setNum_failed_logins_8((Double) getCellValue(nextCell));
                        break;
                    case 8:
                        attack.setLogged_in_9((Double) getCellValue(nextCell));
                        break;
                    case 9:
                        attack.setNum_compromised_10((Double) getCellValue(nextCell));
                        break;
                    case 10:
                        attack.setRoot_shell_11((Double) getCellValue(nextCell));
                        break;
                    case 11:
                        attack.setSu_attempted_12((Double) getCellValue(nextCell));
                        break;
                    case 12:
                        attack.setNum_root_13((Double) getCellValue(nextCell));
                        break;
                    case 13:
                        attack.setNum_file_creations_14((Double) getCellValue(nextCell));
                        break;
                    case 14:
                        attack.setNum_shells_15((Double) getCellValue(nextCell));
                        break;
                    case 15:
                        attack.setNum_access_files_16((Double) getCellValue(nextCell));
                        break;
                    case 16:
                        attack.setNum_outbound_cmds_17((Double) getCellValue(nextCell));
                        break;
                    case 17:
                        attack.setIs_host_login_18((Double) getCellValue(nextCell));
                        break;
                    case 18:
                        attack.setIs_guest_login_19((Double) getCellValue(nextCell));
                        break;
                    case 19:
                        attack.setCount_20((Double) getCellValue(nextCell));
                        break;
                    case 20:
                        attack.setSrv_count_21((Double) getCellValue(nextCell));
                        break;
                    case 21:
                        attack.setSerror_rate_22((Double) getCellValue(nextCell));
                        break;
                    case 22:
                        attack.setSrv_serror_rate_23((Double) getCellValue(nextCell));
                        break;
                    case 23:
                        attack.setRerror_rate_24((Double) getCellValue(nextCell));
                        break;
                    case 24:
                        attack.setSrv_rerror_rate_25((Double) getCellValue(nextCell));
                        break;
                    case 25:
                        attack.setSame_srv_rate_26((Double) getCellValue(nextCell));
                        break;
                    case 26:
                        attack.setDiff_srv_rate_27((Double) getCellValue(nextCell));
                        break;
                    case 27:
                        attack.setSrv_diff_host_rate_28((Double) getCellValue(nextCell));
                        break;
                    case 28:
                        attack.setDst_host_count_29((Double) getCellValue(nextCell));
                        break;
                    case 29:
                        attack.setDst_host_srv_count_30((Double) getCellValue(nextCell));
                        break;
                    case 30:
                        attack.setDst_host_same_srv_rate_31((Double) getCellValue(nextCell));
                        break;
                    case 31:
                        attack.setDst_host_diff_srv_rate_32((Double) getCellValue(nextCell));
                        break;
                    case 32:
                        attack.setDst_host_same_src_port_rate_33((Double) getCellValue(nextCell));
                        break;
                    case 33:
                        attack.setDst_host_srv_diff_host_rate_34((Double) getCellValue(nextCell));
                        break;
                    case 34:
                        attack.setDst_host_serror_rate_35((Double) getCellValue(nextCell));
                        break;
                    case 35:
                        attack.setDst_host_srv_serror_rate_36((Double) getCellValue(nextCell));
                        break;
                    case 36:
                        attack.setDst_host_rerror_rate_37((Double) getCellValue(nextCell));
                        break;
                    case 37:
                        attack.setDst_host_srv_rerror_rate_38((Double) getCellValue(nextCell));
                        break;
                }
            }
            this.listAttacks(attack);
            list.add(attack);
            i++;
            this.updateProgress(i, countProgr);

        }
        workbook.close();
        inputStream.close();

        return list;
    }

    private void listAttacks(Attack list) throws Exception{
        this.updateMessage("Monitoring " + list.toString());
        Thread.sleep(500);
    }

    private Object getCellValue(Cell cell) {
        Double nullCell = (Double)null;
        if (cell == null) {
            return null;
        }
        switch (cell.getCellType()) {
            case BLANK:
                return (Double)nullCell;
            case STRING:
                return cell.getStringCellValue();
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case NUMERIC:
                return cell.getNumericCellValue();
            case ERROR:
                return cell.getErrorCellValue();
        }
        return null;
    }
}

