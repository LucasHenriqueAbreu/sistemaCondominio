package br.edu.utfpr.pb.aulaswing.report;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class GerarRelatorio {


    public JasperViewer gerarRelatorio(
            JRBeanCollectionDataSource jDbs,
            Map<String,Object> parametros,
            InputStream arquivo) throws JRException{
    
        JasperReport report = (JasperReport) 
                JRLoader.loadObject(arquivo);
        JasperPrint impressao = 
                JasperFillManager.fillReport(report, 
                        parametros,jDbs);
        JasperViewer viewer = 
                new JasperViewer(impressao, false);
        viewer.setDefaultCloseOperation(
                JasperViewer.DO_NOTHING_ON_CLOSE);
        viewer.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
        return viewer;
    }
    
    public JasperViewer gerarRelatorio(
            Connection conn,
            Map<String,Object> parametros,
            InputStream arquivo) throws JRException{
    
        JasperReport report = (JasperReport) 
                JRLoader.loadObject(arquivo);
        JasperPrint impressao = 
                JasperFillManager.fillReport(report, 
                        parametros,conn);
        JasperViewer viewer = 
                new JasperViewer(impressao, false);
        viewer.setDefaultCloseOperation(
                JasperViewer.DO_NOTHING_ON_CLOSE);
        viewer.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
        return viewer;
    }
    
    
    
    
    
}
