package com.oracle.hrb.zhzw.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oracle.hrb.zhzw.bean.Org;
import com.oracle.hrb.zhzw.bean.Result;
import com.oracle.hrb.zhzw.service.OrgService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URLEncoder;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/org")
public class OrgController {
    @Autowired
    private OrgService orgService;

    @RequestMapping(method = POST)
    public Result addOrg(Org org) {
        Result r = new Result();
        System.out.println(org);
        boolean flag = orgService.addOrg(org);
        if (flag == false) {
            r.setSuccess(false);
            r.setMsg("组织机构代码或组织机构名称已存在");
        }
        return r;
    }

    @RequestMapping(method = GET)
    public Result findAll(String keyword, Integer pageNum, Integer pageSize) {
        Result r = new Result();
        if(pageNum == null || pageNum < 1) {
            pageNum = 1;
        }
        if(pageSize == null) {
            pageSize = 10;
        }
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Org> orgs = new PageInfo<>(findAll(keyword));
        r.setData(orgs);
        return r;
    }

    @RequestMapping(method = GET, path = "/findAll")
    public List<Org> findAll(String keyword) {
        if(keyword != null && keyword.length() == 0) {
            keyword = null;
        }
        List<Org> list = orgService.findAll(keyword);
        return list;
    }
    @RequestMapping(method = DELETE)
    public Result deleteOrg(@RequestParam("id") String id) {
        System.out.println(id);
        Result r = new Result();
        orgService.deleteOrg(id);
        return r;
    }
    @PutMapping
    public Result updateOrg(@Valid Org org, BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()) {
            // 输出错误信息
            List<FieldError> allErrors = bindingResult.getFieldErrors();
            for (FieldError objectError : allErrors) {
                System.out.println(objectError.getDefaultMessage());
            }
        }

        Result r = new Result();
        System.out.println(org);
        boolean flag = orgService.updateOrg(org);
        if(flag == false) {
            r.setSuccess(false);
            r.setMsg("组织机构代码证或组织机构名称已存在");
        }
        return r;
    }

    @RequestMapping(method = GET, value = "/sheet")
    public void dowloadSheet(HttpServletResponse response) throws Exception {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("组织机构表");
        // 设置列宽
        sheet.setColumnWidth(0, 4000);
        sheet.setColumnWidth(1, 4000);
        sheet.setColumnWidth(2, 4000);
        sheet.setColumnWidth(3, 4000);
        sheet.setColumnWidth(4, 4000);

        // 设置表头样式
        HSSFCellStyle cellstyle = (HSSFCellStyle) wb.createCellStyle();
        cellstyle.setAlignment(HorizontalAlignment.CENTER);// 设置居中
        HSSFFont font = wb.createFont();
        font.setBold(true);
        font.setFontName("黑体");
        font.setFontHeightInPoints((short)20);
        cellstyle.setFont(font);
        // 合并单元格
        CellRangeAddress rangeAddress = new CellRangeAddress(0,0,0,4);
        sheet.addMergedRegion(rangeAddress);

        HSSFRow title = sheet.createRow(0);
        HSSFCell cell = title.createCell(0);
        cell.setCellStyle(cellstyle);
        cell.setCellValue("组织机构表");

        // 创建表头
        HSSFRow head = sheet.createRow(1);
        head.createCell(0).setCellValue("组织机构代码");
        head.createCell(1).setCellValue("组织机构名称");
        head.createCell(2).setCellValue("组织机构地址");
        head.createCell(3).setCellValue("法人");
        head.createCell(4).setCellValue("联系电话");
        // 添加数据
        List<Org> orgs = orgService.findAll(null);
        for(int i = 0; i < orgs.size(); i++) {
            Org org = orgs.get(i);
            HSSFRow row = sheet.createRow(i + 2);
            row.createCell(0).setCellValue(org.getCode());
            row.createCell(1).setCellValue(org.getName());
            row.createCell(2).setCellValue(org.getAddress());
            row.createCell(3).setCellValue(org.getLegal());
            row.createCell(4).setCellValue(org.getPhone());
        }
        // 发送生成的电子表格
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode("组织机构表.xls", "UTF-8"));
        wb.write(response.getOutputStream());
        wb.close();
    }
    @RequestMapping(value = "check", method = POST)
    public Result checkCodeOrName(Org org) {
        Result r = new Result();
        boolean flag = orgService.checkCodeOrPasswrod(org);
        r.setSuccess(flag);
        return r;
    }

}
