/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Picture;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author usuario
 */
@ManagedBean (name = "reportesControl")
@SessionScoped
public class ReportesControl {
   private final ReportesDAO rdao;
   public StreamedContent file;
   public ReportesControl() {
      rdao = new ReportesDAO();
   }
   
   public void init() {
   }

    public StreamedContent getFile() {
        return file;
    }

    public void setFile(StreamedContent file) {
        this.file = file;
    }
    
    
    public StreamedContent generaExcelReporte(String consulta,String tituloReporte,String nombreReporte, String noUsuario)
  {
      ResultSet cConsulta;
      int columna = 0;
      int fila = 5;
      ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
      String path = context.getRealPath("/");
      String Plantilla = path+"//resources//reportes//REPORTE_BITVE.xls";
      String ruta = path+"//resources//reportes//reportesModulo//" + nombreReporte + ".xls";
      String imagePath = path + "//resources//img//SEP.png";
      System.out.println("Ruta:"+ruta);
      try {

          POIFSFileSystem FS = new POIFSFileSystem(new FileInputStream(Plantilla));
          HSSFWorkbook WB = new HSSFWorkbook(FS);
          HSSFCellStyle style = WB.createCellStyle();
          HSSFCellStyle style2 = WB.createCellStyle();
          HSSFSheet Sheet = WB.getSheet("Hoja1");
          final FileInputStream stream = new FileInputStream(imagePath);
          final CreationHelper helper = WB.getCreationHelper();
          final Drawing drawing = Sheet.createDrawingPatriarch();
          final ClientAnchor anchor = helper.createClientAnchor();
          anchor.setAnchorType(ClientAnchor.AnchorType.MOVE_AND_RESIZE);
          final int pictureIndex = WB.addPicture(IOUtils.toByteArray(stream), WB.PICTURE_TYPE_PNG);
          anchor.setCol1(0);
          anchor.setRow1(0);
          anchor.setRow2(0);
          anchor.setCol2(0);
          final Picture pict = drawing.createPicture(anchor, pictureIndex);
          double pors = 1.5;
          pict.resize(pors, 3);
          HSSFRow loFila = Sheet.getRow(fila - 2);
          if (loFila == null) {
              loFila = Sheet.createRow(fila - 2);
          }
          HSSFCell loCell = loFila.getCell((short) 0);
          if (loCell == null) {
              loCell = loFila.createCell((short) 0);
          }
          style2.setAlignment(HorizontalAlignment.CENTER);
          loCell.setCellStyle(style2);
          loCell.setCellValue(tituloReporte);

          loFila = Sheet.getRow(fila - 1);
          if (loFila == null) {
              loFila = Sheet.createRow(fila - 1);
          }
          loCell = loFila.getCell((short) 0);
          if (loCell == null) {
              loFila.createCell((short) 0);
          }
          loCell.setCellStyle(style2);
          loCell.setCellValue("USUARIO: " + noUsuario);
          cConsulta = rdao.getConsulta(consulta);
          ResultSetMetaData MetaData = cConsulta.getMetaData();

          loFila = Sheet.getRow(fila);
          if (loFila == null) {
              loFila = Sheet.createRow(fila);
          }
          for (columna = 0; columna < MetaData.getColumnCount(); columna++) {
              HSSFCell celda = loFila.getCell((short) columna);
              if (celda == null) {
                  celda = loFila.createCell((short) columna);
              }
              style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.GREY_25_PERCENT.getIndex());
              style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
              celda.setCellValue(MetaData.getColumnName(columna + 1));
              celda.setCellStyle(style);
          }

          fila++;

          while (cConsulta.next()) {
              loFila = Sheet.getRow(fila);
              if (loFila == null) {
                  loFila = Sheet.createRow(fila);
              }

              for (columna = 0; columna < MetaData.getColumnCount(); columna++) {
                  HSSFCell celda = loFila.getCell((short) columna);
                  if (celda == null) {
                      celda = loFila.createCell((short) columna);
                  }
                  if (MetaData.getColumnTypeName(columna + 1).toUpperCase().equals("DATE")) {
                      if (cConsulta.getDate(columna + 1) != null) {
                          celda.setCellValue(cConsulta.getDate(columna + 1));
                      } else {
                          celda.setCellValue("");
                      }
                  } else if ((MetaData.getColumnTypeName(columna + 1).toUpperCase().equals("INTEGER"))
                          || (MetaData.getColumnTypeName(columna + 1).toUpperCase().equals("NUMBER"))
                          || (MetaData.getColumnTypeName(columna + 1).toUpperCase().equals("DECIMAL"))) {
                      if (cConsulta.getString(columna + 1) != null) {
                          celda.setCellValue(cConsulta.getDouble(columna + 1));
                      }
                  } else {
                      celda.setCellValue(cConsulta.getString(columna + 1));
                  }
              }
              fila++;
          }
          cConsulta.close();
          FileOutputStream fos = null;
          String rutaArchivoNuevo = ruta;
          File archivoNuevo = new File(rutaArchivoNuevo);
          if (archivoNuevo.exists()) {
              archivoNuevo.delete();
          } else {
              archivoNuevo.createNewFile();
          }
          fos = new FileOutputStream(archivoNuevo);
          BufferedOutputStream bos = new BufferedOutputStream(fos);
          WB.write(bos);
          bos.flush();

          String nombreArchivo = archivoNuevo.getName();
          String tipoContenido = "application/vnd.ms-excel";
          InputStream inputS = new FileInputStream(rutaArchivoNuevo);
          file = new DefaultStreamedContent(inputS, tipoContenido, nombreArchivo);
          System.out.println("Descarga correcta");
      } catch (Exception ex) {
          System.out.println("\n Se ha producido un error \n" + ex.getMessage());
      }
      rdao.cerrarConexion();
      return file;
  }
    
}
