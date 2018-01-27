
package application;

import java.io.File;
import java.io.FileNotFoundException;
import iText.*;


import com.itextpdf.io.IOException;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.io.image.ImageType;
import com.itextpdf.io.image.*;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.xobject.PdfImageXObject;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.print.PageLayout;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class ExportPDF
{
	public final String title = "Using's Chernikova Algorithm by Przemyslaw Budzich";
	final int titleSize = 14;



	public EventHandler<ActionEvent> exportToPdfEventHandler = new EventHandler<ActionEvent>()
	{


		@Override
		public void handle(ActionEvent event)
		{

			try
			{
				PdfWriter pdfWriter = new PdfWriter("fileprzemek.pdf");
				PdfDocument pdf = new PdfDocument(pdfWriter);
				Document document = new Document(pdf, PageSize.A4.rotate());
				document.setMargins(20, 20, 20, 20);
				PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA);

				PrinterJob job = PrinterJob.createPrinterJob();
				 if(job != null){
				   job.showPrintDialog(MainWindowController.aptStage); // Window must be your main Stage
				   job.endJob();
				 }

				 Printer print = null;
				 job.setPrinter(print);


				Paragraph p1 = new Paragraph(title)
						.setFont(font)
			            .setFontSize(14);
				document.add(p1);
				document.close();
			} catch (java.io.IOException e)
			{
				e.printStackTrace();
			}


		}
	};

	public void exportToPDF()
	{
		try
		{
			FileChooser fc = new FileChooser();
			FileChooser.ExtensionFilter ext1 = new FileChooser.ExtensionFilter("PDF file (*.pdf)", "*.pdf");
			fc.getExtensionFilters().add(ext1);
			File file = fc.showSaveDialog(null);
			PdfWriter pdfWriter = new PdfWriter(file);
			PdfDocument pdf = new PdfDocument(pdfWriter);
			Document document = new Document(pdf, PageSize.A4.rotate());
			document.setMargins(20, 20, 20, 20);
			PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA);





			Paragraph p1 = new Paragraph(title)
					.setFont(font)
		            .setFontSize(14);
			document.add(p1);




			document.close();
		} catch (java.io.IOException e)
		{
			e.printStackTrace();
		}
	}
}
