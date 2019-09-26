package cn.com.geovis.data_import.data_import.repository.second;

import cn.com.geovis.data_import.data_import.model.po.AnalysisBasicDatas;
import org.postgresql.util.PGobject;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class BasicInfoRepository {

    @Transactional
    public void batchInsert(List<AnalysisBasicDatas> analysisBasicDatasList) {
        try {

            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://192.168.5.77:54321/gv_dm_test?rewriteBatchedStatements=true";
            Connection conn = DriverManager.getConnection(url, "postgres", "postgres");
            String sql = "insert INTO analysis_basic_datas(create_time,update_time,data_entity_id,description,end_time,file_name,format,geo,image_name,info,level,resolution,satellite_id,sensor_id,start_time,type_en_name)" +
                    "values( ?,?,?,?,?,?,?,ST_GeometryFromText(?),?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            conn.setAutoCommit(false);
            for (int i = 0; i < analysisBasicDatasList.size(); i++) {
                ps.setTimestamp(1, new Timestamp(analysisBasicDatasList.get(i).getCreateTime().getTime()));
                ps.setTimestamp(2, new Timestamp(analysisBasicDatasList.get(i).getUpdateTime().getTime()));
//                ps.setInt(3, analysisBasicDatasList.get(i).getBandCount());
//                ps.setDouble(4, analysisBasicDatasList.get(i).getCloudPercent());
                ps.setLong(3, analysisBasicDatasList.get(i).getDataEntityId());
                ps.setString(4, analysisBasicDatasList.get(i).getDescription());
                ps.setTimestamp(5, analysisBasicDatasList.get(i).getEndTime());
                ps.setString(6, analysisBasicDatasList.get(i).getFileName());
                ps.setString(7, analysisBasicDatasList.get(i).getFormat());
                ps.setString(8, analysisBasicDatasList.get(i).getGeo().toString());
                ps.setString(9, analysisBasicDatasList.get(i).getImageName());
                PGobject jsonObject = new PGobject();
                jsonObject.setType("jsonb");
                jsonObject.setValue(analysisBasicDatasList.get(i).getInfo());
                ps.setObject(10, jsonObject);
                ps.setString(11, analysisBasicDatasList.get(i).getLevel());
                ps.setDouble(12, analysisBasicDatasList.get(i).getResolution());
                ps.setString(13, analysisBasicDatasList.get(i).getSatelliteId());
                ps.setString(14, analysisBasicDatasList.get(i).getSensorId());
                ps.setTimestamp(15, analysisBasicDatasList.get(i).getStartTime());
                ps.setString(16, analysisBasicDatasList.get(i).getTypeEnName());
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
