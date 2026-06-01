package com.rsnvtech.erp.edu.pdf;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.rsnvtech.erp.edu.model.StudentModel;

import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class PdfGeneratorStudentService {
    public ByteArrayInputStream generateStudentPdf(StudentModel student) {
        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            // Document Title
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20);
            Paragraph title = new Paragraph("Student Profile Report", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(20);
            document.add(title);

            // Create a table with 2 columns
            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);

            // Styling variables
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);
            Font dataFont = FontFactory.getFont(FontFactory.HELVETICA, 12);

            // Add Details to Table
            addTableRow(table, "Student ID:", String.valueOf(student.getStudentId()), headerFont, dataFont);
            addTableRow(table, "Full Name:", student.getStudentName(), headerFont, dataFont);
            addTableRow(table, "Email Address:", student.getEmail(), headerFont, dataFont);
            addTableRow(table, "Enrolled Course:", student.getMobileNumber(), headerFont, dataFont);

            document.add(table);
            document.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

    private void addTableRow(PdfPTable table, String header, String value, Font headFont, Font dataFont) {
        PdfPCell cellHeader = new PdfPCell(new Phrase(header, headFont));
        cellHeader.setPadding(10);
        cellHeader.setBorderWidth(1);

        PdfPCell cellValue = new PdfPCell(new Phrase(value, dataFont));
        cellValue.setPadding(10);
        cellValue.setBorderWidth(1);

        table.addCell(cellHeader);
        table.addCell(cellValue);
    }
}
