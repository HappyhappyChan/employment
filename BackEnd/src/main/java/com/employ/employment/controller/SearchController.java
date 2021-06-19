package com.employ.employment.controller;

import com.employ.employment.entity.AjaxJson;
import com.employ.employment.entity.JobInfo;
import com.employ.employment.mapper.JobInfoMapper;
import com.employ.employment.service.SearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zenglr, clh
 * @program: employment
 * @packagename: com.employ.employment.controller
 * @Description 首页查找信息接口，包括查找职位信息、宣讲会信息、公告信息等
 * @create 2021-05-16-8:46 下午
 */
@RestController
@RequestMapping("/search/")
@Api
@Slf4j
public class SearchController {

    private final SearchService searchService;

    private final TimeListMongoDao timeListMongoDao;

    private final JobInfoMapper jobInfoMapper;

    @Autowired
    public SearchController(SearchService searchService, TimeListMongoDao timeListMongoDao,
                            JobInfoMapper jobInfoMapper) {
        this.searchService = searchService;
        this.timeListMongoDao = timeListMongoDao;
        this.jobInfoMapper = jobInfoMapper;

    }

    @GetMapping("getSeminarList")
    @ApiOperation("根据检索词查找所有的审核通过的宣讲会信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "query", value = "检索词 可加空格", required = true),
            @ApiImplicitParam(name = "page", value = "页码", required = true),
            @ApiImplicitParam(name = "sortType", value = "排序类型【1为按时间排，2为按匹配度排】", required = true)
    })
    public AjaxJson getSeminarList(String query, int page, int sortType){
        log.info("Start getSeminarList========");
        return searchService.getSeminarList(query, page, sortType);
    }

    @GetMapping("getJobList")
    @ApiOperation("根据检索词查找所有的审核通过的职位信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "query", value = "检索词 可加空格", required = true),
            @ApiImplicitParam(name = "page", value = "页码", required = true),
            @ApiImplicitParam(name = "sortType", value = "排序类型【1为按时间排，2为按匹配度排】", required = true)
    })
    public AjaxJson getJobList(String query, int page, int sortType){
        log.info("Start getJobList========");
        return searchService.getJobList(query, page, sortType);
    }


    /**
     * 根据JobId查询对应的岗位详情
     */
    @GetMapping("getJobInfobyJobId")
    @ApiOperation("根据JobId查询对应的岗位详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "jobId", value = "职位编号", required = true)
    })
    public AjaxJson getJobInfobyJobId(long jobId) {
        log.info("start getJobInfobyJobId=======");
        log.info("receive jobId:{}", jobId);
        JobInfo j = jobInfoMapper.getById(jobId);
        return AjaxJson.getSuccessData(j);
    }

}
