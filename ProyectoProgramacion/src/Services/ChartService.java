package Services;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

/**
 * @author JD101
 *
 * Genera gráficos con la información obtenida al realizar ciertas consultas SQL
 */
public class ChartService {

    /**
     * Toma los parametros para darle estilo generico a un objeto de tipo
     * JFreeChart
     *
     * @param title Recibe un objeto de tipo TextTitle para darle formato al
     * tipo y tamaño de la fuente.
     * @param plot Recibe un objeto de tipo PiePlot para darle estilo a las
     * etiquetas y fondo que va a mostrar el objeto JFreeChart.
     */
    public static void setStyleDefault(TextTitle title, PiePlot plot) {

        //  Style to Title Chart
        title.setFont(new Font("Nirmala UI", Font.BOLD, 24));

        //  Customise the section label appearance
        plot.setLabelFont(new Font("Nirmala UI", Font.BOLD, 12));
        plot.setLabelBackgroundPaint(null);

    }

    /**
     * Hace una consulta a la base de datos para contar la cantidad por tipo de
     * estado de prueba, luego con la ayuda de un objeto de tipo
     * DefaultPieDataset rellena al gráfico con los datos obtenidos de la
     * consulta realizada, al final le da un estilo más específico al objeto
     * JFreeChart.
     *
     * @return Retorna un objeto de tipo JFreeChart relleno de datos y con un
     * estilo específico.
     * @throws SQLException Controla los errores de tipo SQL que se pudieran dar
     * por la consulta de información a la base de datos.
     */
    public static JFreeChart generateGraphDonutStatusPatients() throws SQLException {

        String query = "SELECT COUNT(teststatus_patient), teststatus_patient FROM patients GROUP BY teststatus_patient";

        DefaultPieDataset dts = new DefaultPieDataset();

        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.getConnectionDB();

        PreparedStatement ps;
        ResultSet rs;

        JFreeChart ch;

        try {

            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {

                dts.setValue(rs.getString(2), rs.getInt(1));

            }

            connectionDB.closeConnectionDB();

            ch = ChartFactory.createRingChart("Estado de Pruebas", dts, true, true, false);

            //  Style to Chart
            PiePlot plot = (PiePlot) ch.getPlot();
            plot.setBackgroundPaint(Color.white);
            // Style to chart sections
            plot.setSectionPaint("Negativo", new Color(3, 4, 94));
            plot.setSectionPaint("Pendiente", new Color(0, 119, 182));
            plot.setSectionPaint("Positivo", new Color(0, 180, 216));
            plot.setSectionPaint("Recuperado", new Color(144, 224, 239));
            //  Graph edge disabled
            plot.setOutlineVisible(false);

            setStyleDefault(ch.getTitle(), plot);

        } catch (SQLException e) {

            connectionDB.closeConnectionDB();
            JOptionPane.showMessageDialog(null, e);

            ch = null;

        }

        return ch;

    }

    /**
     * Hace una consulta a la base de datos para contar la cantidad de
     * nacionales y extranjeros, luego con la ayuda de un objeto de tipo
     * DefaultPieDataset rellena al gráfico con los datos obtenidos de la
     * consulta realizada, al final le da un estilo más específico al objeto
     * JFreeChart.
     *
     * @return Retorna un objeto de tipo JFreeChart relleno de datos y con un
     * estilo específico.
     * @throws SQLException Controla los errores de tipo SQL que se pudieran dar
     * por la consulta de información a la base de datos.
     */
    public static JFreeChart generateGraphDonutNationalityPatients() throws SQLException {

        String queryNationalPatients = "SELECT COUNT(nationality_patient) FROM "
                + "patients WHERE nationality_patient = \"Costa Rica\"";
        String queryForeignPatients = "SELECT COUNT(nationality_patient) FROM "
                + "patients WHERE nationality_patient != \"Costa Rica\"";

        DefaultPieDataset dts = new DefaultPieDataset();

        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.getConnectionDB();

        PreparedStatement ps;
        ResultSet rs;

        ChartPanel chp;
        JFreeChart ch;

        try {

            ps = connection.prepareStatement(queryNationalPatients);
            rs = ps.executeQuery();

            while (rs.next()) {
                dts.setValue("Nacionales", rs.getInt(1));
            }

            ps = connection.prepareStatement(queryForeignPatients);
            rs = ps.executeQuery();

            while (rs.next()) {
                dts.setValue("Extranjeros", rs.getInt(1));
            }

            connectionDB.closeConnectionDB();

            ch = ChartFactory.createRingChart("Nacionales y Extranjeros", dts, true, true, false);

            //  Style to Chart
            PiePlot plot = (PiePlot) ch.getPlot();
            plot.setBackgroundPaint(Color.white);
            // Style to chart sections
            plot.setSectionPaint("Extranjeros", new Color(3, 4, 94));
            plot.setSectionPaint("Nacionales", new Color(0, 180, 216));
            //  Graph edge disabled
            plot.setOutlineVisible(false);

            setStyleDefault(ch.getTitle(), plot);

        } catch (SQLException e) {

            connectionDB.closeConnectionDB();
            JOptionPane.showMessageDialog(null, e);

            ch = null;

        }

        return ch;

    }

}
