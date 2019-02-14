package de.minol.gatways.rest.spring.boot.pdf;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.ui.jasperreports.JasperReportsUtils;

import de.minol.gatways.rest.spring.boot.model.FormBlatt;
import de.minol.gatways.rest.spring.boot.pdf.model.IspisBlatt;
import de.minol.gatways.rest.spring.boot.pdf.model.IspisBlattLtdnr;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@Component
public class ReportFactoryImpl implements ReportFactory {

	@Override
	public byte[] printReport(FormBlatt blatt) {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		//InputStreamResource

		IspisBlatt ispis = new IspisBlatt(blatt);
		List<IspisBlattLtdnr> listaLtdnr = ispis.getIspisLtdnr();
		
       try {

		            JasperReport jasperReport = ( JasperReport )JRLoader.loadObject(
	                this.getClass().getClassLoader().getResourceAsStream(  "report.jasper"  ) );
		            Map<String, Object> map = new HashMap<String, Object>();
		             map.put( "blatt", ispis );
		             map.put( "ltdnr", listaLtdnr );
		          //  map.put( "customsOffice", customsOffice );

	            JasperReportsUtils.renderAsPdf( jasperReport, map, new JREmptyDataSource(), stream );

		        }
		        catch( JRException e ) {
		            throw new RuntimeException( e );

		        }
		        return stream.toByteArray();

		    }

}
