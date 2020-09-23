package Services;

import com.itextpdf.text.DocumentException;
import java.io.IOException;

public interface PDFWriter_interface {

    void  doWrite(String header, String Message,String newFile) throws IOException, DocumentException;

    String doRead(String filename) throws IOException;

}
