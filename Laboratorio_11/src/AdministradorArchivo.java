import java.io.FileInputStream;

public class AdministradorArchivo {

    public AdministradorArchivo(){
        FileInputStream fileStream = new FileInputStream(sourceFile);
        HSSFWorkbook workBook = new HSSFWorkbook(fileStream);
        HSSFSheet sheet = workBook.getSheetAt(0);
        HSSFRow row = sheet.getRow(0);
        HSSFCell cell = row.getCell(0);
        System.out.println(cell.toString());
    }
}
