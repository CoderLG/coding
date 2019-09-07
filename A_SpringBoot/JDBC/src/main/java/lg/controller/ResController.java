package lg.controller;

import com.zaxxer.hikari.HikariDataSource;
import lg.bean.GFGX_Y_DMK_DMSJ;
import lg.config.BaseConf;
import lg.service.DBHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * author: LG
 * date: 2019-09-04 11:00
 * desc:
 */
@RestController
public class ResController {
    @Autowired
    private BaseConf baseConf;

    @Autowired
    private DBHelper dbHelper;



    @GetMapping("test")
    public String test() {
        return baseConf.getName();
    }

    @Transactional
    @GetMapping(value = "/query")
    public List<GFGX_Y_DMK_DMSJ> queryDLBM() {

        System.out.println("transactional start");

        String selectStr = "SELECT *,st_astext(\"WZ\") FROM	\"GFGX_Y_DMK_DMSJ\" WHERE \"DLBM\" =500000200000052";

        List<GFGX_Y_DMK_DMSJ> dmsjs = dbHelper.pgQuery(selectStr, rs -> {

            return getDMSJList(rs,true);

        });
        int inu = 1/0;
        System.out.println("transactional end");

        return dmsjs;
    }


    private ArrayList<GFGX_Y_DMK_DMSJ> getDMSJList(ResultSet rs, Boolean flag) {
        try {
            ArrayList<GFGX_Y_DMK_DMSJ> list = new ArrayList<GFGX_Y_DMK_DMSJ>();

            while (rs.next()) {
                GFGX_Y_DMK_DMSJ obj = new GFGX_Y_DMK_DMSJ();

                obj.DMBS = rs.getString("DMBS");
                obj.DMCJBM = rs.getInt("DMCJBM");
                obj.DMMC = rs.getString("DMMC");
                obj.MS = rs.getString("MS");

                obj.DLBM = rs.getLong("DLBM");
                obj.DMMCCD = rs.getInt("DMMCCD");
                obj.DMJP = rs.getString("DMJP");
                obj.DMQP = rs.getString("DMQP");
                obj.DMBM = rs.getString("DMBM");

                obj.BDY = rs.getString("BDY");
                obj.YWMC = rs.getString("YWMC");
                if(flag == false){
                    obj.DMDZ = rs.getString("DMDZ");
                }
                obj.DMGC = rs.getInt("DMGC");

                obj.WZ = rs.getString("st_astext");

                obj.LV=rs.getInt("LV");
                list.add(obj);
            }

            return list;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
