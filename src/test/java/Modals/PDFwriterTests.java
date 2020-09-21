package Modals;
import Model.PDFWriter_interface;
import Model.PDFWriter;
import com.itextpdf.text.DocumentException;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PDFwriterTests {
    private String message,header;

    @Test
    public void PDFWriterTest() throws IOException, DocumentException {
        header = "test";
        message = "hello test";
        String expect = "PAID\n"+header+"\n"+message;

        PDFWriter_interface pdfWriter = new PDFWriter();
        pdfWriter.doWrite(header, message,"test");

        assertEquals(expect,pdfWriter.doRead("test"));
    }
    @Test
    public void PDFWriterNullHeaderTest() throws IOException, DocumentException {
        header = null;
        message = "hello test";
        String expect = "PAID\n"+"null"+"\n"+"null";

        PDFWriter_interface pdfWriter = new PDFWriter();
        pdfWriter.doWrite(header, message,"test");

        assertEquals(expect,pdfWriter.doRead("test"));
    }
    @Test
    public void PDFWriterNullMessageTest() throws IOException, DocumentException {
        header = "Test";
        message = null;
        String expect = "PAID\n"+"null"+"\n"+"null";

        PDFWriter_interface pdfWriter = new PDFWriter();
        pdfWriter.doWrite(header, message,"test");

        assertEquals(expect,pdfWriter.doRead("test"));
    }
    @Test
    public void PDFWriterNullFilenameTest() throws IOException, DocumentException {
        header = "test";
        message = "hello test";
        String expect = "PAID\n"+header+"\n"+message;

        PDFWriter_interface pdfWriter = new PDFWriter();
        pdfWriter.doWrite(header, message,null);

        assertEquals(expect,pdfWriter.doRead(null));
    }
    @Test
    public void PDFWriterNullHeaderAndMessageTest() throws IOException, DocumentException {
        header = null;
        message = null;
        String expect = "PAID\n"+"null"+"\n"+"null";

        PDFWriter_interface pdfWriter = new PDFWriter();
        pdfWriter.doWrite(header, message,"test");

        assertEquals(expect,pdfWriter.doRead("test"));
    }
    @Test
    public void PDFWriterNullValuesTest() throws IOException, DocumentException {
        header = null;
        message = null;
        String expect = "PAID\n"+"null"+"\n"+"null";

        PDFWriter_interface pdfWriter = new PDFWriter();
        pdfWriter.doWrite(header, message,null);

        assertEquals(expect,pdfWriter.doRead(null));
    }
}
