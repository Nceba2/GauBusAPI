package Model;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import java.io.FileOutputStream;
import java.io.IOException;

public class PDFWriter implements PDFWriter_interface {

    @Override
    public void doWrite(String header, String Message, String newFile) throws IOException, DocumentException{
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("src/main/PDFtickets/"+newFile+".pdf"));
//        Image img = Image.getInstance("src/main/webapp/Lib/img/logo-white.png");

        Font font;
        Font font1;
        Font font2;

        Chunk chunk;
        Chunk chunk1;
        Chunk chunk2;

        document.open();

        try{
            font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.RED);
            font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.BLACK);
            font2 = FontFactory.getFont(FontFactory.COURIER, 8, BaseColor.BLACK);

            chunk = new Chunk("PAID", font);
            chunk1 = new Chunk(header, font1);
            chunk2 = new Chunk(Message, font2);

            document.addTitle("Statement");
            document.addAuthor("Made by Giant");

//            document.add(img);
            document.add(new Paragraph(chunk));
            document.add(new Paragraph(chunk1));
            document.add(new Paragraph(chunk2));
        }catch (Exception e){
            font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.RED);
            font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.BLACK);
            font2 = FontFactory.getFont(FontFactory.COURIER, 8, BaseColor.BLACK);

            chunk = new Chunk("PAID", font);
            chunk1 = new Chunk("null", font1);
            chunk2 = new Chunk("null", font2);

            document.add(new Paragraph(chunk));
            document.add(new Paragraph(chunk1));
            document.add(new Paragraph(chunk2));
        }

        document.setHtmlStyleClass("body{background: red;}");
        document.close();

    }

    @Override
    public String doRead(String filename) throws IOException {
        PdfReader reader = new PdfReader("src/main/PDFtickets/"+filename+".pdf");
        try {
            return String.valueOf(PdfTextExtractor.getTextFromPage(reader, 1));
        }catch (Exception e){
            return null;
        }
    }
}
