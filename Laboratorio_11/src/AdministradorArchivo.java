import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class AdministradorArchivo {

    private static final String FILE_NAME = "datos.xlsx";
    private Supermercado supermercado;

    //Atributos de Producto
    private String nombre = null;
    private float precioSinImpuesto;
    private float porcentajeImpuesto;
    private String tipoDeVenta = "";

    public AdministradorArchivo(Supermercado supermercado) { this.supermercado = supermercado; }

    public void readXSLFile(){
        try {
            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            //Skip headers
            iterator.next();

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();

                Iterator<Cell> cellIterator = currentRow.iterator();

                while (cellIterator.hasNext()) {

                    Cell currentCell = cellIterator.next();
                    int cellIndex = currentCell.getColumnIndex();

                    switch (cellIndex){
                        case 0:
                            nombre = currentCell.getStringCellValue();
                            break;
                        case 1:
                            precioSinImpuesto = (float)currentCell.getNumericCellValue();
                            break;
                        case 2:
                            porcentajeImpuesto = (float)currentCell.getNumericCellValue();
                            break;
                        case 3:
                            tipoDeVenta = currentCell.getStringCellValue();
                            if(tipoDeVenta == "UNIDAD"){
                                supermercado.agregarProductoInventarioVentaUnitaria(nombre, precioSinImpuesto, porcentajeImpuesto);
                            }
                            else{
                                supermercado.agregarProductoInventarioVentaPorPeso(nombre, precioSinImpuesto, porcentajeImpuesto);
                            }
                            break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}