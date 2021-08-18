//package com.exanple.demo.document.test;
//
//import com.almp.common.constant.DictionaryAlmp;
//import com.almp.common.utils.DateUtils;
//import com.fpaas2.batch.dto.BatchParams;
//import com.fpaas2.batch.exception.BatchException;
//import com.fpaas2.batch.service.BatchAbstractStepExecutor;
//import com.fpaas2.config.ParamsContainer;
//import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
//import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.BufferedInputStream;
//import java.io.BufferedOutputStream;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.zip.GZIPInputStream;
//
///**
// * @description 贷款数据导入
// * @author Jason
// * @date 2020-05-27
// */
//public class DataImport extends BatchAbstractStepExecutor<Object, String> {
//    private static final Logger LOGGER = LoggerFactory.getLogger(DataImport.class);
//    private static final String PREFIX = "HS_RC_";
//    private static final String SUFFIX_N = "_N_all.tar";
//    private static final String SUFFIX_D = "_D_all.tar";
//    private static final String SUFFIX = ".gz";
//    private static final String SUFFIX_APPEND = ".OK";
//
//    @Override
//    public void execute(BatchParams batchParams, int index, String data, Object object) throws BatchException {
//        /**设置跑批量日期*/
//        String batchDate = (String)batchParams.getParams().get("batchDate");
//        if ("".equals(batchDate) || StringUtils.isBlank(batchDate)) {
//            throw new BatchException("贷款数据同步，批量日期不能为空！");
//        }
//
//        //日终文件日期，取前一天日期
//        String batachDate_N = batchDate;
//        //日初文件日期，取当前的日期
//        String batachDate_D = DateUtils.getPreDateStr(DateUtils.parseStrToDate(batchDate, DictionaryAlmp.DateFormat.Date_UPP_2));
//
//        /**Get公共参数*/
//        String filePath = ParamsContainer.getString("downFilePath");
//        String database = ParamsContainer.getString("orclDatabase");
//        String orclUser = ParamsContainer.getString("orclUser");
//        String orclPass = ParamsContainer.getString("orclPass");
//
//        /*检查信贷核算提供的文件是否已经下载完成，判断依据.ok文件是否存在，指的是日终文件*/
//        if (!isFileExists(batachDate_N, "N", filePath.concat(batachDate_N).concat(File.separator))) {
////            throw new BatchException(PREFIX.concat(batachDate_N).concat(SUFFIX_N).concat(SUFFIX_APPEND) + "文件不存在！");
//        }
//        /**检查信贷核算提供的文件是否已经下载完成，判断依据.ok文件是否存在，指的是日初文件*/
//        if (!isFileExists(batachDate_D, "D", filePath.concat(batachDate_D).concat(File.separator))) {
////            throw new BatchException(PREFIX.concat(batachDate_D).concat(SUFFIX_D).concat(SUFFIX_APPEND) + "文件不存在！");
//        }
//
//        /**解压文件处理*/
//        String dirN = null;
//        String dirD = null;
//        try {
//            dirN = unTarFile(batachDate_N, "N", filePath.concat(batachDate_N).concat(File.separator)).concat(File.separator);
//            dirD = unTarFile(batachDate_D, "D", filePath.concat(batachDate_D).concat(File.separator)).concat(File.separator);
//        } catch (Exception e) {
//            throw new BatchException("执行解压文件处理异常，异常信息：", e);
//        }
//
//
//        try {
//            /**借据信息文件数据导入到数据库临时表中*/
//            String loanFileName = ParamsContainer.getString("loanFileName");
//            String loantableName = ParamsContainer.getString("loantableName");
//            String fieldLoan = ParamsContainer.getString("fieldLoan");
//            String loanCtlFileName = ParamsContainer.getString("loanCtlFileName");
//            unGzipFile(loanFileName, dirD);
//            crtFileWriter(dirD, loanFileName, loantableName, fieldLoan, loanCtlFileName);
//            executive(orclUser, orclPass, database, dirD, loanCtlFileName);
//        } catch (Exception e) {
////            logger.error("执行借据信息文件数据导入异常，异常信息:[{}]",e);
//            throw new BatchException("执行借据信息文件数据导入异常，异常信息：", e);
//        }
//
//
//        try {
//            /**还款记录文件数据导入到数据库临时表中*/
//            String setlmtFileName = ParamsContainer.getString("setlmtFileName");
//            String setlmttableName = ParamsContainer.getString("setlmttableName");
//            String fieldSetLmt = ParamsContainer.getString("fieldSetLmt");
//            String setlmtCtlFileName = ParamsContainer.getString("setlmtCtlFileName");
//
//            unGzipFile(setlmtFileName, dirN);
//            crtFileWriter(dirN, setlmtFileName, setlmttableName, fieldSetLmt, setlmtCtlFileName);
//            executive(orclUser, orclPass, database, dirN, setlmtCtlFileName);
//
//            unGzipFile(setlmtFileName, dirD);
//            crtFileWriterExt(dirD, setlmtFileName, setlmttableName, fieldSetLmt, setlmtCtlFileName);
//            executive(orclUser, orclPass, database, dirD, setlmtCtlFileName);
//        } catch (Exception e) {
////            logger.error("执行还款记录文件数据导入异常，异常信息:[{}]",e);
////            throw new BatchException("执行还款记录文件数据导入异常，异常信息：", e);
//        }
//
//
//        try {
//            /**还款日志文件数据导入到数据库临时表中*/
//            String pmLogFileName = ParamsContainer.getString("pmLogFileName");
//            String pmlogtableName = ParamsContainer.getString("pmlogtableName");
//            String fieldPmLog = ParamsContainer.getString("fieldPmLog");
//            String pmlogCtlFileName = ParamsContainer.getString("pmlogCtlFileName");
//
//            unGzipFile(pmLogFileName, dirN);
//            crtFileWriter(dirN, pmLogFileName, pmlogtableName, fieldPmLog, pmlogCtlFileName);
//            executive(orclUser, orclPass, database, dirN, pmlogCtlFileName);
//
//            unGzipFile(pmLogFileName, dirD);
//            crtFileWriterExt(dirD, pmLogFileName, pmlogtableName, fieldPmLog, pmlogCtlFileName);
//            executive(orclUser, orclPass, database, dirD, pmlogCtlFileName);
//        } catch (Exception e) {
////            logger.error("执行还款日志文件数据导入异常，异常信息:[{}]",e);
////            throw new BatchException("执行还款日志文件数据导入异常，异常信息：", e);
//        }
//
//
//        try {
//            /**基准利率文件数据导入到数据库临时表中*/
//            String intRatFileName = ParamsContainer.getString("intRatFileName");
//            String intRattableName = ParamsContainer.getString("intRattableName");
//            String fieldIntRat = ParamsContainer.getString("fieldIntRat");
//            String intRatCtlFileName = ParamsContainer.getString("intRatCtlFileName");
//            unGzipFile(intRatFileName, dirD);
//            crtFileWriter(dirD, intRatFileName, intRattableName, fieldIntRat, intRatCtlFileName);
//            executive(orclUser, orclPass, database, dirD, intRatCtlFileName);
//        } catch (Exception e) {
////            logger.error("基准利率文件数据导入异常，异常信息:[{}]",e);
////            throw new BatchException("基准利率文件数据导入异常，异常信息：", e);
//        }
//
//
//        try {
//            /**利率类型文件数据导入到数据库临时表中*/
//            String ratTypFileName = ParamsContainer.getString("ratTypFileName");
//            String ratTyptableName = ParamsContainer.getString("ratTyptableName");
//            String fieldRatTyp = ParamsContainer.getString("fieldRatTyp");
//            String ratTypCtlFileName = ParamsContainer.getString("ratTypCtlFileName");
//            unGzipFile(ratTypFileName, dirD);
//            crtFileWriter(dirD, ratTypFileName, ratTyptableName, fieldRatTyp, ratTypCtlFileName);
//            executive(orclUser, orclPass, database, dirD, ratTypCtlFileName);
//        } catch (Exception e) {
////            logger.error("利率类型文件数据导入异常，异常信息:[{}]",e);
////            throw new BatchException("利率类型文件数据导入异常，异常信息：", e);
//        }
//
//    }
//
//    /**
//     * 生成控制文件.ctl
//     * @param filePath 文件路径
//     * @param fileName 文件名称
//     * @param tableName 表名
//     * @param fieldName 字段
//     * @param ctlFileName 控制文件名
//     */
//    public void crtFileWriter(String filePath, String fileName, String tableName, String fieldName, String ctlFileName) throws Exception {
//        String strCtl = "OPTIONS (skip=0)" +
//                " LOAD DATA " +
//                " CHARACTERSET 'ZHS16GBK'" +
//                " INFILE '" + filePath + "" + fileName + "' \"" + "str'|$|'\"" +
//                " TRUNCATE INTO TABLE " + tableName + "" +
//                " FIELDS TERMINATED BY X'01'" +
//                " TRAILING NULLCOLS " + fieldName;
//
//        FileWriter fileWriter = null;
//        try {
//            fileWriter = new FileWriter(filePath.concat(ctlFileName));
//            fileWriter.write(strCtl.toString());
//        } finally {
//            if (fileWriter != null) {
//                try {
//                    fileWriter.flush();
//                    fileWriter.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    public void crtFileWriterExt(String filePath, String fileName, String tableName, String fieldName, String ctlFileName) throws Exception {
//        String strCtl = "OPTIONS (skip=0)" +
//                " LOAD DATA " +
//                " CHARACTERSET 'ZHS16GBK'" +
//                " INFILE '" + filePath + "" + fileName + "' \"" + "str'|$|'\"" +
//                " APPEND INTO TABLE " + tableName + "" +
//                " FIELDS TERMINATED BY X'01'" +
//                " TRAILING NULLCOLS " + fieldName;
//
//        FileWriter fileWriter = null;
//        try {
//            fileWriter = new FileWriter(filePath.concat(ctlFileName));
//            fileWriter.write(strCtl.toString());
//        } finally {
//            if (fileWriter != null) {
//                try {
//                    fileWriter.flush();
//                    fileWriter.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    /**
//     * 调用系统命令
//     * @param user 用户
//     * @param passwd 密码
//     * @param database 地址
//     * @param filePath 路径
//     * @param ctlFileName 控制文件
//     */
//    public void executive(String user, String passwd, String database, String filePath, String ctlFileName) throws Exception {
//        StringBuffer command = new StringBuffer();
//        command.append("sqlldr ").append(user).append("/").append(passwd).append("@").append(database).append(" control=").append(filePath).append(ctlFileName).append(" log=").append(filePath).append(ctlFileName.concat(".log")).append(" rows=10000 readsize=252840000 bindsize=252840000");
//        LOGGER.info("准备要开始执行的导入数据命令：[{}]", command.toString());
//        Process exec = Runtime.getRuntime().exec(command.toString());
//        InputStream ins = exec.getInputStream();
//        BufferedReader br = new BufferedReader(new InputStreamReader(ins));
//        String line = null;
//        while ((line = br.readLine()) != null) {
//            LOGGER.info("执行命令后的信息：[{}]", line);
//        }
//        int num = exec.waitFor();
//        if (num == 0) {
//            LOGGER.info("数据导入成功，返回值：[{}]", num);
//        } else {
//            LOGGER.info("数据导入失败，返回值：[{}]", num);
////            throw new BatchException("导入["+filePath+"]文件数据失败，请检查！");
//        }
//        exec.getOutputStream().close();
//    }
//
//    /**
//     * 解压Tar文件
//     * @param date 对账日期
//     * @param flag 日终日出标志
//     */
//    public String unTarFile(String date, String flag, String filePath) throws Exception {
//        String localFileName = null;
//        FileInputStream fis = null;
//        BufferedInputStream bis = null;
//        TarArchiveInputStream tis = null;
//        FileOutputStream fos = null;
//        BufferedOutputStream bos = null;
//        try {
//            String fileName = null;
//            if ("D".equals(flag)) {
//                fileName = PREFIX.concat(date).concat(SUFFIX_D);
//            } else {
//                fileName = PREFIX.concat(date).concat(SUFFIX_N);
//            }
//            fis = new FileInputStream(new File(filePath.concat(fileName)));
//            bis = new BufferedInputStream(fis);
//            tis = new TarArchiveInputStream(bis);
//            LOGGER.info("解压{}文件开始..................", fileName);
//            TarArchiveEntry entry = null;
//            while (null != (entry = (TarArchiveEntry)tis.getNextEntry())) {
//                if (entry.isDirectory() || null == entry.getName()) {
//                    continue;
//                }
//                File file = new File(filePath, entry.getName());
//                if ("D".equals(flag)) {
//                    localFileName = filePath.concat(PREFIX).concat(date).concat(SUFFIX_D.substring(0, 6));
//                } else {
//                    localFileName = filePath.concat(PREFIX).concat(date).concat(SUFFIX_N.substring(0, 6));
//                }
//                File localFile = new File(localFileName);
//                if (!localFile.exists()) {
//                    localFile.mkdir();
//                }
//                fos = new FileOutputStream(localFileName.concat(File.separator).concat(file.getName()));
//                bos = new BufferedOutputStream(fos);
//                byte[] bytes = new byte[1024];
//                int count = 0;
//                while ((count = tis.read(bytes)) != -1) {
//                    bos.write(bytes, 0 ,count);
//                }
//                bos.flush();
//                bos.close();
//            }
//            LOGGER.info("解压{}文件结束..................", fileName);
//        } finally {
//            try {
//                if (null != fos) {
//                    fos.close();
//                }
//                if (null != tis) {
//                    tis.close();
//                }
//                if (null != bis) {
//                    bis.close();
//                }
//                if (null != fis) {
//                    fis.close();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return localFileName;
//    }
//
//    /**
//     * 解压gz文件
//     * @param fileName
//     * @param filePath
//     */
//    public void unGzipFile(String fileName, String filePath) throws Exception{
//        FileInputStream fis = null;
//        GZIPInputStream gzs = null;
//        FileOutputStream fos = null;
//        try {
//            LOGGER.info("解压{}文件开始..................", fileName.concat(SUFFIX));
//            fis = new FileInputStream(filePath.concat(File.separator).concat(fileName).concat(SUFFIX));
//            gzs = new GZIPInputStream(fis);
//            fos = new FileOutputStream(filePath.concat(File.separator).concat(fileName));
//            byte[] bytes = new byte[1024];
//            int count = 0;
//            while ((count = gzs.read(bytes)) != -1) {
//                fos.write(bytes, 0 ,count);
//            }
//            fos.flush();
//            fos.close();
//            LOGGER.info("解压{}文件结束..................", fileName.concat(SUFFIX));
//        } finally {
//            try {
//                if (null != fos) {
//                    fos.close();
//                }
//                if (null != fis) {
//                    fis.close();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public boolean isFileExists(String date, String flag, String filePath) {
//        String fileName = null;
//        if ("D".equals(flag)) {
//            fileName = PREFIX.concat(date).concat(SUFFIX_D).concat(SUFFIX_APPEND);
//        } else {
//            fileName = PREFIX.concat(date).concat(SUFFIX_N).concat(SUFFIX_APPEND);
//        }
//        LOGGER.info("检查文件[{}]是否存在！", filePath.concat(fileName));
//        return new File(filePath.concat(fileName)).exists();
//    }
//
//}