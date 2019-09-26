package cn.com.geovis.data_import.data_import.repository.second;

import cn.com.geovis.data_import.data_import.model.second.AnalysisDatas;
import org.postgresql.util.PGobject;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class AnalysisDataRepository {


    @Transactional
    public void batchInsert(List<AnalysisDatas> list) {
        PGobject jsonObject = new PGobject();
        jsonObject.setType("jsonb");
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://192.168.5.77:54321/gv_dm_test?rewriteBatchedStatements=true";
            Connection conn = DriverManager.getConnection(url, "postgres", "postgres");
            String sql = "insert INTO analysis_datas(file_name,geom," +
                    "info)" +
                    "values( ?,ST_GeometryFromText(?),?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            conn.setAutoCommit(false);
            for (int i = 0; i < list.size(); i++) {
                ps.setString(1, list.get(i).getFileName());
                ps.setString(2, list.get(i).getGeom().toString());
                jsonObject.setValue(list.get(i).getInfo());
                ps.setObject(3, jsonObject);

                ps.addBatch();
                if ((i + 1) % 1000 == 0) {
                    ps.executeBatch();
                    conn.commit();
                    ps.clearBatch();
                }
            }
            ps.executeBatch();
            conn.commit();
            ps.clearBatch();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
