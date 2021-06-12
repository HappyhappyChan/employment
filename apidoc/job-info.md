# 职业信息表

### 1 录入职位信息

```
/comp/addJob
```

参数

```java
            @ApiImplicitParam(name = "jobName", value = "职位名称", required = true),
            @ApiImplicitParam(name = "jobType", value = "岗位类别", required = true),
            @ApiImplicitParam(name = "jobKind", value = "招聘性质", required = true, allowableValues = "1,2,3"),
            @ApiImplicitParam(name = "jobAddress", value = "工作地点", required = true),
            @ApiImplicitParam(name = "jobCon", value = "职位描述", required = true),
            @ApiImplicitParam(name = "jobDeadline", value = "投递截止日期", required = true),
            @ApiImplicitParam(name = "salary", value = "薪资", required = true)
```

### 2 删除职位信息

/comp/deleteJobInfo

参数

```
 [Integer] jobId 
```

### 3 查找所有职位信息

/comp/getCompJobList

参数

```

```





