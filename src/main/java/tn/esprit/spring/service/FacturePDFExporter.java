package tn.esprit.spring.service;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import tn.esprit.spring.DAO.model.Facture;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.Font;
import java.io.IOException;
import java.util.List;
// Auther: AZZABI HAMZA fonctinalite avance utilisation de la fonction facturePDFExporter dans facture REST controller
public class FacturePDFExporter {
    private List<Facture> factures;

    public FacturePDFExporter(List<Facture> factures) {
        this.factures = factures;
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.LIGHT_GRAY);
        cell.setPadding(5);

        Font font = new Font(FontFactory.HELVETICA, 8, Font.BOLD);

        cell.setPhrase(new Phrase("Facture ID" ));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Date" ));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Client" ));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Total" ));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Etat" ));
        table.addCell(cell);

    }

    private void writeTableData(PdfPTable table) {
        for(Facture facture : factures) {
            table.addCell(String.valueOf(facture.getIdFacture()));
            table.addCell(String.valueOf(facture.getDateFacture()));
            table.addCell(String.valueOf(facture.getClient().getNom()));
            table.addCell(String.valueOf(facture.getMontantFacture()));
            table.addCell(String.valueOf(facture.isActive()));
        }
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        com.lowagie.text.Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("List of Users", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();
    }
}
