import java.io.*;
import org.apache.poi.ss.usermodel.*;
import java.text.*;
 
public class XLSXReader {
    static DecimalFormat df = new DecimalFormat("#####0");
 
    public static void main(String[] args) {
        FileWriter fostream;
        PrintWriter out = null;
        String strOutputPath = "C:\\work\\workspace\\TestExcelXml\\";
        String strFilePrefix = "newXmlFile";
 
        try {
            Workbook wb = WorkbookFactory.create(new File("C:\\work\\workspace\\TestExcelXml\\КонищеваМария13107.xlsx"));
            Sheet sheet = wb.getSheet("OSContractorAutoCompareAct");
 
            fostream = new FileWriter(strOutputPath + "\\" + strFilePrefix+ ".xml");
            out = new PrintWriter(new BufferedWriter(fostream));
 
            out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            out.println("<COMPARE-ACT-DETAILS>");
 
            boolean firstRow = true;
            boolean secondRow = true;
            String compareActId = "";
            for (Row row : sheet) {
                if (firstRow) {
                    firstRow = false;
                    continue;
                }
                out.println("<DETAIL>");
                if (secondRow) {
                                out.println(formatElement("COMPARE_ACT_ID", formatCell(row.getCell(13))));
                                compareActId = formatCell(row.getCell(13));
                                secondRow = false;
                }
                else {
                                out.println(formatElement("COMPARE_ACT_ID", compareActId));
                }
                out.println(formatElement("COMPARE_ACT_DETAIL_ID", formatCell(row.getCell(12))));
                out.println(formatElement("CONTRACT_NUMBER", formatCell(row.getCell(1))));
                out.println(formatElement("MERCH_CODE", formatCell(row.getCell(3))));
                out.println(formatElement("BIND_CONSTR_NAME", formatCell(row.getCell(6)).replace("&", "&amp;")));
                out.println(formatElement("AWARD_SUM", formatCell(row.getCell(9))));
                out.println(formatElement("BASE_SUM", formatCell(row.getCell(11))));
                out.println("</DETAIL>");
            }
            out.write("</COMPARE-ACT-DETAILS>");
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    private static String formatCell(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch(cell.getCellType()) {
            case BLANK:
                return "";
            case BOOLEAN:
                return Boolean.toString(cell.getBooleanCellValue());
            case ERROR:
                return "*error*";
            case NUMERIC:
                return XLSXReader.df.format(cell.getNumericCellValue());
            case STRING:
                return cell.getStringCellValue();
            default:
                return "<unknown value>";
        }
    }
 
    private static String formatElement(String tag, String value) {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(tag);
        if (value != null && value.length() > 0) {
            sb.append(">");
            sb.append(value);
            sb.append("</");
            sb.append(tag);
            sb.append(">");
        } else {
            sb.append("/>");
        }
        return sb.toString();
    }
}
