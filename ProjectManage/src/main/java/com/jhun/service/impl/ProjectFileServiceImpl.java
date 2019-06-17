package com.jhun.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jhun.dao.DownloadMapper;
import com.jhun.entity.Download;
import com.jhun.service.ProjectFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;

@Service
public class ProjectFileServiceImpl implements ProjectFileService {

    @Autowired
    private DownloadMapper downloadMapper;

    @Override
    public void down(HttpServletRequest request, HttpServletResponse response, int id) {
        Download download = downloadMapper.selectByPrimaryKey(id);
        String path = System.getProperty("user.dir");
        //path = path.substring(0,path.lastIndexOf("\\"));  //去掉\及后面的地址
        String realPath = path+ File.separator+"Files"+File.separator+download.getFileName();
        File file = new File(realPath);// path是根据日志路径和文件名拼接出来的
        String filename = file.getName();// 获取日志文件名称
        InputStream fis;
        try {
            fis = new BufferedInputStream(new FileInputStream(realPath));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            response.reset();
            // 先去掉文件名称中的空格,然后转换编码格式为utf-8,保证不出现乱码,这个文件名称用于浏览器的下载框中自动显示的文件名
            response.addHeader("Content-Disposition", "attachment;filename="
                    + new String(
                    filename.replaceAll(" ", "").getBytes("utf-8"),
                    "iso8859-1"));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream os = new BufferedOutputStream(
                    response.getOutputStream());
            response.setContentType("application/octet-stream");
            os.write(buffer);// 输出文件
            os.flush();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object selectAllByPage(int page, int rows, Download download) {
        Page<Download> pagebean = PageHelper.startPage(page,rows);
        List<Download> allItems = downloadMapper.selectAll(download);
        HashMap<String ,Object> map = new HashMap<>();
        map.put("rows" ,allItems);
        map.put("total" ,pagebean.getTotal());
        return map;
    }
}

