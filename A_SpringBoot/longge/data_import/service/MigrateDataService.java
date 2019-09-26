package cn.com.geovis.data_import.data_import.service;


import cn.com.geovis.data_import.data_import.model.po.AnalysisBasicDatas;
import cn.com.geovis.data_import.data_import.model.po.ImageMeta;
import cn.com.geovis.data_import.data_import.model.second.AnalysisDatas;
import cn.com.geovis.data_import.data_import.repository.primary.ImageMetaRepository;
import cn.com.geovis.data_import.data_import.repository.second.AnalysisDataRepository;
import cn.com.geovis.data_import.data_import.repository.second.BasicInfoRepository;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class MigrateDataService {

    @Autowired
    ImageMetaRepository imageMetaRepository;
    @Autowired
    AnalysisDataRepository analysisDataRepository;
    @Autowired
    BasicInfoRepository basicInfoRepository;

    ExecutorService customerExecutorService = Executors.newFixedThreadPool(30);

    public void migrateData() {

        BlockingQueue<AnalysisDatas> dataQ = new ArrayBlockingQueue<AnalysisDatas>(60000);
        List<AnalysisDatas> analysisDataList = new ArrayList<>(60000);
        customerExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(3);
                try {
                    while (true) {
                        int num = 2000;
                        for (int i = 0; i < num; i++) {
                            AnalysisDatas analysisData = (AnalysisDatas) dataQ.poll();
                            if (analysisData == null)
                                break;
                            analysisDataList.add(analysisData);
                        }
                        if (analysisDataList != null && analysisDataList.size() > 0) {
                            System.out.println(analysisDataList.size() + "size");
                            analysisDataRepository.batchInsert(analysisDataList);

                            analysisDataList.clear();
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Exception e=" + e.getMessage());
                }
            }
        });
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int page = 10000;
        int pageSize = 10000;
        int times = 0;

        while (times < 10000) {
            long startTime = System.currentTimeMillis();   //获取开始时间
            Pageable pageable = PageRequest.of(page, pageSize);
            Slice<ImageMeta> result = imageMetaRepository.findByBandCountIsNull(pageable);
            for (ImageMeta imageMeta : result.getContent()) {
                AnalysisDatas analysisData = new AnalysisDatas();
                imageMeta.setGeo(imageMeta.getGeo_tmp().toText());
                imageMeta.setImageName("abc");
//                imageMeta.setValidArea(imageMeta.getValidArea_tmp().toText());
                analysisData.setInfo(JSON.toJSONString(imageMeta, SerializerFeature.WriteMapNullValue, SerializerFeature.DisableCircularReferenceDetect));
                analysisData.setFileName(imageMeta.getFileName());
                analysisData.setGeom(imageMeta.getGeo_tmp());
                try {
                    dataQ.put(analysisData);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            page--;
            times++;
            long endTime = System.currentTimeMillis(); //获取结束时间

        }
    }

    public void migrateBasicData() throws InvocationTargetException, IllegalAccessException {

        //查询
        int page = 1;
        int pageSize = 1000;
        List<AnalysisBasicDatas> analysisBasicDatasList = new ArrayList<>();
        while (page < 1000000) {
            Pageable pageable = PageRequest.of(page, pageSize);
            Slice<ImageMeta> result = imageMetaRepository.findByBandCountIsNull(pageable);
            for (ImageMeta imageMeta : result.getContent()) {
                AnalysisBasicDatas analysisBasicDatas = new AnalysisBasicDatas();
                analysisBasicDatas.setCreateTime(imageMeta.getUploadTime());
                analysisBasicDatas.setUpdateTime(imageMeta.getUploadTime());
                analysisBasicDatas.setBandCount(imageMeta.getBandCount());
                analysisBasicDatas.setCloudPercent(imageMeta.getCloudPercent());
                analysisBasicDatas.setDescription(imageMeta.getDescription());
                analysisBasicDatas.setEndTime(imageMeta.getEndTime());
                analysisBasicDatas.setFileName(imageMeta.getFileName());
                analysisBasicDatas.setFormat(imageMeta.getFormat());
                analysisBasicDatas.setGeo(imageMeta.getGeo_tmp());
                analysisBasicDatas.setImageName(imageMeta.getImageName());
                analysisBasicDatas.setInfo(JSON.toJSONString(imageMeta));
                analysisBasicDatas.setLevel(imageMeta.getLevel());
                analysisBasicDatas.setResolution(imageMeta.getResolution());
                analysisBasicDatas.setSatelliteId(imageMeta.getSatelliteId());
                analysisBasicDatas.setSensorId(imageMeta.getSensorId());
                analysisBasicDatas.setStartTime(imageMeta.getStartTime());
                analysisBasicDatas.setTypeEnName(imageMeta.getDataType());
                analysisBasicDatas.setDataEntityId(Long.valueOf(imageMeta.getDataId()));
                analysisBasicDatasList.add(analysisBasicDatas);
            }
            System.out.println(analysisBasicDatasList.size());
            basicInfoRepository.batchInsert(analysisBasicDatasList);
            analysisBasicDatasList.clear();
            page++;
        }


    }


}


